package com.example.resource;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.example.models.Things;
@Component
public class ThingsResourceAssembler implements ResourceAssembler<Things, Resource<Things>> {

	@Override
	public Resource<Things> toResource(Things thing) {
		
		Resource<Things> resource = new Resource<Things>(thing);
		
		return resource ;
	}

}
