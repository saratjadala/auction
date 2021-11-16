package com.java.rest.auction.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.rest.auction.model.Auction;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
	
	List<Auction> findAll();
	
	List<Auction> findByName(String name);
	
	Optional<Auction> findById(Long id);

}
