package com.CrudPractice.v1;

import java.io.IOException;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import org.springframework.web.bind.annotation.RestController;



//import com.sun.org.slf4j.internal.LoggerFactory;

@CrossOrigin(origins = "*")
@RestController
@Transactional
@RequestMapping(path = "/v1")
@Component
@PropertySource("classpath:application.properties")
public class HealthyController {

	@Autowired
	HealthyService healthyService;
	
	@GetMapping("/test")
	String testConnection(){
	    return "Your server is up and running at port: ";
	   
	//+application.getProperty("server.port");      
	}

	@GetMapping("/fetch/{limit}/{offset}") // fetchall
	public List<HealthyModel> fetchdetails(@PathVariable("limit") Integer limit,
			@PathVariable("offset") Integer offset) {
		Page<HealthyModel> healthyModelList = healthyService.fetchAllData(limit, offset);
		System.out.println(healthyModelList);
		return healthyModelList.getContent();

	}
	@GetMapping("/list/{limit}/{skip}/{search}")
	public Page<HealthyModel> search(@PathVariable("search") String search,
			@PathVariable("limit") Integer limit, @PathVariable("skip") Integer skip)
	{
		@SuppressWarnings("unused")
		Page<HealthyModel> healthyModelL;
		if (!search.equals("null")) {
			
				healthyModelL = healthyService.findAllWithSearch(limit, skip, search);
		} else {
			
			healthyModelL = healthyService.fetchAllData(limit, skip);
		}
		return healthyModelL;
		
	}

	@GetMapping("/find/{id}") // findbyid
	public HealthyModel find(@PathVariable("id") Integer id) {
		System.out.println("id" + id);
		return healthyService.getFindById(id);

	}

	@GetMapping("/findbyname/{fruits}") // findbyname
	public HealthyModel findname(@PathVariable("fruits") String fruits) {
		System.out.println("fruits" + fruits);
		return healthyService.getFindByfruits(fruits);

	}


	@PostMapping("/save") // saveentry
	public String savedetails(@RequestBody HealthyModel healthy) {
		healthyService.save(healthy);
		return "Data Enter successfully";

	}

	@PutMapping("/updatedetails") // updatedata
	public Integer updatedata(@RequestBody HealthyModel healthyModel) {
		Integer id = healthyModel.getId();

		healthyService.updateData(healthyModel.getId(), healthyModel.getVegetable());

		return id;
	}

	@DeleteMapping("/deletedata") // deletedata
	public Integer deletEntry(@RequestBody HealthyModel healthyModel) {
		Integer id = healthyModel.getId();
		healthyService.deleteEntryById(healthyModel.getId());
		return id;

	}
	
	

//	private static final Logger LOGGER = LoggerFactory.getLogger(HealthyController.class);
//
//	@GetMapping("/file/{fileName:.+}")
//	public void downloadSampleCSV(HttpServletRequest request, HttpServletResponse response,
//			@PathVariable("fileName") String fileName) throws IOException {
//
//		LOGGER.info("Inside the download controller," + " resource fileName =" + fileName);
//		Resource resource = resourceLoader.getResource("classpath:" + fileName);
//		if (resource.exists()) {
//			LOGGER.info("Resource exists!");
//			response.setContentType("text/csv");
//			response.setHeader("Content-Disposition", String.format("attachment; filename=" + resource.getFilename()));
//			response.setContentLength((int) resource.contentLength());
//			InputStream inputStream = resource.getInputStream();
//			FileCopyUtils.copy(inputStream, response.getOutputStream());
//		}
//	}

	@GetMapping("/demo") // demo
	public String demo() {
		System.out.println("hello friends");
		return "hello vaibhavi";
	}

}
