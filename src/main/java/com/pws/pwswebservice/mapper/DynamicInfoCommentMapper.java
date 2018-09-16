package com.pws.pwswebservice.mapper;

import com.pws.pwswebservice.model.DynamicInfoComment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface DynamicInfoCommentMapper {
    @Delete({
        "delete from dynamic_info_comment",
        "where activity_comment_id = #{activityCommentId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer activityCommentId);

    @Insert({
        "insert into dynamic_info_comment (activity_comment_id, activity_id, ",
        "time, user_id, ",
        "company_id, first_comment_id, ",
        "like_number, context)",
        "values (#{activityCommentId,jdbcType=INTEGER}, #{activityId,jdbcType=INTEGER}, ",
        "#{time,jdbcType=TIMESTAMP}, #{userId,jdbcType=INTEGER}, ",
        "#{companyId,jdbcType=INTEGER}, #{firstCommentId,jdbcType=INTEGER}, ",
        "#{likeNumber,jdbcType=INTEGER}, #{context,jdbcType=LONGVARCHAR})"
    })
    int insert(DynamicInfoComment record);

    int insertSelective(DynamicInfoComment record);

    @Select({
        "select",
        "activity_comment_id, activity_id, time, user_id, company_id, first_comment_id, ",
        "like_number, context",
        "from dynamic_info_comment",
        "where activity_comment_id = #{activityCommentId,jdbcType=INTEGER}"
    })
    @ResultMap("com.pws.pwswebservice.mapper.DynamicInfoCommentMapper.ResultMapWithBLOBs")
    DynamicInfoComment selectByPrimaryKey(Integer activityCommentId);

    int updateByPrimaryKeySelective(DynamicInfoComment record);

    @Update({
        "update dynamic_info_comment",
        "set activity_id = #{activityId,jdbcType=INTEGER},",
          "time = #{time,jdbcType=TIMESTAMP},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "company_id = #{companyId,jdbcType=INTEGER},",
          "first_comment_id = #{firstCommentId,jdbcType=INTEGER},",
          "like_number = #{likeNumber,jdbcType=INTEGER},",
          "context = #{context,jdbcType=LONGVARCHAR}",
        "where activity_comment_id = #{activityCommentId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(DynamicInfoComment record);

    @Update({
        "update dynamic_info_comment",
        "set activity_id = #{activityId,jdbcType=INTEGER},",
          "time = #{time,jdbcType=TIMESTAMP},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "company_id = #{companyId,jdbcType=INTEGER},",
          "first_comment_id = #{firstCommentId,jdbcType=INTEGER},",
          "like_number = #{likeNumber,jdbcType=INTEGER}",
        "where activity_comment_id = #{activityCommentId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(DynamicInfoComment record);
}