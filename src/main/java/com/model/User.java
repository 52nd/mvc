package com.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "login")
    private String username;
    private String password;
    private String name;
    private String email;
    private int age;
//    private String role;

//    public User(String username, String password, String name, String email, int age, String role) {
//        this.username = username;
//        this.password = password;
//        this.name = name;
//        this.email = email;
//        this.age = age;
//        this.role = role;
//    }

    public User() {
    }

    public User(String username, String password, String name, String email, int age) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.age = age;
    }

//    public User(long id, String username, String password, String name, String email, int age, String role) {
//        this.id =  id;
//        this.username = username;
//        this.password = password;
//        this.name = name;
//        this.email = email;
//        this.age = age;
//        this.role = role;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
