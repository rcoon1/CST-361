package business;

import beans.Album;
import util.TracksNotFoundException;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class MusicManager
 */
// @Stateless
@Local(MusicManagerInterface.class)
@LocalBean
public class MusicManager implements MusicManagerInterface {
    ArrayList<Album> albums;
    /**
     * Default constructor. 
     */
    public MusicManager() {
        // TODO Auto-generated constructor stub
    	this.albums = new ArrayList<Album>();
    }

	/**
     * @see MusicManagerInterface#addAlbum(Album)
     */
    public Album addAlbum(Album album) {
    	if(album.getTracks().size() == 0) throw new TracksNotFoundException("No tracks to be found for this album");
    	this.albums.add(album);
		return album;
    }
}
