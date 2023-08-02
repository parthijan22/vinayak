package com.jspdatabase.vinayak.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.jspdatabase.vinayak.bean.Bean;


@Repository
public interface VinayakRepositoryBean extends JpaRepository<Bean, Integer> {

	

}
