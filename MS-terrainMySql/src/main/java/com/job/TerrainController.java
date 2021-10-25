package com.job;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.job.export.ExportExcel;
import com.job.export.ExportPdf;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
public class TerrainController {
	@Autowired
	IService IService;
	@PostMapping("/addTerrain")
	@ResponseBody
	public Terrain addTerrain(@RequestBody Terrain terrain) {
		Terrain terain =IService.addTerrain(terrain);
		return terain;
		
	}
	
	@PutMapping("/modifTerrain")
	@ResponseBody
	public Terrain updateTerrain(@RequestBody Terrain terrain) {
		Terrain terain =IService.updateTerrain(terrain);
		return terain;
		
	}
	@GetMapping("/allTerrain")
	public List<Terrain> allTerrain() {
		return IService.getAllTerrains();
		
	}
	@GetMapping(value="/allTerrainByLieu/{lieu}")
	public List<Terrain> allTerrainByLieu(@PathVariable("lieu")String lieu) {
		return IService.getAllTerrainsByLieu(lieu);
		
	}
	
	@GetMapping(value="/allTerrainByNameAndLieu/{name}/{lieu}")
	public List<Terrain> allTerrain(@PathVariable("name")String name,@PathVariable("lieu")String lieu) {
		return IService.getAllTerrainsByNameAndLieu(name, lieu);
		
	}
	@GetMapping(value="/checkIfDispo/{name}")
	public String checkIfDispo(@PathVariable("name") String name) {
		
		return IService.checkIfDispo(name);
		
	}
	@GetMapping(value="/nameStartWith/{word}")
	public List<Terrain> getTerrainsStartWith(@PathVariable("word")String word) {
		return IService.getTerrainsStartWith(word);
		
	}
	@GetMapping(value = "/exportpdf", produces = MediaType.APPLICATION_PDF_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<InputStreamResource> employeeReports(HttpServletResponse response) throws IOException {

		List<Terrain> allTerrains = IService.getAllTerrains();

		ByteArrayInputStream bis = ExportPdf.produitsReport(allTerrains);

		HttpHeaders headers = new HttpHeaders();

		headers.add("Content-Disposition", "attachment;filename=terrains.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	@GetMapping("/exportexcel")
	@CrossOrigin(origins = "http://localhost:4200")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        //DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        //String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment;filename=terrain.xlsx";
        response.setHeader(headerKey, headerValue);
         
        List<Terrain> listTerrains = IService.getAllTerrains();
         
        ExportExcel excelExporter = new ExportExcel(listTerrains);
         
        excelExporter.export(response);  
        
    }  

}
