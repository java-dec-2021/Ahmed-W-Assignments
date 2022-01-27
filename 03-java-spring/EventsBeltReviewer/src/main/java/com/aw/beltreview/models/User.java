package com.aw.beltreview.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//	@NotEmpty
	@Size(min=2, max=20, message="Must be between 2 and 20 characters")
	private String firstName;
//	@NotEmpty
	@Size(min=2, max=20, message="Must be between 2 and 20 characters")
	private String lastName;
	@Size(min=2, message="Cannot be blank")
	private String city;
	private String state;
	
	@Email
	private String email;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	@Size(min=2, message="Must be at least 2 characters")
	private String password;
	@Transient
	private String passwordConfirmation;
	public Long getId() {
		return id;
	}
	
	@OneToMany(mappedBy="host", fetch=FetchType.LAZY)
	private List<Event> eventsCreated;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="users_events",
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="event_id"))
	private List<Event> eventsAttending;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Message> messages;
	
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	
		
	public List<Event> getEventsCreated() {
		return eventsCreated;
	}
	public void setEventsCreated(List<Event> eventsCreated) {
		this.eventsCreated = eventsCreated;
	}
	public List<Event> getEventsAttending() {
		return eventsAttending;
	}
	public void setEventsAttending(List<Event> eventsAttending) {
		this.eventsAttending = eventsAttending;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

	public Date getUpdatedAt() {
		return updatedAt;
	}

	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
