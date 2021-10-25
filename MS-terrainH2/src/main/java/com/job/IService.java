package com.job;

import java.util.List;

public interface IService {
	
	List<Terrain> getAllTerrains();
	List<Terrain> getAllTerrainsByLieu(String lieu);
	Terrain addTerrain(Terrain terrain);
	Terrain updateTerrain(Terrain terrain);
	
	List<Terrain> getAllTerrainsByNameAndLieu(String name,String lieu);
	List<Terrain> getTerrainsStartWith(String word);
	String checkIfDispo(String name);
}
