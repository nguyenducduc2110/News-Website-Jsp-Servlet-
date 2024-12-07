package com.webspringmvc.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.webspringmvc.entity.NewsEntity;




public interface NewsRepository extends JpaRepository<NewsEntity, Long>{
	
}
