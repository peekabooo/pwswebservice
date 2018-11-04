package com.pws.pwswebservice.dto.common;

import com.pws.pwswebservice.dto.BaseJsonResponse;
import com.pws.pwswebservice.model.JoinActivity;

import java.util.List;

public class GetHistoryActivityResponse extends BaseJsonResponse{
    private List<JoinActivity> activities;

    public List<JoinActivity> getActivities() {
        return activities;
    }

    public void setActivities(List<JoinActivity> activities) {
        this.activities = activities;
    }
}
