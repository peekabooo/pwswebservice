package com.pws.pwswebservice.mapper;

import com.pws.pwswebservice.model.Group;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface GroupMapper {
    @Delete({
        "delete from group",
        "where group_id = #{groupId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer groupId);

    @Insert({
        "insert into group (group_id, group_name, ",
        "member_num, company_id)",
        "values (#{groupId,jdbcType=INTEGER}, #{groupName,jdbcType=VARCHAR}, ",
        "#{memberNum,jdbcType=INTEGER}, #{companyId,jdbcType=INTEGER})"
    })
    int insert(Group record);

    int insertSelective(Group record);

    @Select({
        "select",
        "group_id, group_name, member_num, company_id",
        "from group",
        "where group_id = #{groupId,jdbcType=INTEGER}"
    })
    @ResultMap("com.pws.pwswebservice.mapper.GroupMapper.BaseResultMap")
    Group selectByPrimaryKey(Integer groupId);

    int updateByPrimaryKeySelective(Group record);

    @Update({
        "update group",
        "set group_name = #{groupName,jdbcType=VARCHAR},",
          "member_num = #{memberNum,jdbcType=INTEGER},",
          "company_id = #{companyId,jdbcType=INTEGER}",
        "where group_id = #{groupId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Group record);
}