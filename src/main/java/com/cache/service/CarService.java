package com.cache.service;



	import java.util.ArrayList;
	import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cache.entity.Car;
import com.cache.repo.CarRepository;

import ch.qos.logback.classic.Logger;

import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.LoggerFactory;
//import org.hibernate.cache.spi.SecondLevelCacheLogger_.logger;
//import org.hibernate.boot.jaxb.JaxbLogger_.logger;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
	@Service
	public class CarService {

		@Autowired
		CarRepository repo;
		 private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(CarService.class);

		
//	    private List<Car> cars = new ArrayList<>(
//	            List.of(
//	                    new Car(1L, "Astra", "Opel", 100, 18000d),
//	                    new Car(2L, "Insignia", "Opel", 120, 22000d),
//	                    new Car(3L, "Golf", "VW", 90, 17000d),
//	                    new Car(4L, "Golf", "VW", 120, 19000d),
//	                    new Car(5L, "Gallardo", "Lamborghini", 400, 100_000d)
//	            ));
	    
//	    @Cacheable(value="priceFilterCache" , key = "#root.method")
//	    public List<Car> getCarsWithPriceFilter(Double min, Double max) {
//	        return cars.stream()
//	                .filter(car -> car.getPrice() >= min && car.getPrice() <= max)
//	                .toList();
//	    }
//	    @Cacheable(value="priceFilterCache" , key = "#root.target")
//	    public List<Car> getCarsWithPriceFilter(Double min, Double max) {
//	        return cars.stream()
//	                .filter(car -> car.getPrice() >= min && car.getPrice() <= max)
//	                .toList();
//	    }
//	    @Cacheable(value="priceFilterCache" , key = "#root.caches")
//	    public List<Car> getCarsWithPriceFilter(Double min, Double max) {
//	        return cars.stream()
//	                .filter(car -> car.getPrice() >= min && car.getPrice() <= max)
//	                .toList();
//	    }
//
//
//	    
//	    public List<Car> getCarsWithBrandFilter(String brand) {
//	        return cars.stream()
//	                .filter(car -> car.getBrand().equals(brand))
//	                .toList();
//	    }

		

	    @Cacheable(value="addingcarfilter" , key = "#root.method")
		public Car savecar(Car car) {
			// TODO Auto-generated method stub
	    	Logger.info("new car details added to db");
			return repo.save(car);
		}

    
         @CachePut(value="updatingcarfilter" , key = "#root.method")
		public Car savecar(Car car, long id) {
			// TODO Auto-generated method stub
        	 Logger.info("car updated");
			return repo.save(car);
		}


         @CacheEvict(value="deletingcarfilter" , key = "#root.method")
		public void deleteCar(long id) {
//SLF4JLogger slf4jLogger = new SLF4JLogger(null, null);
			//			Logger logger = new Logger(null, null, null);
			// TODO Auto-generated method stub
        	 Logger.info("car deleted by cahche");
			repo.deleteById(id);;
		}


         @CacheEvict(value="getallcarfilter" , key = "#root.method")
		public Optional<Car> getAllcars(long id) {
			// TODO Auto-generated method stub
        	 Logger.info("car details getting by id");
			return repo.findById(id);
		}


	}

