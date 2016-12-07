package parser;

import entities.Playlist;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Track;
import org.xml.sax.SAXException;

public class XMLParser {

    public List<Playlist> getPlaylists() {
        List<Track> trackslist = getTracks();
        ArrayList<Playlist> playlists = new ArrayList<>();
        Playlist playlist;

        ArrayList<Track> trackList = new ArrayList<>();
        File fXmlFile = new File("C:\\Users\\Tim\\Desktop\\College\\DT354-4\\i\\new.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            String nameExpression = "//dict/key[. = 'Playlists']/following-sibling::*[1]/child::*";
            XPath xPath = XPathFactory.newInstance().newXPath();
            NodeList nodeList = (NodeList) xPath.compile(nameExpression).evaluate(doc, XPathConstants.NODESET);

            System.out.println("node list count is:" + nodeList.getLength());
            //System.out.println("playlist node list count is: " + playListNodeList.getLength());
            for (int i = 0; i < nodeList.getLength(); i++) {
                playlist = new Playlist();
                Node playlistNode = nodeList.item(i);
                //System.out.println(playlistNode.getNodeName());
                if (playlistNode.getNodeName().equals("dict")) {
                    //System.out.println("Found dict-------");
                    NodeList playlistsNode = playlistNode.getChildNodes();
                    for (int a = 0; a < playlistsNode.getLength(); a++) {
                        Node another = playlistsNode.item(a);
                        //System.out.println(another.getTextContent()+" here--");
                        if (another.getTextContent().equals("Name")) {
                            //System.out.println("Name: " + another.getNextSibling().getTextContent());
                            playlist.setPlaylistName(another.getNextSibling().getTextContent());
                        } else if (another.getTextContent().equals("Playlist ID")) {
                            //System.out.println("Playlist ID: " + another.getNextSibling().getTextContent());
                            playlist.setPlaylistId(Integer.parseInt(another.getNextSibling().getTextContent()));
                        } else if (another.getTextContent().equals("Playlist Persistent ID")) {
                            //System.out.println("Persistent ID: " + another.getNextSibling().getTextContent());
                            playlist.setPlaylistPersistenceId(another.getNextSibling().getTextContent());
                        } else if (another.getTextContent().equals("Playlist Items")) {
                            //System.out.println("Playlist Items: ");
                            NodeList items = another.getNextSibling().getNextSibling().getChildNodes();
                            //System.out.println(items.getLength()+"length");
                            for (int x = 0; x < items.getLength(); x++) {
                                Node xitem = items.item(x);
                                NodeList mostItems = xitem.getChildNodes();
                                for (int h = 0; h < mostItems.getLength(); h++) {
                                    Node something = mostItems.item(h);
                                    if (something.getTextContent().equals("Track ID")) {
                                        String current = something.getNextSibling().getTextContent();
                                        //System.out.println(current);
                                        //System.out.println("Getting to here Test 1");
                                        for (Track t : trackslist) {
                                            //System.out.println(t.getSong_name());
                                            //System.out.println("Getting to here Test 1");
                                            if (Integer.parseInt(current) == t.getTrack_id()) {
                                                trackList.add(t);
                                                playlist.setTracks(trackList);
                                            }
                                        }
                                    }

                                }
                            }//System.out.println(trackList);
                            playlists.add(playlist);
                        }
                    }
                }
            }
            System.out.println("Count is: " + playlists.size());

            for (Playlist p : playlists) {
                System.out.println(p.getPlaylistName());
                System.out.println(p.getPlaylistPersistenceId());
                System.out.println(p.getTracks());
                System.out.println("");
            }
        } catch (ParserConfigurationException | IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }


        return playlists;
    }

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
            Track track;

            for (int j = 3; j < nList.getLength(); j++) {
                track = new Track();
                dict = nList.item(j);
                nList2 = dict.getChildNodes();

                if (dict.getParentNode().getPreviousSibling().getPreviousSibling().getTextContent().equals("Tracks")) {
                    for (int i = 2; i < nList2.getLength(); i += 3) {


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
