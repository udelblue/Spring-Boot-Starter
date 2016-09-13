package com.example.models.security;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "role")
public class Role {
	
	@Id
	@Column(name="ROLE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToMany(targetEntity=Role.class)
	private List<User> users;
    
	private String description;
	
	
	
    private String role;
    
    public Long getId() {
        return id;
    }

    public Role() {
		super();
	}

	public Role(String description, String role) {
		super();
		this.description = description;
		this.role = role;
	}

	public void setId(Long id) {
        this.id = id;
    }


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Role [description=" + description + ", role=" + role + "]";
	}


   
}