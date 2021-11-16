package com.java.rest.auction.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.rest.auction.model.Auction;
import com.java.rest.auction.repository.AuctionRepository;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class AuctionController {
	
	@Autowired
	public AuctionRepository auctionRepository;
	
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/unicorns")
	public ResponseEntity<List<Auction>> getAllAuctions(@RequestParam(required = false) String title) {
		try {
			List<Auction> auctions = new ArrayList<Auction>();

			if (title == null)
				auctionRepository.findAll().forEach(auctions::add);
			else
				auctionRepository.findByName("").forEach(auctions::add);

			if (auctions.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(auctions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/unicorns/{id}")
	public ResponseEntity<Auction> getAuctionById(@PathVariable("id") long id) {
		Optional<Auction> auctionData = auctionRepository.findById(id);

		if (auctionData.isPresent()) {
			return new ResponseEntity<>(auctionData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping("/unicorns")
	public ResponseEntity<Auction> createAuction(@RequestBody Auction auction) {
		try {
			Auction _auction = auctionRepository.save(auction);
			return new ResponseEntity<>(_auction, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@PutMapping("/unicorns/{id}")
	public ResponseEntity<Auction> updateAuction(@PathVariable("id") long id, @RequestBody Auction auction) {
		Optional<Auction> auctionData = auctionRepository.findById(id);

		if (auctionData.isPresent()) {
			Auction _auction = auctionData.get();
			_auction.setName(auction.getName());
			_auction.setHairColor(auction.getHairColor());
			_auction.setEyeColor(auction.getEyeColor());
			return new ResponseEntity<>(auctionRepository.save(_auction), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/unicorns/{id}")
	public ResponseEntity<HttpStatus> deleteAuction(@PathVariable("id") long id) {
		try {
			auctionRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
