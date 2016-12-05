package parser;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import entities.Track;

public class XMLParser {

    public List<Track> getTracks() {

        List<Track> library = null;
        try {

            //ArrayList<Track> library = new ArrayList<>();

            File fXmlFile = new File("C:\\Users\\Tim\\Desktop\\College\\DT354-4\\i\\new.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("dict");
            Node dict;
            NodeList nList2;

            library = new ArrayList<>();
            Track track = null;

            for (int j = 3; j < nList.getLength(); j++) {

                dict = nList.item(j);
                nList2 = dict.getChildNodes();

                if (dict.getParentNode().getPreviousSibling().getPreviousSibling().getTextContent().equals("Tracks")) {
                    for (int i = 2; i < nList2.getLength(); i += 3) {

                        track = new Track();
                        Node nNode = nList2.item(i);
                        String prev = nNode.getPreviousSibling().getTextContent();
                        String curr = nNode.getTextContent();


                        switch (prev) {
                            case "Track ID":
                                track.setTrack_id(Integer.parseInt(curr));
                                //System.out.println("Track ID: " +curr);
                                break;
                            case "Name":
                                //System.out.println("Name: "+curr);
                                track.setSong_name(curr);
                                break;
                            case "Artist":
                                //System.out.println("Artist: " +curr);
                                track.setArtist(curr);
                                break;
                            case "Album":
                                track.setAlbum(curr);
                                //System.out.println("Album: "+curr);
                                break;
                            case "Genre":
                                //System.out.println("Genre: "+curr);
                                track.setGenre(curr);
                                break;

                        }

                    }
                    library.add(track);
                }
            }

            System.out.println("Count is: " + library.size());

            for (Track t : library) {
                System.out.println(t.getArtist());
                System.out.println(t.getSong_name());
                System.out.println("");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return library;
    }

}
