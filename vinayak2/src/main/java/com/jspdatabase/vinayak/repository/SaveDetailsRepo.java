package com.jspdatabase.vinayak.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jspdatabase.vinayak.bean.SaveDetails;





@Repository
public interface SaveDetailsRepo extends JpaRepository<SaveDetails,String>{
	
	
}
