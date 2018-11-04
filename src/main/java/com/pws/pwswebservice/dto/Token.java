package com.pws.pwswebservice.dto;

import lombok.Data;

@Data
public final class Token {

    private Role role;
    private long expireTime;
    private int id;

    public Token(Role role, int id, long expireTime) {
        this.role = role;
        this.expireTime = expireTime;
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() >= expireTime;
    }


    @Override
    public String toString() {
        return role.toString() + "_" + id + "_" + expireTime;
    }

    public int getId() {
        return id;
    }
}
