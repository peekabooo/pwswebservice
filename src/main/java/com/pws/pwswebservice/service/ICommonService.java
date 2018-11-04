package com.pws.pwswebservice.service;

import com.pws.pwswebservice.model.*;

import java.util.List;

public interface ICommonService {
    List<Activity> displayActivityInfo(int sortMethod, int sortTag);

    List<ActivityComment> displayMainComment(int activityId);

    List<JoinActivity> displayHistoryActivity(int userId);

    CommonUser displayUserInfo(int userId);

    List<CollectionKey> displayCollection(int userId);
}
