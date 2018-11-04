package com.pws.pwswebservice.mapper;

import com.pws.pwswebservice.model.Activity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ActivityMapper {
    @Delete({
        "delete from activity",
        "where activity_id = #{activityId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer activityId);

    @Options(useGeneratedKeys=true,keyProperty="activityId")
    @Insert({
        "insert into activity ( activity_name, ",
        "type_id, company_id, ",
        "des_text, registration_text, ",
        "deadline, quit_time, ",
        "publish_time, status, ",
        "upload_text, description)",
        "values ( #{activityName,jdbcType=VARCHAR}, ",
        "#{typeId,jdbcType=INTEGER}, #{companyId,jdbcType=INTEGER}, ",
        "#{desText,jdbcType=VARCHAR}, #{registrationText,jdbcType=VARCHAR}, ",
        "#{deadline,jdbcType=TIMESTAMP}, #{quitTime,jdbcType=TIMESTAMP}, ",
        "#{publishTime,jdbcType=TIMESTAMP}, #{status,jdbcType=TINYINT}, ",
        "#{uploadText,jdbcType=VARCHAR}, #{description,jdbcType=LONGVARCHAR})"
    })
    int insert(Activity record);

    int insertSelective(Activity record);

    @Select({
        "select",
        "activity_id, activity_name, type_id, company_id, des_text, registration_text, ",
        "deadline, quit_time, publish_time, status, upload_text, description",
        "from activity",
        "where activity_id = #{activityId,jdbcType=INTEGER}"
    })
    @ResultMap("com.pws.pwswebservice.mapper.ActivityMapper.ResultMapWithBLOBs")
    Activity selectByPrimaryKey(Integer activityId);

    int updateByPrimaryKeySelective(Activity record);

    @Update({
        "update activity",
        "set activity_name = #{activityName,jdbcType=VARCHAR},",
          "type_id = #{typeId,jdbcType=INTEGER},",
          "company_id = #{companyId,jdbcType=INTEGER},",
          "des_text = #{desText,jdbcType=VARCHAR},",
          "registration_text = #{registrationText,jdbcType=VARCHAR},",
          "deadline = #{deadline,jdbcType=TIMESTAMP},",
          "quit_time = #{quitTime,jdbcType=TIMESTAMP},",
          "publish_time = #{publishTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT},",
          "upload_text = #{uploadText,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=LONGVARCHAR}",
        "where activity_id = #{activityId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Activity record);

    @Update({
        "update activity",
        "set activity_name = #{activityName,jdbcType=VARCHAR},",
          "type_id = #{typeId,jdbcType=INTEGER},",
          "company_id = #{companyId,jdbcType=INTEGER},",
          "des_text = #{desText,jdbcType=VARCHAR},",
          "registration_text = #{registrationText,jdbcType=VARCHAR},",
          "deadline = #{deadline,jdbcType=TIMESTAMP},",
          "quit_time = #{quitTime,jdbcType=TIMESTAMP},",
          "publish_time = #{publishTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT},",
          "upload_text = #{uploadText,jdbcType=VARCHAR}",
        "where activity_id = #{activityId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Activity record);


    List<Activity> selectAllAsc();

    List<Activity> selectAllDesc();

    List<Activity> selectByTagAsc(@Param("typeId") int typeId);

    List<Activity> selectByTagDesc(@Param("typeId") int typeId);

    List<Activity> selectAllCollectedActivities(@Param("userId")int userId);
}