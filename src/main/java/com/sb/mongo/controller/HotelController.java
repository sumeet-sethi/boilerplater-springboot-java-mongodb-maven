package com.sb.mongo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.mongo.entity.Hotel;
import com.sb.mongo.repository.HotelRepository;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	private HotelRepository hotelRepository;

	public HotelController(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}
	
	@GetMapping("/all")
	public List<Hotel> getAll(){
		List<Hotel> hotels = this.hotelRepository.findAll();
		return hotels;
	}
	
	@PostMapping
	public void addHotel(@RequestBody Hotel hotel) {
		this.hotelRepository.insert(hotel);
	}
	
	@PutMapping
	public void updateHotel(@RequestBody Hotel hotel) {
		this.hotelRepository.save(hotel);
	}
	
	@DeleteMapping("/{id}")
	public void deleteHotel(@PathVariable("id") String id) {
		this.hotelRepository.delete(id);
	}
	
	@GetMapping("/{id}")
	public Hotel getHotelById(@PathVariable("id") String id) {
		Hotel hotel = this.hotelRepository.findById(id);
		return hotel;
	}
	
	@GetMapping("/price/{maxPrice}")
	public List<Hotel> getHotelByPricePerNight(@PathVariable("maxPrice") int maxPrice){
		List<Hotel> hotels = this.hotelRepository.findByPricePerNightLessThan(maxPrice);
		return hotels;
	}
	
	@GetMapping("/address/{city}")
	public List<Hotel> getHotelByCity(@PathVariable("city") String city){
		List<Hotel> hotels = this.hotelRepository.findByCity(city);
		return hotels;
	}

	
}
