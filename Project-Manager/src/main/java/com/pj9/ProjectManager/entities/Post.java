package com.pj9.ProjectManager.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String date;
    @NotBlank
    private String heading;
    @NotBlank
    @Column(length=2000)
    private String description;
    @ManyToOne
    @JoinColumn(name="USER_EMAIL")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post(@NotBlank String date, @NotBlank String heading, @NotBlank String description, User user) {
        this.date = date;
        this.heading = heading;
        this.description = description;
        this.user = user;
    }

    public Post(@NotBlank String date, @NotBlank String heading, @NotBlank String description) {
        this.date = date;
        this.heading = heading;
        this.description = description;
    }

    public Post() {
    }
}

