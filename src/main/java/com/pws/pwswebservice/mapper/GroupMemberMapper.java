package com.pws.pwswebservice.mapper;

import com.pws.pwswebservice.model.GroupMemberKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

public interface GroupMemberMapper {
    @Delete({
        "delete from group_member",
        "where group_id = #{groupId,jdbcType=INTEGER}",
          "and user_id = #{userId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(GroupMemberKey key);

    @Insert({
        "insert into group_member (group_id, user_id)",
        "values (#{groupId,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER})"
    })
    int insert(GroupMemberKey record);

    int insertSelective(GroupMemberKey record);
}