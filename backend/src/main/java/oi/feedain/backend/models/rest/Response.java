package oi.feedain.backend.models.rest;

public class Response {
    private String responseText;

    private Object entity;

    public Response(String responseText, Object entity) {
        this.responseText = responseText;
        this.entity = entity;
    }

    public Response(String responseText) {
        this(responseText, null);
    }

    public Response(Object entity) {
        this("", entity);
    }

    public String getResponseText() {
        return this.responseText;
    }

    public Object getEntity() {
        return this.entity;
    }
}
