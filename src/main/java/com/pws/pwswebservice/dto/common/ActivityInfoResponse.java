package com.pws.pwswebservice.dto.common;

import com.pws.pwswebservice.dto.BaseJsonResponse;
import com.pws.pwswebservice.model.Activity;

import java.util.List;

public class ActivityInfoResponse extends BaseJsonResponse{
        private List<Activity> activities;

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public List<Activity> getActivities() {
        return activities;
    }
}
