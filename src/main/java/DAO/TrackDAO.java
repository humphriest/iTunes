package DAO;

import entities.Track;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import persistence.persistenceUtil;

public class TrackDAO {
    protected static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("dt354jdbc");


    public static List<Track> findAllTracks(){
        EntityManager em = emf.createEntityManager();
        List<Track> tracks = (List<Track>)
                em.createNamedQuery("Track.findAll").getResultList();
        em.close();

        return tracks;
    }


    public static Track findTrackById(int track_id){

        EntityManager em = emf.createEntityManager();
        List<Track> tracks = (List<Track>)
                em.createNamedQuery("Track.findByID").
                        setParameter("track_id", track_id).getResultList();
        em.close();

        if (tracks.size() == 0)
            return null;
        else
            return tracks.get(0);
    }

    public static void createTrack(Track track){
        persistenceUtil.persist(track);
    }
}
