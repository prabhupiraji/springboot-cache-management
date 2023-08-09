package com.cache.controller;


import com.cache.entity.Car;
//import com.cache.service.Service;
import com.cache.service.CarService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RestController;

	import java.util.List;
import java.util.Optional;

	/**
	 * Rest Controller for cars
	 */
	@RestController
	@RequestMapping(value = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
	public class CarRestController {

	    private final CarService carService;

	    
	    private static final Logger logger = LoggerFactory.getLogger(CarRestController.class);

	    @Autowired
	    public CarRestController(CarService carService) {
	        this.carService = carService;
	    }

//	    @GetMapping(params = {"minPrice", "maxPrice"})
//	    public List<Car> getAllFilteredByPrice(
//	            @RequestParam Double minPrice,
//	            @RequestParam Double maxPrice
//	    ){
//	        return carService.getCarsWithPriceFilter(minPrice, maxPrice);
//	    }
//
//	    @GetMapping(params = {"brand"})
//	    public List<Car> getAllFilteredByBrand(
//	            @RequestParam String brand
//	    ){
//	        return carService.getCarsWithBrandFilter(brand);
//	    }
	    
	    @GetMapping("/all/{id}")
	    public Optional<Car> getAllcars(@PathVariable long id){
	       return carService.getAllcars(id);
	    }
	    @PostMapping("/addcar")
	    public  Car addCar(@RequestBody Car car) {
			return carService.savecar(car);
	    	
	    }
	    
	    @PutMapping("/updatecar/{id}")
	    public  Car updateCar(@PathVariable long id ,@RequestBody Car car) {
	    	 car.setId(id);
			return carService.savecar(car,id);
	    	
	    }
	    @DeleteMapping("/deletecar/{id}")
	    public  void deleteCar(@PathVariable long id ) {
			carService.deleteCar(id);
	    	
	    }
	    
	    
	}

