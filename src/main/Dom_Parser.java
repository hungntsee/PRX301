/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import view.MainFrame;

/**
 *
 * @author Admin
 */
public class Dom_Parser {

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder;

    public void writeFile(Document doc, String file) throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(file));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "10");
        transformer.transform(source, result);
        System.out.println("XML file update successfully");

    }

    public void updateFile(Students students, String file) throws ParserConfigurationException {

        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("student_list");

            doc.appendChild(root);

            for (int i = 0; i < students.size(); i++) {
                
                Element student = doc.createElement("student");

                Attr id = doc.createAttribute("roll");
                id.setValue(students.get(i).getId());
                student.setAttributeNode(id);

                Element name = doc.createElement("name");
                name.setTextContent(students.get(i).getName());
                student.appendChild(name);

                Element phone = doc.createElement("phone");
                phone.setTextContent(students.get(i).getPhone());
                student.appendChild(phone);

                Element email = doc.createElement("email");
                email.setTextContent(students.get(i).getEmail());
                student.appendChild(email);

                Element course = doc.createElement("course");

                Attr code = doc.createAttribute("code");
                code.setValue(students.get(i).getCourse().getCourseCode());
                course.setAttributeNode(code);
                course.setTextContent(students.get(i).getCourse().getCourseName());
                student.appendChild(course);

                Element credit = doc.createElement("credit");
                credit.setTextContent(String.valueOf(students.get(i).getCredit()));
                student.appendChild(credit);

                Element score = doc.createElement("score");
                score.setTextContent(String.valueOf(students.get(i).getScore()));
                student.appendChild(score);

                root.appendChild(student);
            }

            writeFile(doc, file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
