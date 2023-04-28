package org.example;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Main {
    public static void main(String[] args) {

        XStream xStream = new XStream(new DomDriver());

        xStream.alias("person", Person.class);
        xStream.alias("phoneNumber", PhoneNumber.class);

        Person joao = new Person("João", "Vidal");
        joao.setPhone(new PhoneNumber(11, "4002-8922"));
        joao.setFax(new PhoneNumber(11, "888666"));

        String xml = xStream.toXML(joao);


        System.out.println(xml);
    }
}