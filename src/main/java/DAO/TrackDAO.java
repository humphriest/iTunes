package DAO;

import entities.Track;

import persistence.persistenceUtil;

public class TrackDAO {


    public static void createTrack(Track track){
        persistenceUtil.persist(track);
    }
}
