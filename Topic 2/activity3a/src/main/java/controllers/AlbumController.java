package controllers;





import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import beans.Album;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped

public class AlbumController implements Serializable{

	public String onSubmit(Album album) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.getExternalContext().getRequestMap().put("album", album);
		return "AddAlbumResponse.xhtml";
	}
}