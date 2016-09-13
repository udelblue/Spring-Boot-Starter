package com.example.models.security;


import javax.persistence.*;

import org.hibernate.validator.constraints.Email;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user" , indexes = {
        @Index(columnList = "USER_ID", name = "user_id"),@Index(columnList = "username", name = "user_username")
    })
public class User {
	
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    
    //@Email
    private String email;
    
    private int enabled;
    
    
    @ManyToMany(targetEntity=Role.class , cascade=CascadeType.ALL )
    @JoinTable(name="User_Role" )
    private List<Role> roles = new ArrayList<Role>();

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public User(String username, String password, String email, int enabled,
			List<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.roles = roles;
	}
    
    
    

	public User(String username, String password, String email, int enabled) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
	}

	public void setPassword(String password) {
        this.password = password;
    }

   
	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email
				+ ", enabled=" + enabled + "]";
	}




}