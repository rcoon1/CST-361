package business;

import beans.Album;
import util.AlbumNotFoundException;
import util.TracksNotFoundException;

public interface MusicManagerInterface {
	 Album addAlbum(Album album) throws TracksNotFoundException;
	 Album getAlbum(Album album) throws AlbumNotFoundException; 
}
