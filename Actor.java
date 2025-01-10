package com.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Actor")
public class Actor {
	@Id
	@Column(name="aid",length=3)
	int aid;
	@Column(name="aname",length=15)
	String aname;
	
	@ManyToMany
    @JoinTable(
        name = "hib_actor_movie", 
        joinColumns = {@JoinColumn(name = "actId")}, 
        inverseJoinColumns = {@JoinColumn(name = "movieId")}
    )
	Set<Movie>movies;
	
	
	
	public Set<Movie> getMovies() {
		return movies;
	}
	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}
	public Actor() {
		super();
	}
	public Actor(int aid, String aname) {
		super();
		this.aid = aid;
		this.aname = aname;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	@Override
	public String toString() {
		return "Actor [aid=" + aid + ", aname=" + aname + "]";
	}
	
	
}
