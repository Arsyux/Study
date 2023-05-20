package com.arsyux.jblog.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.arsyux.jblog.domain.User;

@Mapper
public interface UserMapper {

	// 개발자가 @Mapper가 설정된 인터페이스를 작성하면
	// 마이바티스에서 자동으로 매퍼 인터페이스가 구현된 클래스를 제공함
	@Insert("INSERT INTO USERS(ID, USERNAME, PASSWORD, EMAIL)"
			+ "VALUES((SELECT NVL(MAX(ID), 0) + 1 FROM USERS), #{username}, #{password}, #{email})")
	public void insertUser(User user);
	
	@Update("UPDATE USERS PASSWORD = #{password}, EMAIL = #{email} WHERE ID = #{id}")
	public void updateUser(User user);
	
	@Delete("DELETE USERS WHERE ID = #{id}")
	public void deleteUser(User user);
	
	@Select("SELECT * FROM USERS WHERE USERNAME = #{username}")
	public void getUser(User user);
	
	@Select("SELECT * FROM USERS ORDER BY USERNAME DESC")
	public void getUserList();
	
}
