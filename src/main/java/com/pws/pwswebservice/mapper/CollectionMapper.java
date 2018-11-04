package com.pws.pwswebservice.mapper;

import com.pws.pwswebservice.model.Activity;
import com.pws.pwswebservice.model.CollectionKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectionMapper {
    @Delete({
        "delete from collection",
        "where user_id = #{userId,jdbcType=INTEGER}",
          "and activity_id = #{activityId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(CollectionKey key);

    @Insert({
        "insert into collection (user_id, activity_id)",
        "values (#{userId,jdbcType=INTEGER}, #{activityId,jdbcType=INTEGER})"
    })
    int insert(CollectionKey record);

    int insertSelective(CollectionKey record);



    List<CollectionKey> selectByPrimaryKey(@Param("userId") int userId);
}