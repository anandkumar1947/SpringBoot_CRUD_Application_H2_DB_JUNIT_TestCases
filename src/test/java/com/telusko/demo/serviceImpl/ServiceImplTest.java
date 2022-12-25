package com.telusko.demo.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.telusko.demo.dao.AlienRepo;
import com.telusko.demo.model.Alien;

//@RunWith(SpringRunner.class)
@SpringBootTest
class ServiceImplTest {

	@Autowired
	ServiceImpl service;
	
	@MockBean
	AlienRepo repository;

	@Test
	public void getAliensTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Alien(10L,"Anand","Java"),new Alien(10L,"Om","aws")).collect(Collectors.toList()));
		assertEquals(2,service.getAliens().size());
	}
	
	@Test
	public void getAlienTest() {
		long num=12;
		Alien b= new Alien(12L,"vivek","Java");
		 Optional<Alien> a = Optional.of(b); 
		when(repository.findById(num)).thenReturn(a);
		assertEquals(a,service.getAlien(num));
	}
	
	@Test
	public void addAlienTest() {
		Alien a= new Alien(14L,"su","Java");
		when(repository.save(a)).thenReturn(a);
		assertEquals(a,service.addAlien(a));
	}
	
	@Test
	public void deleteAlienTest() {
		long num=12;
		Alien b= new Alien(12L,"vivek","Java");
		Optional<Alien> a = Optional.of(b);
		when(repository.findById(num)).thenReturn(a);
		assertEquals(a,service.deleteAlien(num));
	}
	
	@Test
	public void updateAlienTest() {
		Alien b= new Alien(12L,"vivek","Java");
		b.setAid(99);
		when(repository.save(b)).thenReturn(b);
		assertEquals(b,service.updateAlien(b,99));
	}
}
