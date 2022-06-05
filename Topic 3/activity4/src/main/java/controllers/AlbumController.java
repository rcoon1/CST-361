package controllers;





import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import beans.Album;
import business.MusicManager;
import util.TracksNotFoundException;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped

public class AlbumController implements Serializable{

	public String onSubmit(Album album) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		try {
		MusicManager musicManager = new MusicManager();
		Album a = musicManager.addAlbum(album);
		System.out.println("Printing to the console.");
		} catch(TracksNotFoundException e) {
			System.out.println(e.getMessage());
		}
		ctx.getExternalContext().getRequestMap().put("album", album);
		ctx.getExternalContext().getRequestMap().put("trackCount", album.getNumberTracks());
		
		return "AddAlbumResponse.xhtml";
	}
}