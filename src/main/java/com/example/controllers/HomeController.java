package com.example.controllers;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.models.Person;
import com.example.models.Things;
import com.example.repository.ThingRepository;
import com.example.services.PeopleService;


@Controller
public class HomeController {

	
	public HomeController() {
		super();
		System.out.println("------------------- Pre processing");
	}



	@Autowired
	PeopleService ps;
	
	@Autowired
	ThingRepository tr;
	
	@RequestMapping(value = "/")
	@ResponseBody
	public String home(){
		return "you are home";
	}
	
	


	    @RequestMapping("/greeting")
	    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
	        model.addAttribute("name", name);
	        return "greeting";
	    }


	
	
	
	
	@RequestMapping(value = "/thing")
	@ResponseBody
	public List<Things> things(){
		List<Things> list = new ArrayList<Things>();
		list = tr.findAllByOrderByIdAsc();
		return list;
	}
	
	@RequestMapping(value = "/thingcount")
	@ResponseBody
	public String thingscount(){
		return String.valueOf(tr.count());
	}
	
	
	@RequestMapping(value = "/thing/add" , method=RequestMethod.POST)
	@ResponseBody
	public List<Things> addthing(@RequestBody Things thing){
		if( thing != null )
		{
		tr.save(thing);
		}	
		List<Things> list = new ArrayList<Things>();
		list = tr.findAllByOrderByIdAsc();
		return list;
	}
	
	@RequestMapping(value = "/thing/add" , method=RequestMethod.GET)
	@ResponseBody
	public List<Things> addthing(){
		
	
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); 
			Things thing = new Things();
			thing.setName(sdf.format(new Date()));
			thing.setTitle("test");
			tr.save(thing);
		
		List<Things> list = new ArrayList<Things>();

		
		list = tr.findAllByOrderByIdAsc();
		return list;
	}
	
	
	
	
	
	@RequestMapping(value = "/people")
	@ResponseBody
	public List<Person> people(){
		
		return ps.people();
		
		  
		
	}
	

	@RequestMapping(value = "/person/add" ,  method=RequestMethod.GET)
	@ResponseBody
	public List<Person> adpeople(){
		Person pq = new Person();
		pq.setName("test");
		
		ps.people(pq );
		return ps.people();
	}
	
	
	
	
	@RequestMapping(value = "/person/add" , method=RequestMethod.POST)
	@ResponseBody
	public List<Person> adpeople(@RequestBody Person person ){
	
		
		ps.people(person );
		return ps.people();
	}
	
	

	
	
	@PostConstruct
	public void postrun()
	{
		
		System.out.println("------------------- Post processing");
	}
	
	
	@PreDestroy
	public void postsrun()
	{
		
		System.out.println("------------------- Done processing");
	}
	
	
	
}
