package DAO;

import entities.Library;
import entities.Track;

import persistence.persistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUtil;
import java.util.ArrayList;
import java.util.List;

public class TrackDAO {

    public void createTrack(Track track){
        persistenceUtil.persist(track);
    }

    public List<Track> findByLibray(Library library){

        EntityManager em = persistenceUtil.createEM();
        List<Track> tracks = (List<Track>)
                em.createNamedQuery("Track.findByLibrary").
                        setParameter("library", library).getResultList();
        em.close();
        return tracks;
    }
}
