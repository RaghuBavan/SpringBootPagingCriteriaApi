package com.example.demo.model;

import javax.persistence.Entity;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;

		private String name;
		
		private String email;
		
		private String gender;
		
		private String imageid;
		
		
		/*
		 * @CreationTimestamp
		 * 
		 * @Column(name = "created_at", nullable = false, updatable = false) private
		 * Date createdAt;
		 * 
		 * @UpdateTimestamp
		 * 
		 * @Column(name = "updated_at") private LocalDateTime updateAt;
		 */
		public int getId() { return id; }
		  
		  public void setId(int id) { this.id = id; }
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getImageid() {
			return imageid;
		}

		public void setImageid(String imageid) {
			this.imageid = imageid;
		}

		
		  
		 

}
