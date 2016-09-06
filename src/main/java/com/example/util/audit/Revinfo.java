package com.example.util.audit;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

@Entity
@RevisionEntity(RevRevisionListener.class)
@Table(name = "REVINFO")
public class Revinfo {
	
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @RevisionNumber

	    private int id;

	    @RevisionTimestamp
	    private long timestamp;

	    private String username;
	    
	    private Date date_of_execution;
	    
	    private String ip_address;
	    
	    

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public long getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(long timestamp) {
			this.timestamp = timestamp;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public Date getDate_of_execution() {
			return date_of_execution;
		}

		public void setDate_of_execution(Date date_of_execution) {
			this.date_of_execution = date_of_execution;
		}

		public String getIp_address() {
			return ip_address;
		}

		public void setIp_address(String ip_address) {
			this.ip_address = ip_address;
		}

	


}