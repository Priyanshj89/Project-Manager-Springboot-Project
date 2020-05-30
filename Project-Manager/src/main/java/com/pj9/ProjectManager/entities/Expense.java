package com.pj9.ProjectManager.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Expense {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String amount;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
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

    public Expense() {
    }

    public Expense(Long id, @NotBlank String title, @NotBlank String amount, String description, User user) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.description = description;
        this.user = user;
    }

    public Expense(@NotBlank String title, @NotBlank String amount, String description) {
        this.title = title;
        this.amount = amount;
        this.description = description;
    }
}
