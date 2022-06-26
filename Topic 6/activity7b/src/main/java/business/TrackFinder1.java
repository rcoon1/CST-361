package business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Album;
import beans.Track;

@Stateless
@Local(TrackFinderInterface.class)
@LocalBean
@Alternative
public class TrackFinder1 implements TrackFinderInterface{
	HashMap<String, List<Track>> trackInfo;
	
	public TrackFinder1() {
		trackInfo = new HashMap<String, List<Track>>();
		List<Track> listOfTracks = new ArrayList<Track>();
		listOfTracks.add(new Track("Dumpweed", 1));
		listOfTracks.add(new Track("Don't Leave Me", 2));
		listOfTracks.add(new Track("Aliens Exist", 3));
		listOfTracks.add(new Track("Going Away to College", 4));
		listOfTracks.add(new Track("What's My Age Again", 5));
		listOfTracks.add(new Track("Dysentery Gary", 6));
		listOfTracks.add(new Track("Adam's Song", 7));
		listOfTracks.add(new Track("All the Small Things", 8));
		listOfTracks.add(new Track("The Party Song", 9));
		listOfTracks.add(new Track("Mutt", 10));
		listOfTracks.add(new Track("Wendy Clear", 11));
		listOfTracks.add(new Track("Anthem", 12));
		trackInfo.put("Enema of the State by Blink 182 - 1999", listOfTracks);
	}
	
	@Override
	public List<Track> getTracks(Album album) {
		String key = album.getTitle() + " by " + album.getArtist() + " - " + album.getYear();
		if (trackInfo.containsKey(key)) {
			return trackInfo.get(key);
		}
		else {
			return new ArrayList<Track>();
		}
	}
}