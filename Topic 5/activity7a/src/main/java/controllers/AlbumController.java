package controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.Album;
import business.MusicManagerInterface;
import util.AlbumNotFoundException;
import util.TracksNotFoundException;

@ManagedBean
@ViewScoped
public class AlbumController {	
	@EJB
	MusicManagerInterface mgr;
	
	public String onSubmit(Album album) {	
		try {
			album = mgr.addAlbum(album);
		}
		catch (TracksNotFoundException e) {
			System.out.println("Tracks not found");
		}
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("album", album);
		return "AddAlbumResponse.xhtml";
	}
	
	public String onFind(Album album) {
		try {
			mgr.getAlbum(album);
		}
		catch(AlbumNotFoundException e) {
			System.out.println("Album not found");
		}
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("album", album);
		return "AddAlbumResponse.xhtml";
	}
}
