package com.pws.pwswebservice.dto.common;

import lombok.Data;

@Data
public class GetMainCommentRequest {
    private int activityId;

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }
}
