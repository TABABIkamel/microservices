package com.job;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Terrain implements Serializable {
	private static final long serialVersionUID = 6711457437559348053L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String lieu;
	private Boolean dispo;
	
	
	public Terrain() {
	}
	public Terrain(String name, String lieu, Boolean dispo) {
		super();
		this.name = name;
		this.lieu = lieu;
		this.dispo = dispo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public Boolean getDispo() {
		return dispo;
	}
	public void setDispo(Boolean dispo) {
		this.dispo = dispo;
	}
	
	
	
	
}
