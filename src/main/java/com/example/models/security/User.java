package com.example.models.security;


import javax.persistence.*;

import org.hibernate.validator.constraints.Email;

import java.util.Set;

@Entity
@Table(name = "user" , indexes = {
        @Index(columnList = "id", name = "user_id"),@Index(columnList = "username", name = "user_username")
    })
public class User {
    private Long id;
    private String username;
    private String password;
    
    @Email
    private String email;
    
    private int enabled;
    private Set<Role> roles;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public void setPassword(String password) {
        this.password = password;
    }

  

    @OneToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "username"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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
}