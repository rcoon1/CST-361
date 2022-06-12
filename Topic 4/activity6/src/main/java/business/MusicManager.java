package business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import beans.Album;
import beans.Track;
import data.DataAccessInterface;
import data.MusicDataService;
import util.AlbumNotFoundException;
import util.TracksNotFoundException;

@Stateless
@Local(MusicManagerInterface.class)
@LocalBean
public class MusicManager implements MusicManagerInterface {

	@EJB
	DataAccessInterface dao; 
	
	HashMap<String, List<Track>> trackInfo;
	
	public MusicManager() {

		trackInfo = new HashMap<String, List<Track>>();
		List<Track> listOfTracks = new ArrayList<Track>();
		/*
		 * listOfTracks.add(new Track("3 A.M.", 1)); listOfTracks.add(new
		 * Track("All About that Bass", 2)); listOfTracks.add(new Track("Mr. Almost",
		 * 3)); trackInfo.put("Title by Meghan Trainor (2014)", listOfTracks);
		 */
	}

	private List<Track> getTracks(Album album) {

		String key = album.getTitle() + " by " + album.getArtist() + " (" + album.getYear() + ")";

		if(trackInfo.containsKey(key))
		{
			return trackInfo.get(key);
		}
		else
		{
			return new ArrayList<Track>();
		}
	}
	
	@Override
	public Album addAlbum(Album album) throws TracksNotFoundException {
		album.setTracks(getTracks(album));
		
		//if(album.getNumberTracks() == 0)
		//	throw new TracksNotFoundException();
		
		
		MusicDataService dao = new MusicDataService();
		dao.create(album); 
		Album album2 = dao.findBy(album);
		
		if(album2 == null) {
			System.out.println("--------Album does not exist---------");
			dao.create(album);
			album = dao.findBy(album);
			
		}else {
			System.out.println("-------Album exists----------");
		}
		
		return album;
	}
	

	@Override
	public Album getAlbum(Album album) throws AlbumNotFoundException{
		MusicDataService dao = new MusicDataService();
		
		Album albumFound = dao.findBy(album);
		
		if(albumFound == null)
			throw new AlbumNotFoundException();
		else
			return albumFound;

	}
}
