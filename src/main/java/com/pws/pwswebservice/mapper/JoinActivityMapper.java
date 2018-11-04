package com.pws.pwswebservice.mapper;

import com.pws.pwswebservice.model.JoinActivity;
import com.pws.pwswebservice.model.JoinActivityKey;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface JoinActivityMapper {
    @Delete({
        "delete from join_activity",
        "where user_id = #{userId,jdbcType=INTEGER}",
          "and activity_id = #{activityId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(JoinActivityKey key);

    @Insert({
        "insert into join_activity (user_id, activity_id, ",
        "status, comment)",
        "values (#{userId,jdbcType=INTEGER}, #{activityId,jdbcType=INTEGER}, ",
        "#{status,jdbcType=TINYINT}, #{comment,jdbcType=INTEGER})"
    })
    int insert(JoinActivity record);

    int insertSelective(JoinActivity record);

    @Select({
        "select",
        "user_id, activity_id, status, comment",
        "from join_activity",
        "where user_id = #{userId,jdbcType=INTEGER}",
          "and activity_id = #{activityId,jdbcType=INTEGER}"
    })
    @ResultMap("com.pws.pwswebservice.mapper.JoinActivityMapper.BaseResultMap")
    JoinActivity selectByPrimaryKey(JoinActivityKey key);

    int updateByPrimaryKeySelective(JoinActivity record);

    @Update({
        "update join_activity",
        "set status = #{status,jdbcType=TINYINT},",
          "comment = #{comment,jdbcType=INTEGER}",
        "where user_id = #{userId,jdbcType=INTEGER}",
          "and activity_id = #{activityId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(JoinActivity record);

    List<JoinActivity> selectByUserId(int userId);
}