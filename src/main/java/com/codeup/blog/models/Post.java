package com.codeup.blog.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="posts")
public class Post {
    @NotBlank(message = "Posts must have a title")
    @Size(min=3, message = "Title must be more than three characters" )
    @Column(nullable = false, length=100)
    private String title;
    @NotBlank(message = "Posts must have a body")
    @Column(nullable=false)
    private String body;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;

    public Post(){};

    public Post(String title, String body){
        this.title= title;
        this.body= body;
    }
    public Post(String title, String body, User user){
        this.title=title;
        this.body=body;
        this.user=user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
