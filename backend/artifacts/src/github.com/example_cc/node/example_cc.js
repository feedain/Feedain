/*
# Copyright IBM Corp. All Rights Reserved.
#
# SPDX-License-Identifier: Apache-2.0
*/

const shim = require('fabric-shim');
const util = require('util');

var Chaincode = class {

  // Initialize the chaincode
  async Init(stub) {
    console.info('========= example_cc Init =========');
    let ret = stub.getFunctionAndParameters();
    console.info(ret);
    let args = ret.params;
    
    // initialise only if 4 parameters passed.
    if (args.length != 3) {
      return shim.error('Incorrect number of arguments. Expecting 3');
    }

    let works = {};
    works.id = "all_works";
    works.works = [];

    let work = {};
    work.id = "work_1";
    work.published = new Date();
    work.content = args[0];
    work.feedback = [];

    let firstFeedback = {};
    let secondFeedback = {};

    firstFeedback.submitted = new Date();
    firstFeedback.content = args[1];
    secondFeedback.submitted = new Date();
    secondFeedback.content = args[2];

    work.feedback.push(firstFeedback, secondFeedback);
    
    works.works.push(work);

    let worksJson = JSON.stringify(works);
    let workJson = JSON.stringify(work);

    try {
      await stub.putState(works.id, worksJson)
      await stub.putState(work.id, workJson);

      return shim.success();  
    } catch (err) {
      return shim.error(err);
    }
  }

  async Invoke(stub) {
    let ret = stub.getFunctionAndParameters();
    console.info(ret);
    let method = this[ret.fcn];
    if (!method) {
      console.error('no method of name:' + ret.fcn + ' found');
      return shim.error('no method of name:' + ret.fcn + ' found');
    }

    console.info('\nCalling method : ' + ret.fcn);
    try {
      let payload = await method(stub, ret.params);
      return shim.success(payload);
    } catch (err) {
      console.log(err);
      return shim.error(err);
    }
  }
  
  async addWork(stub, args) {
    let worksJson = await stub.getState("all_works").toString();
    let works = JSON.parse(worksJson);

    let work = {};
    work.id = "work_" + (works.works.length + 1);
    work.published = new Date();
    work.content = args[0];
    work.feedback = [];
    works.works.push(work);

    try {
      await stub.putState(work.id, JSON.stringify(work));

      try {
        await stub.putState("all_works", JSON.stringify(works));
      }
      catch (error) {
        throw new Error("Could not update works: " + error);
      }
    }
    catch (error) {
      throw new Error("Could not add work: " + error);
    }
  }

  async addFeedback(stub, args) {
    let worksJson = await stub.getState("all_works").toString();
    let works = JSON.parse(worksJson);

    let workJson = await stub.getState(args[0]).toString();
    let work = JSON.parse(workJson);

    let feedback = {};
    feedback.submitted = new Date();
    feedback.content = args[1];

    work.feedback.push(feedback);
    works.works[works.works.indexOf(work.id)] = work;

    try {
      await stub.putState(work.id, JSON.stringify(work));

      try {
        await stub.putState("all_works", JSON.stringify(works));      
      }      
      catch (error) {
        throw new Error("Could not update works: " + error);
      }    
    }
    catch (error) {
      throw new Error("Could not add feedback: " + error);
    }

    return "Feedback added";
  }

  async move(stub, args) {
    if (args.length != 3) {
      throw new Error('Incorrect number of arguments. Expecting 3');
    }

    let A = args[0];
    let B = args[1];
    if (!A || !B) {
      throw new Error('asset holding must not be empty');
    }

    // Get the state from the ledger
    let Avalbytes = await stub.getState(A);
    if (!Avalbytes) {
      throw new Error('Failed to get state of asset holder A');
    }
    let Aval = parseInt(Avalbytes.toString());

    let Bvalbytes = await stub.getState(B);
    if (!Bvalbytes) {
      throw new Error('Failed to get state of asset holder B');
    }

    let Bval = parseInt(Bvalbytes.toString());
    // Perform the execution
    let amount = parseInt(args[2]);
    if (typeof amount !== 'number') {
      throw new Error('Expecting integer value for amount to be transaferred');
    }

    Aval = Aval - amount;
    Bval = Bval + amount;
    console.info(util.format('Aval = %d, Bval = %d\n', Aval, Bval));

    // Write the states back to the ledger
    await stub.putState(A, Buffer.from(Aval.toString()));
    await stub.putState(B, Buffer.from(Bval.toString()));

  }

  // Deletes an entity from state
  async delete(stub, args) {
    if (args.length != 1) {
      throw new Error('Incorrect number of arguments. Expecting 1');
    }

    let A = args[0];

    // Delete the key from the state in ledger
    await stub.deleteState(A);
  }

  // query callback representing the query of a chaincode
  async query(stub, args) {
    if (args.length != 1) {
      throw new Error('Incorrect number of arguments. Expecting name of the person to query')
    }

    let jsonResp = {};
    let A = args[0];

    // Get the state from the ledger
    let Avalbytes = await stub.getState(A);
    if (!Avalbytes) {
      jsonResp.error = 'Failed to get state for ' + A;
      throw new Error(JSON.stringify(jsonResp));
    }

    jsonResp.name = A;
    jsonResp.amount = Avalbytes.toString();
    console.info('Query Response:');
    console.info(jsonResp);
    return Avalbytes;
  }
};

shim.start(new Chaincode());
