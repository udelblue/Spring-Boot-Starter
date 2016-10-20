package com.example.controllers;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.models.Address;
import com.example.models.Book;
import com.example.models.BookCategory;
import com.example.models.Person;
import com.example.models.Things;
import com.example.models.security.Role;
import com.example.models.security.User;
import com.example.repository.AddressRepository;
import com.example.repository.BookCategoryRepository;
import com.example.repository.ThingRepository;
import com.example.repository.security.RoleRepository;
import com.example.repository.security.UserRepository;
import com.example.services.PeopleService;
import com.example.services.security.UserService;


@Controller
public class HomeController {

	private static final Logger logger = Logger.getLogger( HomeController.class);
	
	public HomeController() {
		super();
	}

	@Autowired
	BookCategoryRepository bookCategoryRepository;
	
	
	@Autowired
	UserService us;

	@Autowired
	PeopleService ps;
	
	@Autowired
	ThingRepository tr;
	
	
	@Autowired
	AddressRepository ara;
	
	
	

	@Autowired
	UserRepository ur;
	@Autowired
	RoleRepository rr;
	
	
		@RequestMapping(value = "/")
		public String index(){
		return "home";
		}
	
	

		@RequestMapping(value = "/home")
		public String home(){
		return "home";
		}
	
	
	
	@RequestMapping(value = "/thing")
	@ResponseBody
	@Cacheable("things")
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
	
	@RequestMapping(value = "/seed")
	@ResponseBody
	public String seed(){
		
//		for (int i = 1; i < 100; i++) {
//			
//			User user1 = new User();
//			user1.setUsername("user" + i);
//			user1.setEmail("user" + i + "@yahoo.com");
//			user1.setEnabled(1);
//			user1.setPassword("test");
//			us.AddUser(user1);
//		
//			
//			logger.info("---" + user1.getUsername() + "---");
//			
//			
//		}
			
		  
		
		
//		for (int i = 1; i < 50; i++) {
//			
//			
//			User user1 = us.GetUserByID(i);
//			Role r = new Role();
//			r.setRole("Testing");
//			List<Role> roles = new ArrayList<Role>();
//			roles.add(r);
//			user1.setRoles(roles);
//			us.UpdateUser(user1);
//			
//			logger.info("---" + user1.getUsername() + " updated---");
//			
//			
//		}
			
		
		
//		for (int i = 1; i < 10; i++) {
//			
//			
//			User user1 = us.GetUserByID(i);
//	
//			List<Role> roles = user1.getRoles();
//			for (Role role : roles) {
//				role.setDescription("testing");
//				role.setRole("updated");
//			}
//			
//			us.UpdateUser(user1);
//			
//			logger.info("---" + user1.getUsername() + " updated---");
//			
//			
//		}
		
		
		
	
		
		
		
		 BookCategory categoryA = new BookCategory("Category A");
	        Set bookAs = new HashSet<Book>(){{
	            add(new Book("Book A1", categoryA));
	            add(new Book("Book A2", categoryA));
	            add(new Book("Book A3", categoryA));
	        }};
	        categoryA.setBooks(bookAs);

	        BookCategory categoryB = new BookCategory("Category B");
	        Set bookBs = new HashSet<Book>(){{
	            add(new Book("Book B1", categoryB));
	            add(new Book("Book B2", categoryB));
	            add(new Book("Book B3", categoryB));
	        }};
	        categoryB.setBooks(bookBs);

	        bookCategoryRepository.save(categoryA);

	        bookCategoryRepository.save(categoryB);
		
		
		
	        
	        
	        Role r1 = new Role("super role","super");
	        Role r2 = new Role("non super role","non super");
	        Role r3 = new Role("admin","admin");
	        
	        rr.save(r1);
	        rr.save(r2);
	        rr.save(r3);
	        
	        User u1 = new User("t1","t1","test",1);
	        User u2= new User("t2","t2","test",1);
	        User u3 = new User("t3","t3","test",1);
	        
	        ur.save(u1);
	        ur.save(u2);
	        ur.save(u3);
	        
	        List<Role> rlist = rr.findAll();
	        
	        List<User> ulist = ur.findAll();
	        
	        
	        for(User user: ulist)
	        {
	        	user.setRoles(rlist);
	        	ur.save(user);
	        }
	        
	        ur.delete(ulist.get(2));
	        
	        
	        
	        
		return "seeded";
	}
	
	

	
	@RequestMapping(value = "/address" ,  method=RequestMethod.GET)
	@ResponseBody
	public List<Address> alladdress(){

		return ara.findAll();
	}
	
	@RequestMapping(value = "/address/add" ,  method=RequestMethod.GET)
	@ResponseBody
	public List<Address> addaddress(){

		Address a= ara.getOne(3);
		
		Person pq = new Person();
		pq.setName("test");
		ps.people(pq );
		List<Person> pepo = ps.people();
		Person p = pepo.get(0);
		a.getPersons().add(p);
		
		return ara.findAll();
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
