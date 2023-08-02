package com.jspdatabase.vinayak.controller;

import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspdatabase.vinayak.bean.Bean;
import com.jspdatabase.vinayak.bean.BeanDetails;
import com.jspdatabase.vinayak.bean.SaveDetails;
import com.jspdatabase.vinayak.repository.BeanUsername;

import com.jspdatabase.vinayak.repository.SaveDetailsRepo;
import com.jspdatabase.vinayak.repository.VinayakRepositoryBean;
import com.jspdatabase.vinayak.repository.VinayakRepositoryBeanDetails;
import com.jspdatabase.vinayak.service.VinayakServiceClass;



@RestController
@Validated
@RequestMapping("/r")
public class VinayakControllerClass {
	
	
	@Autowired
	private VinayakRepositoryBean repositoryBean;
	
	@Autowired
	private VinayakRepositoryBeanDetails repositoryBeanDetails;
	
	@Autowired
	private SaveDetailsRepo saveDetailsRepo;
	
	@Autowired
	private VinayakServiceClass serviceClass;
	
	@Autowired
	private BeanUsername beanUsername;
	
	@Autowired
	public VinayakControllerClass (BeanUsername beanUsername)
	{
		this.beanUsername=beanUsername;
	}
	
	
	@GetMapping("/logindetails")
	public List<Bean> allUser()
	{
		return repositoryBean.findAll();
	}
	

	@GetMapping("/usercreate/{username}/{password}")
	public String getByUsername
	(@PathVariable @Valid String username ,@PathVariable String password)
	{	
   List<Bean> bean =serviceClass.getByUsername(username,password);
   if (!bean.isEmpty()) 
   { return "Username already exists! try different username";}
   else 
   {	
	   serviceClass.Save(username,password);
	   return "username '" + username + "' created successfully!";
	
   }
}
	
	
//	@PostMapping("/usercreate")
//	public String createUser(@RequestBody @Valid Bean bean) 
//	
//	{
//		
//		try {
//			
//			repositoryBean.save(bean);
//            return "User name created successfully.";
//        } catch (DataAccessException da) {
//           
//            return "User name alredy exist please try another username.";
//        }
//	}
	

	@GetMapping("/login/{username}/{password}")
	public List<BeanDetails> getBeanByUsername
	(@PathVariable String username ,@PathVariable String password)throws Exception
	{
		List<Bean> bean =serviceClass.getByUsername(username,password);
		   if (!bean.isEmpty()) 
		   {	
			   List<Bean> beanDetailsVerify =beanUsername.findByUsernameAndPassword(username,password);
			   if(!beanDetailsVerify.isEmpty()) {
			  
			   List<BeanDetails> beanDetailsGet =repositoryBeanDetails.findBeanByUsername1(username,password);
			   
			   
			   if(!beanDetailsGet.isEmpty())
			   {
				   List<BeanDetails> beanDetails =serviceClass.getBeanByUsername(username,password);
				   if (beanDetails.isEmpty()) {throw new Exception( "Please check username and password.");}
				   return  beanDetails;
			   }
			   else 
			   {
				   throw new Exception("Hi "+ username+"<br>"+"Your details not saved");
			   		
			   }
		   } else
		   
		   		{
				   throw new Exception( "Please check your username and password.");}
			   }
		   else 
		   {
			   throw new Exception("Account not created!. please sign up");
		   		
		   }}
	
	@PostMapping("/adddetails/{username}/{password}")
	public List<SaveDetails> addDetails
	( @PathVariable String username ,@PathVariable String password, @RequestBody SaveDetails saveDetails)throws Exception
	{	
		List<Bean> bean =serviceClass.getByUsername(username,password);
		   
		if (!bean.isEmpty()) 
		   {	
			   List<Bean> beanDetailsVerify =beanUsername.findByUsernameAndPassword(username,password);
			   if(!beanDetailsVerify.isEmpty()) {
			  
			   List<BeanDetails> beanDetailsGet =repositoryBeanDetails.findBeanByUsername1(username,password);
			   
			   if(beanDetailsGet.isEmpty())
			   {
				   //save details
				   saveDetailsRepo.save(saveDetails);
//				   List<BeanDetails> beanDetails =serviceClass.getBeanByUsername(username,password);
//				   if (beanDetails.isEmpty()) {throw new Exception( "Please check username and password.");}
//				   return  beanDetails;
			   }
			   else 
			   {
				   throw new Exception("Hi "+ username+"<br>"+"Your details already  saved");
			   		
			   }
		   } else
		   
		   		{
				   throw new Exception( "Please check your username and password.");}
			   }
		   else 
		   {
			   throw new Exception("Account not created!. please sign up");
		   		
		   }
		return null;
	}
	
}

	
	

