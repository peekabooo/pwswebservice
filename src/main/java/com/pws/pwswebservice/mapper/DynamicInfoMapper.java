package com.pws.pwswebservice.mapper;

import com.pws.pwswebservice.model.DynamicInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface DynamicInfoMapper {
    @Delete({
        "delete from dynamic_info",
        "where dynamic_info_id = #{dynamicInfoId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer dynamicInfoId);

    @Insert({
        "insert into dynamic_info (dynamic_info_id, picture_address, ",
        "company_id, time, ",
        "like_number, context)",
        "values (#{dynamicInfoId,jdbcType=INTEGER}, #{pictureAddress,jdbcType=VARCHAR}, ",
        "#{companyId,jdbcType=INTEGER}, #{time,jdbcType=TIMESTAMP}, ",
        "#{likeNumber,jdbcType=INTEGER}, #{context,jdbcType=LONGVARCHAR})"
    })
    int insert(DynamicInfo record);

    int insertSelective(DynamicInfo record);

    @Select({
        "select",
        "dynamic_info_id, picture_address, company_id, time, like_number, context",
        "from dynamic_info",
        "where dynamic_info_id = #{dynamicInfoId,jdbcType=INTEGER}"
    })
    @ResultMap("com.pws.pwswebservice.mapper.DynamicInfoMapper.ResultMapWithBLOBs")
    DynamicInfo selectByPrimaryKey(Integer dynamicInfoId);

    int updateByPrimaryKeySelective(DynamicInfo record);

    @Update({
        "update dynamic_info",
        "set picture_address = #{pictureAddress,jdbcType=VARCHAR},",
          "company_id = #{companyId,jdbcType=INTEGER},",
          "time = #{time,jdbcType=TIMESTAMP},",
          "like_number = #{likeNumber,jdbcType=INTEGER},",
          "context = #{context,jdbcType=LONGVARCHAR}",
        "where dynamic_info_id = #{dynamicInfoId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(DynamicInfo record);

    @Update({
        "update dynamic_info",
        "set picture_address = #{pictureAddress,jdbcType=VARCHAR},",
          "company_id = #{companyId,jdbcType=INTEGER},",
          "time = #{time,jdbcType=TIMESTAMP},",
          "like_number = #{likeNumber,jdbcType=INTEGER}",
        "where dynamic_info_id = #{dynamicInfoId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(DynamicInfo record);
}