package com.telusko.demo.service;

import java.util.List;
import java.util.Optional;

import com.telusko.demo.model.Alien;
public interface AlienService {
	public List<Alien> getAliens();
	public Optional<Alien> getAlien(long aid);
	public Alien addAlien(Alien alien);
	public Optional<Alien> deleteAlien(long aid);
	public Alien updateAlien(Alien alien,long aid);

}

