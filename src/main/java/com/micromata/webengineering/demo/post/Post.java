package com.micromata.webengineering.demo.post;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private Date createdAt;

    public Post() {
        createdAt = new Date();
    }

    public String getTitle() {
        return title;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }
    
    /*
     * This method is called before an entity is persisted in the database. This is in contrast to our previous approach where an
     * object's createdAt depends on the date of its instantiation.
     * 
     * Information about @PrePersist where found by using the search terms "jpa annotations createdAt".
     */
    @PrePersist
    public void prePersist() {
    	createdAt = new Date();
    }
}
