package com.journaldev.xml.jaxb;


import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class JAXBExample {

    private static final String FILE_NAME = "jaxb-emp.xml";

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setId(1);
        emp.setAge(25);
        emp.setName("Pankaj");
        emp.setGender("Male");
        emp.setRole("Developer");
        emp.setPassword("sensitive");

        jaxbObjectToXML(emp);

        Employee empFromFile = jaxbXMLToObject();
        System.out.println(empFromFile.toString());
    }


    private static Employee jaxbXMLToObject() {
        try {
            JAXBContext context = JAXBContext.newInstance(Employee.class);
            Unmarshaller un = context.createUnmarshaller();
            Employee emp = (Employee) un.unmarshal(new File(FILE_NAME));
            return emp;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static void jaxbObjectToXML(Employee emp) {

        try {
            JAXBContext context = JAXBContext.newInstance(Employee.class);
            Marshaller m = context.createMarshaller();
            //for pretty-print XML in JAXB
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Write to System.out for debugging
            // m.marshal(emp, System.out);

            // Write to File
            m.marshal(emp, new File(FILE_NAME));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}