package com.java.rest.auction.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "identifiableMarks")
public class IdentifiableMarks implements Serializable{
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "side")
	private String side;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "mark")
	private String mark;
	
	@Column(name = "color")
	private String color;
	
	private Auction auction;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, optional = false)
	@JoinColumn(name = "AUCTION", nullable = false)
	public Auction getAuction() {
		return auction;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}

	@Override
	public int hashCode() {
		return Objects.hash(auction, color, id, location, mark, side);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdentifiableMarks other = (IdentifiableMarks) obj;
		return Objects.equals(auction, other.auction) && Objects.equals(color, other.color)
				&& Objects.equals(id, other.id) && Objects.equals(location, other.location)
				&& Objects.equals(mark, other.mark) && Objects.equals(side, other.side);
	}

	@Override
	public String toString() {
		return "IdentifiableMarks [id=" + id + ", side=" + side + ", location=" + location + ", mark=" + mark
				+ ", color=" + color + ", auction=" + auction + "]";
	}
	
}
