/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Admin
 */
@XmlRootElement
@XmlType(propOrder = {"name","phone","course","credit","score"})
public class Student {
    
    private String id;
    private String name;
    private String phone;
    private String email;
    private Course course;
    private int credit;
    private int score;

    public Student() {
    }

    public Student(String id, String name, String phone, String email, Course course, int credit, int score) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.course = course;
        this.credit = credit;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    } 
    
    @XmlElement
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    @XmlElement
    public void setEmail(String email) {
        this.email = email;
    }

    public Course getCourse() {
        return course;
    }

    @XmlElement
    public void setCourse(Course course) {
        this.course = course;
    }

    public int getCredit() {
        return credit;
    }

    @XmlElement
    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getScore() {
        return score;
    }

    @XmlElement
    public void setScore(int score) {
        this.score = score;
    }
    
    
}
