package com.pws.pwswebservice.mapper;

import com.pws.pwswebservice.model.CommonUser;
import org.apache.ibatis.annotations.*;

public interface CommonUserMapper {
    @Delete({
            "delete from common_user",
            "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userId);

    @Insert({
            "insert into common_user (user_id, nick_name, ",
            "real_name, gender, ",
            "telephone, university, ",
            "department, student_id, ",
            "point, level, password, ",
            "personal_information)",
            "values (#{userId,jdbcType=INTEGER}, #{nickName,jdbcType=VARCHAR}, ",
            "#{realName,jdbcType=VARCHAR}, #{gender,jdbcType=TINYINT}, ",
            "#{telephone,jdbcType=VARCHAR}, #{university,jdbcType=VARCHAR}, ",
            "#{department,jdbcType=VARCHAR}, #{studentId,jdbcType=VARCHAR}, ",
            "#{point,jdbcType=INTEGER}, #{level,jdbcType=DECIMAL}, #{password,jdbcType=VARCHAR}, ",
            "#{personalInformation,jdbcType=LONGVARCHAR})"
    })
    int insert(CommonUser record);

    @Select({
            "select",
            "user_id, nick_name, real_name, gender, telephone, university, department, student_id, ",
            "point, level, password, personal_information",
            "from common_user",
            "where user_id = #{userId,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    CommonUser selectByPrimaryKey(Integer userId);

    @Select({
            "select *",
            "from common_user",
            "where telephone = #{telephone,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    CommonUser findByTelephone(@Param("telephone") String telephone);

    @Update({
            "update common_user",
            "set nick_name = #{nickName,jdbcType=VARCHAR},",
            "real_name = #{realName,jdbcType=VARCHAR},",
            "gender = #{gender,jdbcType=TINYINT},",
            "telephone = #{telephone,jdbcType=VARCHAR},",
            "university = #{university,jdbcType=VARCHAR},",
            "department = #{department,jdbcType=VARCHAR},",
            "student_id = #{studentId,jdbcType=VARCHAR},",
            "point = #{point,jdbcType=INTEGER},",
            "level = #{level,jdbcType=DECIMAL},",
            "password = #{password,jdbcType=VARCHAR},",
            "personal_information = #{personalInformation,jdbcType=LONGVARCHAR}",
            "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(CommonUser record);

    @Update({
            "update common_user",
            "set nick_name = #{nickName,jdbcType=VARCHAR},",
            "real_name = #{realName,jdbcType=VARCHAR},",
            "gender = #{gender,jdbcType=TINYINT},",
            "telephone = #{telephone,jdbcType=VARCHAR},",
            "university = #{university,jdbcType=VARCHAR},",
            "department = #{department,jdbcType=VARCHAR},",
            "student_id = #{studentId,jdbcType=VARCHAR},",
            "point = #{point,jdbcType=INTEGER},",
            "level = #{level,jdbcType=DECIMAL},",
            "password = #{password,jdbcType=VARCHAR}",
            "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CommonUser record);
}