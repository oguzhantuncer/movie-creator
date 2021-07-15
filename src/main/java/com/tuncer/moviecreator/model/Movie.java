package com.tuncer.moviecreator.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tuncer.moviecreator.types.GenreType;

@Entity
@Table
public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy=GenerationType.AUTO )
	private Long id;
	private String name;
	private Integer publishYear;
	@Enumerated
	private GenreType genreList;
	private String description;
	private String production;
	
	@OneToMany(mappedBy = "id",cascade = CascadeType.ALL)
	private List<Actor> actors;

	
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
	public Integer getPublishYear() {
		return publishYear;
	}
	public void setPublishYear(Integer publishYear) {
		this.publishYear = publishYear;
	}
	public GenreType getGenreList() {
		return genreList;
	}
	public void setGenreList(GenreType genreList) {
		this.genreList = genreList;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProduction() {
		return production;
	}
	public void setProduction(String production) {
		this.production = production;
	}

	
}