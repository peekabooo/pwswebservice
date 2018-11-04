package com.pws.pwswebservice.service.impl;

import com.pws.pwswebservice.mapper.ActivityMapper;
import com.pws.pwswebservice.mapper.GroupMapper;
import com.pws.pwswebservice.model.Activity;
import com.pws.pwswebservice.model.Group;
import com.pws.pwswebservice.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CompanyServiceImpl implements ICompanyService{
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private GroupMapper groupMapper;

    @Override
    public void publishActivity(int companyId, String activityName, Date deadline, String description, String desText, Date publishTime, Date quitTime, String registrationText, int status, int typeId, String uploadText){
        Activity activity = new Activity();
        activity.setCompanyId(companyId);
        activity.setActivityName(activityName);
        activity.setDeadline(deadline);
        activity.setDescription(description);
        activity.setDesText(desText);
        activity.setPublishTime(publishTime);
        activity.setQuitTime(quitTime);
        activity.setRegistrationText(registrationText);
        activity.setStatus(status);
        activity.setTypeId(typeId);
        activity.setUploadText(uploadText);
        activityMapper.insert(activity);
    }

    @Override
    public void publishGroup(String name, int num,int companyId) {
        Group group = new Group();
        group.setCompanyId(companyId);
        group.setGroupName(name);
        group.setMemberNum(num);
        groupMapper.insertGroup(group);
    }
}
