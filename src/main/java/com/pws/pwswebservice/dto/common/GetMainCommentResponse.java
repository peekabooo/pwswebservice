package com.pws.pwswebservice.dto.common;

import com.pws.pwswebservice.dto.BaseJsonResponse;
import com.pws.pwswebservice.model.ActivityComment;
import lombok.Data;

import java.util.List;


@Data
public class GetMainCommentResponse extends BaseJsonResponse{
    private List<ActivityComment> activityComment;

    public void setActivityComment(List<ActivityComment> activityComment) {
        this.activityComment = activityComment;
    }

    public List<ActivityComment> getActivityComment() {
        return activityComment;
    }
}
