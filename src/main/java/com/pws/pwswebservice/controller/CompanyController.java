package com.pws.pwswebservice.controller;


import com.pws.pwswebservice.dto.BaseJsonResponse;
import com.pws.pwswebservice.dto.company.*;
import com.pws.pwswebservice.service.impl.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController extends BaseController{
    @Autowired
    private CompanyServiceImpl companyService;

    @RequestMapping(value="/publishActivity",method= RequestMethod.POST)
    public PublishActivityResponse publishActivity(@RequestBody PublishActivityRequest request){
        PublishActivityResponse response = new PublishActivityResponse();
        if(request.getToken()==null){
            response.setReturnCode("NL");
            response.setReturnMsg("还未登录");
        }
        else{
            int companyId = request.getToken().getId();
            String activityName = request.getActivityName();
            Date deadline = request.getDeadline();
            String description = request.getDescription();
            String desText = request.getDesText();
            Date publishTime = request.getPublishTime();
            Date quitTime = request.getQuitTime();
            String registrationText = request.getRegistrationText();
            int status = request.getStatus();
            int typeId = request.getTypeId();
            String uploadText = request.getUploadText();
            companyService.publishActivity(companyId,activityName,deadline,description,desText,publishTime,quitTime,registrationText,status,typeId,uploadText);
            response.setReturnCode("publishSucc");
            response.setReturnMsg("发布成功");
        }
        return response;
    }

    /*@RequestMapping(value="dispatchNotice",method = RequestMethod.POST)
    public DispatchNoticeResponse dispatchNotice(@RequestBody DispatchNoticeRequest request){

    }
*/

    @RequestMapping(value = "/publishGroup",method=RequestMethod.POST)
    public PublishGroupResponse publishGroup (@RequestBody PublishGroupRequest request){
        PublishGroupResponse response = new PublishGroupResponse();
        if(request.getToken()==null){
            response.setReturnCode("NL");
            response.setReturnMsg("还未登录");
        }
        else{
            String name = request.getGroupName();
            int num = request.getMemberNum();
            int companyId = request.getToken().getId();
            companyService.publishGroup(name,num,companyId);
            response.setReturnCode("publishSucc");
            response.setReturnMsg("发布成功");
        }
        return response;

    }

}
