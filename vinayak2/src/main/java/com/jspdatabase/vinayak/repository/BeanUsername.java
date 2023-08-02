package com.jspdatabase.vinayak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jspdatabase.vinayak.bean.Bean;

public interface BeanUsername extends JpaRepository<Bean, Integer>{
	
	@Query(value="select * from Bean where username=?1", nativeQuery=true)
	List<Bean> findByUsername(String username, String password);
	
	@Query(value="select * from Bean where username=?1 and password = ?2", nativeQuery=true)
	List<Bean> findByUsernameAndPassword(String username, String password);
	
	
//	  @Query(value="insert into Bean (username,password) values (?1,?2)"
//	  ,nativeQuery = true) List
//	<Bean> Save(String username, String password);

}
