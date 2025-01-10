package com.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="moviename")
public class Movie {
	@Id
	@Column(name="mid",length=3)
	int mid;
	@Column(name="mname",length=15)
	String moviename;
	
	@ManyToMany(mappedBy = "movies")
	Set<Actor>actors;
	
	
	public Movie() {
		super();
	}
	public Movie(int id, String moviename) {
		super();
		this.mid = id;
		this.moviename = moviename;
	}
	public int getId() {
		return mid;
	}
	public void setId(int id) {
		this.mid = id;
	}
	public Set<Actor> getActors() {
		return actors;
	}
	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	@Override
	public String toString() {
		return "Movie [id=" + mid + ", moviename=" + moviename + "]";
	}
	
}
