package com.sb.mongo.component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sb.mongo.entity.Address;
import com.sb.mongo.entity.Hotel;
import com.sb.mongo.entity.Review;
import com.sb.mongo.repository.HotelRepository;

@Component
/*
 *  This is an optional class
 *  It executes when the application launches by using CommandLineRunner
 *  It populates Hotels collection in MongoDB
 */
public class DbSeeder implements CommandLineRunner {

	private HotelRepository hotelRepository;

	public DbSeeder(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	@Override
	public void run(String... arg0) throws Exception {

		Hotel marriot = new Hotel("Marriot", 130, new Address("Paris", "France"),
				Arrays.asList(new Review("Sumeet", 4, true), new Review("Ronald", 2, false)));

		Hotel taj = new Hotel("Taj", 90, new Address("New Delhi", "India"),
				Arrays.asList(new Review("Sumeet", 5, true)));

		Hotel hilton = new Hotel("Hilton", 70, new Address("Georgia", "USA"), new ArrayList<>());

		// drop all hotels if any exists in DB to start with a clean set
		this.hotelRepository.deleteAll();

		// add our hotels to the database
		List<Hotel> hotels = Arrays.asList(marriot, taj, hilton);
		this.hotelRepository.save(hotels);

	}

}
