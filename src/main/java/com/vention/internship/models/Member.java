package com.vention.internship.models;

import jakarta.persistence.*;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, name = "is_active")
    private boolean isActive = true;
    public Member() {}
    public Member(String name, String email, boolean isActive) {
        this.name = name;
        this.email = email;
        this.isActive = isActive;
    }
    public Member(String name, String email) {
        this(name, email, true);
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
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
    public void deactivate() {
        if (isActive)
            isActive = false;
    }
    public void activate() {
        if (!isActive)
            isActive = true;
    }
    public boolean isActive() {
        return this.isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
}
