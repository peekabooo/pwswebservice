package com.pws.pwswebservice.mapper;

import com.pws.pwswebservice.model.ActivityType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ActivityTypeMapper {
    @Delete({
        "delete from activity_type",
        "where type_id = #{typeId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer typeId);

    @Insert({
        "insert into activity_type (type_id, type_name)",
        "values (#{typeId,jdbcType=INTEGER}, #{typeName,jdbcType=VARCHAR})"
    })
    int insert(ActivityType record);

    int insertSelective(ActivityType record);

    @Select({
        "select",
        "type_id, type_name",
        "from activity_type",
        "where type_id = #{typeId,jdbcType=INTEGER}"
    })
    @ResultMap("com.pws.pwswebservice.mapper.ActivityTypeMapper.BaseResultMap")
    ActivityType selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(ActivityType record);

    @Update({
        "update activity_type",
        "set type_name = #{typeName,jdbcType=VARCHAR}",
        "where type_id = #{typeId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ActivityType record);
}