package com.cache.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cache.entity.Car;

public interface CarRepository  extends JpaRepository<Car, Long>{

	
}
