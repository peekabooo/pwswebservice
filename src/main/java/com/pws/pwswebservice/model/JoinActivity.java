package com.pws.pwswebservice.model;

public class JoinActivity extends JoinActivityKey {
    private Byte status;

    private Integer comment;

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }
}