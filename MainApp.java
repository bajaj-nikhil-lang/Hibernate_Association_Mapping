package com.controller;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Actor;
import com.model.Movie;

public class MainApp {

	public static void main(String[] args) {
		
		Configuration c= new Configuration();		
		SessionFactory sf=c.configure().buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		
		//create movie objects
		Movie m1=new Movie();
		m1.setId(101);
		m1.setMoviename("DDLJ");
		Movie m2=new Movie();
		m2.setId(102);
		m2.setMoviename("kal ho na ho");
		Movie m3=new Movie();
		m3.setId(103);
		m3.setMoviename("karan arjun");
		Movie m4=new Movie();
		m4.setId(104);
		m4.setMoviename("sultan");
		
		//create actor objects
		Actor a1=new Actor();
		a1.setAid(1);
		a1.setAname("SRK");
		Actor a2=new Actor();
		a2.setAid(2);
		a2.setAname("salman khan");
		
		HashSet<Movie>hs=new HashSet<Movie>();
		hs.add(m1);
		hs.add(m2);
		hs.add(m3);
		HashSet<Movie>hs1=new HashSet<>();
		hs1.add(m3);
		hs1.add(m4);
		HashSet<Actor>hs3=new HashSet<>();
		hs3.add(a1);
		HashSet<Actor>hs4=new HashSet<Actor>();
		hs4.add(a2);
		HashSet<Actor>hs5=new HashSet<Actor>();
		hs5.add(a1);
		hs5.add(a2);
		a1.setMovies(hs);
		a2.setMovies(hs1);
		m1.setActors(hs3);
		m2.setActors(hs3);
		m3.setActors(hs5);
		m4.setActors(hs4);
		
		//save movies
		s.save(m1);
		s.save(m2);
		s.save(m3);
		s.save(m4);
		
		//save actors
		s.save(a1);
		s.save(a2);
		
		
		
		t.commit();
		s.close();
		sf.close();

	}

}
