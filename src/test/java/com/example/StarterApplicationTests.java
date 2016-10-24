package com.example;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.WebApplicationContext;

import com.example.mocks.MockPeopleRepository;
import com.example.services.PeopleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StarterApplicationTests {

	   @Autowired
	    private WebApplicationContext wac;
	 
	    private MockMvc mockMvc;

	    @Before
	    public void setup() {
	        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	    }
	    
	    
	    
	@Test
	public void contextLoads() {
		MockPeopleRepository mpr = new MockPeopleRepository();
		PeopleService ps = new PeopleService(mpr);
		int size = ps.people().size();
		assertEquals(4, size);
		
		
	}
	
	
	@Test
	public void testHome() throws Exception {
		  mockMvc.perform(get("/home"))
          .andExpect(status().is(200));
		 
	}
	
		@Test
	 @ExceptionHandler(Exception.class)
	 @ResponseStatus(HttpStatus.NOT_FOUND)
	    public void handleNotFoundException() throws Exception {
		 	mockMvc.perform(get("/1234"))
		 		.andExpect(status().is(404));
	    }
	
	
	
	
	

}
