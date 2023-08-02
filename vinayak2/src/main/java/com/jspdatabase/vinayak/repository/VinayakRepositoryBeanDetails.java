package com.jspdatabase.vinayak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jspdatabase.vinayak.bean.BeanDetails;



@Repository
public interface VinayakRepositoryBeanDetails extends JpaRepository<BeanDetails, String> {
	
	
	@Query(value="select * from BeanDetails inner join Bean "
			+ "on Bean.username=BeanDetails.username where Bean.username=?1 and Bean.password=?2 "
			+ "and BeanDetails.username=?1", nativeQuery=true)
	List<BeanDetails> findBeanByUsername(String username,String password);
	
	@Query(value="select * from BeanDetails where username=?1",nativeQuery=true)
	List<BeanDetails> findBeanByUsername1(String username,String password);
	
	@Query(value="select * from BeanDetails where username=?1 and password=?2",nativeQuery=true)
	List<BeanDetails> findBeanByUsernamePassword(String username,String password);
//			@Query(value="insert into BeanDetails (username,name,password)(?,?,?)")
//	public List<BeanDetails>SaveData(BeanDetails,String);

}
