package com.example.easynotes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "notes") // this annotaion provides details of the table for this entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true) // values to be ignored if sent via the API
public class Note implements Serializable {
  @Id // this annotation defines the primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // this annotation is used to define the primary key generation strategy
  private Long id;

  @NotBlank // this annotation is used to validate that the field is not null
  private String title;

  @NotBlank
  private String content;

  @Column(nullable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP) // this annotation is used for date and time conversion
  @CreatedDate
  private Date createdAt;
 
  @Column(nullable = false) // this annotation is used to define the properties of the column that will be mapped to the annotated field
  @Temporal(TemporalType.TIMESTAMP)
  @LastModifiedDate
  private Date updatedAt;

  // Getters and setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
      this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
      return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
      this.updatedAt = updatedAt;
  }
}
