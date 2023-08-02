package com.jspdatabase.vinayak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspdatabase.vinayak.bean.Bean;
import com.jspdatabase.vinayak.bean.BeanDetails;
import com.jspdatabase.vinayak.repository.BeanUsername;
import com.jspdatabase.vinayak.repository.VinayakRepositoryBean;
import com.jspdatabase.vinayak.repository.VinayakRepositoryBeanDetails;


@Service
public class VinayakServiceClass {
	
	@Autowired
	private VinayakRepositoryBeanDetails VinayakRepositoryBeanDetails;
	
	@Autowired
	private BeanUsername beanUsername;
	
//	@Autowired
//	Bean bean;
	
	public VinayakServiceClass(BeanUsername beanUsername) 
	{this.beanUsername=beanUsername;}
	
	//bean class save
	public void Save (String username, String password)
	{
		
		Bean bean = new Bean();
		bean.setUsername(username);
		bean.setPassword(password);
		beanUsername.save(bean);
	}
	
	//beandetails class
	public List<BeanDetails> getBeanByUsername(String username,String password) 
    {
        return VinayakRepositoryBeanDetails.findBeanByUsername(username,password);
    }
	
	//bean class
	public List<Bean>getByUsername(String username,String password)
	{
		return beanUsername.findByUsername(username, password);
	}
	
	
	
	
	
}
