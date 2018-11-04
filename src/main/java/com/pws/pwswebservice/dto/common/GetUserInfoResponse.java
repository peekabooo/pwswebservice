package com.pws.pwswebservice.dto.common;

import com.pws.pwswebservice.dto.BaseJsonResponse;
import com.pws.pwswebservice.model.CommonUser;

public class GetUserInfoResponse extends BaseJsonResponse{
    private CommonUser commonUser;

    public CommonUser getCommonUser() {
        return commonUser;
    }

    public void setCommonUser(CommonUser commonUser) {
        this.commonUser = commonUser;
    }
}
