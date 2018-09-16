package com.pws.pwswebservice.mapper;

import com.pws.pwswebservice.model.Company;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CompanyMapper {
    @Delete({
        "delete from company",
        "where company_id = #{companyId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer companyId);

    @Insert({
        "insert into company (company_id, company_name, ",
        "telephone, address, ",
        "email)",
        "values (#{companyId,jdbcType=INTEGER}, #{companyName,jdbcType=VARCHAR}, ",
        "#{telephone,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR})"
    })
    int insert(Company record);

    int insertSelective(Company record);

    @Select({
        "select",
        "company_id, company_name, telephone, address, email",
        "from company",
        "where company_id = #{companyId,jdbcType=INTEGER}"
    })
    @ResultMap("com.pws.pwswebservice.mapper.CompanyMapper.BaseResultMap")
    Company selectByPrimaryKey(Integer companyId);

    int updateByPrimaryKeySelective(Company record);

    @Update({
        "update company",
        "set company_name = #{companyName,jdbcType=VARCHAR},",
          "telephone = #{telephone,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR}",
        "where company_id = #{companyId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Company record);
}