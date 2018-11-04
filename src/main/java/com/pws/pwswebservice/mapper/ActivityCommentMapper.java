package com.pws.pwswebservice.mapper;

import com.pws.pwswebservice.model.ActivityComment;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ActivityCommentMapper {
    @Delete({
        "delete from activity_comment",
        "where dynamic_info_comment_id = #{dynamicInfoCommentId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer dynamicInfoCommentId);

    @Insert({
        "insert into activity_comment (dynamic_info_comment_id, dynamic_info_id, ",
        "time, user_id, ",
        "company_id, first_comment_id, ",
        "like_number, context)",
        "values (#{dynamicInfoCommentId,jdbcType=INTEGER}, #{dynamicInfoId,jdbcType=INTEGER}, ",
        "#{time,jdbcType=TIMESTAMP}, #{userId,jdbcType=INTEGER}, ",
        "#{companyId,jdbcType=INTEGER}, #{firstCommentId,jdbcType=INTEGER}, ",
        "#{likeNumber,jdbcType=INTEGER}, #{context,jdbcType=LONGVARCHAR})"
    })
    int insert(ActivityComment record);

    int insertSelective(ActivityComment record);

    @Select({
        "select",
        "dynamic_info_comment_id, dynamic_info_id, time, user_id, company_id, first_comment_id, ",
        "like_number, context",
        "from activity_comment",
        "where dynamic_info_comment_id = #{dynamicInfoCommentId,jdbcType=INTEGER}"
    })
    @ResultMap("com.pws.pwswebservice.mapper.ActivityCommentMapper.ResultMapWithBLOBs")
    ActivityComment selectByPrimaryKey(Integer dynamicInfoCommentId);

    int updateByPrimaryKeySelective(ActivityComment record);

    @Update({
        "update activity_comment",
        "set dynamic_info_id = #{dynamicInfoId,jdbcType=INTEGER},",
          "time = #{time,jdbcType=TIMESTAMP},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "company_id = #{companyId,jdbcType=INTEGER},",
          "first_comment_id = #{firstCommentId,jdbcType=INTEGER},",
          "like_number = #{likeNumber,jdbcType=INTEGER},",
          "context = #{context,jdbcType=LONGVARCHAR}",
        "where dynamic_info_comment_id = #{dynamicInfoCommentId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(ActivityComment record);

    @Update({
        "update activity_comment",
        "set dynamic_info_id = #{dynamicInfoId,jdbcType=INTEGER},",
          "time = #{time,jdbcType=TIMESTAMP},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "company_id = #{companyId,jdbcType=INTEGER},",
          "first_comment_id = #{firstCommentId,jdbcType=INTEGER},",
          "like_number = #{likeNumber,jdbcType=INTEGER}",
        "where dynamic_info_comment_id = #{dynamicInfoCommentId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ActivityComment record);

    @Options(useGeneratedKeys=true,keyProperty="activityCommentId",keyColumn="GENERATED_KEY")
    @Insert({
            "insert into activity_comment (activity_id, ",
            "time, user_id, ",
            "company_id, first_comment_id, ",
            "context)",
            "values ( #{activityId,jdbcType=INTEGER}, ",
            "#{time,jdbcType=TIMESTAMP}, #{userId,jdbcType=INTEGER}, ",
            "#{companyId,jdbcType=INTEGER}, #{firstCommentId,jdbcType=INTEGER}, ",
            "#{context,jdbcType=LONGVARCHAR})"
    })
    int insertMainComment(ActivityComment record);

    List<ActivityComment> selectByActivityId(@Param("activityId") int activityId);
}