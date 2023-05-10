package com.example.junitmockito;

import java.util.Objects;

public class User {
    public static User createRegularUser(String username, String pass) {
        return new User(username, pass, UserType.REGULAR_USER);
    }

    public static User createAdminUser(String username, String pass) {
        return new User(username, pass, UserType.ADMIN_USER);
    }
    public enum UserType {REGULAR_USER, ADMIN_USER}

    private String username;
    private String password;
    private boolean live = true;
    private final UserType userType;

    public User(String username, String password, UserType userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLive() {
        return live;
    }

    public UserType getUserType() {
        return userType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        if (live != user.live) return false;
        return username.equals(user.username) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
