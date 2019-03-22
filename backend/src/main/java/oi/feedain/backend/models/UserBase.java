package oi.feedain.backend.models;

public abstract class UserBase {
    private String username;

    public UserBase(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }
}
