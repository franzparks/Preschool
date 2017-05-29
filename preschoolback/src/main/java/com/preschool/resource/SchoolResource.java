/**
 * 
 */
package com.preschool.resource;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.preschool.domain.School;
import com.preschool.service.SchoolService;

/**
 * @author francisphiri
 *
 */
@RestController
@RequestMapping("/school")
public class SchoolResource {
	
	@Autowired
	private SchoolService schoolService;
	
	@RequestMapping (value="/add", method=RequestMethod.POST)
	public School addSchoolPost(@RequestBody School school) {
		return schoolService.save(school);
	}
	
	@RequestMapping(value="/add/image", method=RequestMethod.POST)
	public ResponseEntity upload(
			@RequestParam("id") Long id,
			HttpServletResponse response, HttpServletRequest request){
		try {
			School school = schoolService.findOne(id);
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Iterator<String> it = multipartRequest.getFileNames();
			MultipartFile multipartFile = multipartRequest.getFile(it.next());
			String fileName = id+".png";
			
			
			byte[] bytes = multipartFile.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/image/school/"+fileName)));
			stream.write(bytes);
			stream.close();
			
			return new ResponseEntity("Upload Success!", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Upload failed!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/update/image", method=RequestMethod.POST)
	public ResponseEntity updateImagePost(
			@RequestParam("id") Long id,
			HttpServletResponse response, HttpServletRequest request
			){
		try {
			School school = schoolService.findOne(id);
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Iterator<String> it = multipartRequest.getFileNames();
			MultipartFile multipartFile = multipartRequest.getFile(it.next());
			String fileName = id+".png";
			
			Files.delete(Paths.get("src/main/resources/static/image/school/"+fileName));
			
			byte[] bytes = multipartFile.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File("src/main/resources/static/image/school/"+fileName)));
			stream.write(bytes);
			stream.close();
			
			return new ResponseEntity("Upload Success!", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Upload failed!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping("/schoolList")
	public List<School> getSchoolList() {
		return schoolService.findAll();
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public School updateSchoolPost(@RequestBody School school) {
		return schoolService.save(school);
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public ResponseEntity remove(
			@RequestBody String id
			) throws IOException {
		schoolService.removeOne(Long.parseLong(id));
		String fileName = id+".png";
		
		Files.delete(Paths.get("src/main/resources/static/image/school/"+fileName));
		
		return new ResponseEntity("Remove Success!", HttpStatus.OK);
	}
	
	@RequestMapping("/{id}")
	public School getBook(@PathVariable("id") Long id){
		School book = schoolService.findOne(id);
		return book;
	}
	
	
}
