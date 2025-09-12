package com.web.SpringBootWebDemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.SpringBootWebDemo.entity.Wand;

public interface WandRepo extends JpaRepository<Wand, Integer>{

}
