package org.kodejava.example.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class JAXBObjectToXmlFile {
    public static void main(String[] args) {
        Track track = new Track();
        track.setId(2);
        track.setTitle("She Loves You");

        try {
            JAXBContext context = JAXBContext.newInstance(Track.class);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            File output = new File("Track.xml");
            marshaller.marshal(track, output);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}