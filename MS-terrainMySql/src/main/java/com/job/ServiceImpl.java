package com.job;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ServiceImpl implements IService {
	@Autowired
	TerrainRepository terrainRepository;

	@Override
	public List<Terrain> getAllTerrains() {
	List<Terrain> terrains = terrainRepository.findAll();
	if(!terrains.isEmpty()) {
		return terrains;
	}
		return null;
	}

	@Override
	public List<Terrain> getAllTerrainsByLieu(String lieu) {
		List<Terrain> terrains = terrainRepository.findAll();
		if(!terrains.isEmpty()) {
			List<Terrain> terrainsByLieu =terrains.stream().filter(terrain->terrain.getLieu().equals(lieu)).collect(Collectors.toList());
			return terrainsByLieu;
		}
		return null;
	}

	@Override
	public Terrain addTerrain(Terrain terrain) {
		return terrainRepository.save(terrain);
	}

	@Override
	public Terrain updateTerrain(Terrain terrain) {
		return terrainRepository.save(terrain);
	}

	@Override
	public List<Terrain> getAllTerrainsByNameAndLieu(String name, String lieu) {
		List<Terrain> terrains=terrainRepository.findAll().stream().filter(terrain->terrain.getName().equals(name) && terrain.getLieu().equals(lieu)).collect(Collectors.toList());
		
		return terrains;
	}

	@Override
	public String checkIfDispo(String name) {
		List<Terrain> terrains=terrainRepository.findAll();
		Terrain terrain=terrains.stream().filter(t->t.getName().equals(name)).collect(Collectors.toList()).get(0);
		String response=terrain.getDispo()==true?"Disponible":"Occupé";
		return response;
	}

	@Override
	public List<Terrain> getTerrainsStartWith(String word) {
		List<Terrain> terrains=terrainRepository.findAll().stream().filter(terrain->terrain.getName().startsWith(word)).collect(Collectors.toList());
		return terrains;
	}

}
