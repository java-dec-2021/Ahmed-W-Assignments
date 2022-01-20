package com.aw.overflow.models;

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
import javax.validation.constraints.Size;

@Entity
@Table(name="questions")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min=3, message="Must be greater than 5 characters")
	private String questionText;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	@Transient
	private String temptags;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="tags_questions", 
			joinColumns = @JoinColumn(name = "question_id"), 
			inverseJoinColumns = @JoinColumn(name="tag_id"))
	private List<Tag> tags;
	
	@OneToMany(cascade=CascadeType.ALL ,mappedBy="question", fetch = FetchType.LAZY)
	private List<Answer> answers;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	
		
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	
	@PrePersist
	public void setCreatedAt() {
		this.createdAt = new Date();
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	@PreUpdate
	public void setUpdatedAt() {
		this.updatedAt = new Date();
	}
	
	
	
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public String getTemptags() {
		return temptags;
	}
	public void setTemptags(String temptags) {
		this.temptags = temptags;
	}
	public Question() {
		
	}
	public Question(@Size(min = 3, message = "Must be greater than 5 characters") String questionText, List<Tag> tags) {
		this.questionText = questionText;
		this.tags = tags;
	}
	
	
	
}
