package com.telusko.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.demo.dao.AlienRepo;
import com.telusko.demo.model.Alien;
import com.telusko.demo.serviceImpl.ServiceImpl;
import com.telusko.demo.service.AlienService;


@RestController
public class AlienController {
	
	@Autowired
	ServiceImpl re;// AlienService can be also used here

	@GetMapping(path="/aliens")
	public ResponseEntity<List<Alien>> getAliens()
	{
		List<Alien> li= re. getAliens();
		if(li.size()<0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(li));
	}
	
	@GetMapping("/alien/{aid}")
	public ResponseEntity<Optional<Alien>> getAlien(@PathVariable("aid") long aid)
	{
		Optional<Alien> a = re.getAlien(aid);
		if((Optional)a==Optional.empty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(a));
	}
	
	@PostMapping("/alien")
	public ResponseEntity<Alien> addAlien(@RequestBody Alien alien)// @RequestBody for json raw input
	{
		Alien a=null;
		try {
			a=re.addAlien(alien);
			return ResponseEntity.of(Optional.of(a));
			
			//return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/alien/{aid}")
	public ResponseEntity<Optional<Alien>> deleteAlien(@PathVariable long aid)
	{
		Optional<Alien> a= re.deleteAlien(aid);
		
		if((Optional)a==Optional.empty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(a));
	}

//	@PutMapping("/alien")
//	public Alien updateAlien(@RequestBody Alien alien)
//	{
//		 return re.updateAlien(alien);
//	}
	
	@PutMapping("/alien/{aid}")
	public ResponseEntity<Alien> updateAlien(@RequestBody Alien alien,@PathVariable long aid)
	{
		try {
			Alien a=re.updateAlien(alien,aid);
			return ResponseEntity.of(Optional.of(a));
		}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
