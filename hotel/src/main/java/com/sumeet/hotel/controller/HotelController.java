package com.sumeet.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumeet.hotel.model.Hotel;
import com.sumeet.hotel.service.HotelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	HotelService hotelService;
	
	@PostMapping("/create")
	public void createHotel(@Valid @RequestBody Hotel hotel, BindingResult bindingresult) {
	  if(bindingresult.hasErrors()) {
		  throw new RuntimeException("Request not Valid");
	  }
	 hotelService.createHotel(hotel);	
	}
	
	@GetMapping("/id/{Id}")
	public Hotel getHotelById(@PathVariable String Id)  {
		return hotelService.getHotelById(Id);
	}
	
	@GetMapping("/getAll")
	public List<Hotel> getAllHotelList(){
		return hotelService.getAllHotelList();
	}
	
	@DeleteMapping("/remove/id/{Id}")
	public void deleteHotelById(@PathVariable String Id) {
		hotelService.deleteHotelById(Id);
	}
	
	@PutMapping("/update")
	public void updateHotel(@RequestBody Hotel hotel) {
		hotelService.updateHotel(hotel);
	}
	
	
	
	
	
	
	
	
}
