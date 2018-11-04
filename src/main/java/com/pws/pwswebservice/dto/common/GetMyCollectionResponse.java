package com.pws.pwswebservice.dto.common;

import com.pws.pwswebservice.dto.BaseJsonResponse;
import com.pws.pwswebservice.model.Activity;
import com.pws.pwswebservice.model.CollectionKey;

import java.util.List;

public class GetMyCollectionResponse extends BaseJsonResponse{
    private List<CollectionKey>  activities ;

    public void setActivities(List<CollectionKey> activities) {
        this.activities = activities;
    }

    public List<CollectionKey> getActivities() {
        return activities;
    }
}
