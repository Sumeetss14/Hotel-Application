package com.sumeet.hotel.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.sumeet.hotel.exceptions.HotelNotFoundException;
import com.sumeet.hotel.model.Hotel;

@Service
public class HotelService {

	ArrayList<Hotel> hotellist=new ArrayList<>();
	HashMap<String,Hotel> hotelmap=new HashMap<>();
	public void createHotel(Hotel hotel) {
		hotellist.add(hotel);
		hotelmap.put(hotel.getId(), hotel);
	}
	
	public Hotel getHotelById(String Id) {
		if(ObjectUtils.isEmpty(hotelmap.get(Id))) {
			throw new HotelNotFoundException("Hotel not found for id:"+ Id);
		}
		return hotelmap.get(Id);	
		
	}
	
	public List<Hotel> getAllHotelList() {
		return hotellist;
	}
	
	public void deleteHotelById(String id) {
		Hotel hotel = getHotelById(id);
		hotellist.remove(hotel);
		hotelmap.remove(id);
	}

	public void updateHotel(Hotel updatedhotel) {
         Hotel existingHotel=getHotelById(updatedhotel.getId());
         hotellist.remove(existingHotel);
         hotellist.add(updatedhotel);
         hotelmap.put(updatedhotel.getId(), updatedhotel);
	}
}
