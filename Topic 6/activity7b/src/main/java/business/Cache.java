package business;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import beans.Album;

@Startup
@Singleton
public class Cache {
	private HashMap<String, Album> cache;
	
	@PostConstruct
	public void init() {
		cache = new HashMap<String, Album>();
	}
	
	public Album getObject(Album album) {
		String key = album.getTitle() + " by " + album.getArtist() + " - " + album.getYear();
		if(cache.containsKey(key)) {
			System.out.println(key + " cache successful");
			return cache.get(key);
		}
		else {
			System.out.println(key + " cache failed");
			return null;
		}
	}
	
	public void putObject(Album album) {
		String key = album.getTitle() + " by " + album.getArtist() + " - " + album.getYear();
		cache.put(key, album);
		System.out.println(key + " cache placed");
	}
}
