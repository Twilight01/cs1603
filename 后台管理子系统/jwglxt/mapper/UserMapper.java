package com.cs1603.jwglxt.mapper;

import com.cs1603.jwglxt.bean.houtai.HoutaiPassword;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

    /**
     *
     * @return User[]
     */

    @Select("SELECT * FROM password")
    public HoutaiPassword[] findAll();


    /**
     *
     * @param username
     * @return a
     */
    @Select("SELECT * FROM password WHERE id=#{username}")
    public HoutaiPassword findByUsername(String username);

    @Select("SELECT * FROM password WHERE id like #{username}")
    public HoutaiPassword[] findUsername(String username);

    @Insert("INSERT INTO password(id,password,nature) VALUES(#{id},#{password},#{nature})")
    public Integer insert(HoutaiPassword user);

    @Update("update password set password=#{password},nature=#{nature} where id=#{id}")
    public Integer update(HoutaiPassword user);
    /**
     * 用户数据删除
     */
    @Delete("delete from password where id=#{id}")
    public Integer delete(String id);
}
