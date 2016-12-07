package DAO;

import entities.Track;

import persistence.persistenceUtil;

public class TrackDAO {

    public void createTrack(Track track){
        persistenceUtil.persist(track);
    }
}
