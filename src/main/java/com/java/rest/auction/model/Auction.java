package com.java.rest.auction.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@Entity
@Table(name = "auction")
public class Auction implements Serializable{
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "hairColor")
	private String hairColor;
	
	@Column(name = "hornLength")
	private int hornLength;
	
	@Column(name = "hornColor")
	private String hornColor;
	
	@Column(name = "eyeColor")
	private String eyeColor;
	
	@Column(name = "height")
	private double height;
	
	@Column(name = "heightUnit")
	private String heightUnit;
	
	@Column(name = "weight")
	private double weight;
	
	@Column(name = "weightUnit")
	private String weightUnit;
	
	@JsonDeserialize(as=ArrayList.class, contentAs=IdentifiableMarks.class)
	@OneToMany( mappedBy = "auction", cascade = CascadeType.ALL, orphanRemoval = true)
	List<IdentifiableMarks> identifiableMarks = new ArrayList<IdentifiableMarks>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	public int getHornLength() {
		return hornLength;
	}

	public void setHornLength(int hornLength) {
		this.hornLength = hornLength;
	}

	public String getHornColor() {
		return hornColor;
	}

	public void setHornColor(String hornColor) {
		this.hornColor = hornColor;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getHeightUnit() {
		return heightUnit;
	}

	public void setHeightUnit(String heightUnit) {
		this.heightUnit = heightUnit;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

	public List<IdentifiableMarks> getIdentifiableMarks() {
		return identifiableMarks;
	}

	public void setIdentifiableMarks(List<IdentifiableMarks> identifiableMarks) {
		this.identifiableMarks = identifiableMarks;
	}

	@Override
	public int hashCode() {
		return Objects.hash(eyeColor, hairColor, height, heightUnit, hornColor, hornLength, id, identifiableMarks, name,
				weight, weightUnit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auction other = (Auction) obj;
		return Objects.equals(eyeColor, other.eyeColor) && Objects.equals(hairColor, other.hairColor)
				&& Double.doubleToLongBits(height) == Double.doubleToLongBits(other.height)
				&& Objects.equals(heightUnit, other.heightUnit) && Objects.equals(hornColor, other.hornColor)
				&& hornLength == other.hornLength && Objects.equals(id, other.id)
				&& Objects.equals(identifiableMarks, other.identifiableMarks) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight)
				&& Objects.equals(weightUnit, other.weightUnit);
	}

	@Override
	public String toString() {
		return "Auction [id=" + id + ", name=" + name + ", hairColor=" + hairColor + ", hornLength=" + hornLength
				+ ", hornColor=" + hornColor + ", eyeColor=" + eyeColor + ", height=" + height + ", heightUnit="
				+ heightUnit + ", weight=" + weight + ", weightUnit=" + weightUnit + ", identifiableMarks="
				+ identifiableMarks + "]";
	}
	
	
}