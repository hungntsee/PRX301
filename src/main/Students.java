/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@XmlRootElement
public class Students extends ArrayList<Student>{
    ArrayList<Student> students;

    public Students() {
    }

    public Students(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    @XmlElement(name = "student")
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
    
    
}
