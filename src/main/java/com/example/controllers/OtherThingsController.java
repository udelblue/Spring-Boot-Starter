package com.example.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Things;
import com.example.repository.ThingRepository;
import com.example.resource.ThingsResourceAssembler;

@RestController
@RequestMapping("/otherthings")
public class OtherThingsController {


	@Autowired
	ThingRepository tr;
	
	@Autowired
	ThingsResourceAssembler tra;
	
	
	@RequestMapping(value = "")
	public Resource<Things> things(){
			

		return this.tra.toResource(new Things() );
	}
	
	@RequestMapping(value = "/count")
	public String thingscount(){
		return String.valueOf(tr.count());
	}
	
	
	
	
	
	
	@RequestMapping(value = "/add" , method=RequestMethod.POST)
	public List<Things> addthing(@RequestBody Things thing){
		if( thing != null )
		{
		tr.save(thing);
		}	
		List<Things> list = new ArrayList<Things>();
		list = tr.findAllByOrderByIdAsc();
		return list;
	}
	
	@RequestMapping(value = "/add" , method=RequestMethod.GET)
	public List<Things> addthing(){
		
		 Random rg = new Random();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); 
		Things thing = new Things(rg.nextLong(),sdf.format(new Date()));
		tr.save(thing);
		
		List<Things> list = new ArrayList<Things>();
		list = tr.findAllByOrderByIdAsc();
		return list;
	}
	
	
	
}
