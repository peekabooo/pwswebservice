package com.pws.pwswebservice.service;

import java.util.Date;

public interface ICompanyService {
    void publishActivity(int companyId, String activityName, Date deadline, String description, String desText, Date publishTime, Date quitTime, String registrationText, int status, int typeId, String uploadText);
    void publishGroup(String name,int num,int compayId);
}
