package com.telusko.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.demo.model.Alien;
import com.telusko.demo.dao.AlienRepo;
import com.telusko.demo.service.AlienService;

@Service
//@Transactional
public class ServiceImpl implements AlienService{

	@Autowired
	AlienRepo repo;
	
	@Override
	public List<Alien> getAliens() {
		System.out.println("data:"+repo.findAll());
		return repo.findAll();
	}

	@Override
	public Optional<Alien> getAlien(long aid) {
		//return repo.findById(aid);
		Optional<Alien> a=repo.findById(aid);
//		System.out.println("*******************");
//		System.out.println(a);
//		System.out.println("*******************");
		return a;
	}

	@Override
	public Alien addAlien(Alien alien) {
		repo.save(alien);
		return alien;
	}

	@Override
	public Optional<Alien> deleteAlien(long aid) {
		Optional<Alien> a=repo.findById(aid);
		if((Optional)a!=Optional.empty()) {
			repo.deleteById(aid);
		}
		return a;

//		Optional<Alien> a=repo.findById(aid);
//		repo.deleteById(aid);
//		return a ;
	}

	@Override
	public Alien updateAlien(Alien alien,long aid) {
		alien.setAid(aid);
		repo.save(alien);
		return alien;
	}
}
