package com.weather.dom;

/**
 * Enum for user roles.
 *
 * @author Khaled Kandil
 *
 */
public enum Roles {
    ROLE_USER("ROLE_USER"), ROLE_ADMIN("ROLE_ADMIN");

    private String role;

    private Roles(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
