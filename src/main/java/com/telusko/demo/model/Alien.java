package com.telusko.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.transaction.Transactional;

@Entity
public class Alien {
	@Id
	private long aid;
	private String aname;
	private String tech;
	
	public Alien() {
		
	}
	
	public Alien(long a,String b,String c) {
		aid=a;
		aname=b;
		tech=c;
	}
	
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	public long getAid() {
		return aid;
	}
	public void setAid(long aid) {
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
		return "Alien [aid=" + aid + ", aname=" + aname + ", tech=" + tech + "]";
	}
	
}
