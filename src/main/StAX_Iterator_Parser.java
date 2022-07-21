/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author Admin
 */
public class StAX_Iterator_Parser {
    Students students;

    public StAX_Iterator_Parser() {
        students = new Students();
    }

    public Students getStudents() {
        return students;
    }
    
    public void parseFile(String path) {
        Student student = new Student();
        Course course = new Course();
        String codeCourse ="";
        boolean isName = false, isPhone = false, isEmail = false, isCourse = false, isCredit = false, isScore = false;
        try{
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader reader = factory.createXMLEventReader(new FileInputStream(path));
            while (reader.hasNext()) {                
                XMLEvent event = reader.nextEvent();
                
                switch(event.getEventType()){
                    case XMLEvent.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String sName = startElement.getName().getLocalPart();
                        if(sName.equalsIgnoreCase("student")){
                            Iterator<Attribute> attributes = startElement.getAttributes();
                            String id = attributes.next().getValue();
                            student.setId(id);
                        }else if(sName.equalsIgnoreCase("name")){
                            isName = true;
                        }else if(sName.equalsIgnoreCase("phone")){
                            isPhone = true;
                        }else if(sName.equalsIgnoreCase("email")){
                            isEmail = true;
                        }else if(sName.equalsIgnoreCase("course")){
                            Iterator<Attribute> attributes = startElement.getAttributes();
                            codeCourse = attributes.next().getValue();                        
                            isCourse = true;
                        }else if(sName.equalsIgnoreCase("credit")){
                            isCredit = true;
                        }else if(sName.equalsIgnoreCase("score")){
                            isScore = true;
                        }
                        break;
                    case XMLEvent.CHARACTERS:
                        Characters characters = event.asCharacters();
                        String data = characters.getData();
                        if(isName){
                            student.setName(data);
                            isName = false;
                        }else if(isPhone){
                            student.setPhone(data);
                            isPhone = false;
                        }else if(isEmail){
                            student.setEmail(data);
                            isEmail = false;
                        }else if(isCourse){
                            student.setCourse(new Course(codeCourse, data));
                            isCourse = false;
                        }else if(isCredit){
                            student.setCredit(Integer.parseInt(data));
                            isCredit = false;
                        }else if(isScore){
                            student.setScore(Integer.parseInt(data));
                            isScore = false;
                        }
                        break;
                    case XMLEvent.END_ELEMENT:
                        EndElement endElement = event.asEndElement();
                        String eName = endElement.getName().getLocalPart();
                        if (eName.equalsIgnoreCase("student")){
                            students.add(student);
                            student = new Student();
                        }
                        break;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    
}
