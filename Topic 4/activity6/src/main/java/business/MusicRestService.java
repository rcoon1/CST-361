package business;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Album;
import beans.ResponseDataModel;
import util.AlbumNotFoundException;

@RequestScoped
@Path("/music")
@Produces("application/xml, application/json")
@Consumes("application/xml, application/json")
public class MusicRestService {
	
	@GET
	@Path("/getalbumj/{title}/{artist}/{year}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseDataModel getAlbumj(@PathParam("title") String title, @PathParam("artist") String artist, @PathParam("year") int year)
	{
		
		//create an instance of a MusicManager business service class
		MusicManager mgr = new MusicManager(); 
		
		//create an instance of an album
		Album album = new Album(title, artist, year);
		
		try {
		//find the album using the Business Service
		album = mgr.getAlbum(album);
		
		ResponseDataModel response = new ResponseDataModel(0, "", album);
		return response;
		
		} catch (AlbumNotFoundException e1)
		{
			ResponseDataModel response = new ResponseDataModel(-1, "Album Not Found", album);
			return response;
		} catch (Exception e2)
		{
			ResponseDataModel response = new ResponseDataModel(-2, "System Exception", album);
			return response;
		}
	}
	
	@GET
	@Path("/getalbumx/{title}/{artist}/{year}")
	@Produces(MediaType.APPLICATION_XML)
	public ResponseDataModel getAlbumx(@PathParam("title") String title, @PathParam("artist") String artist, @PathParam("year") int year)
	{
		//create an instance of a MusicManager business service class
		MusicManager mgr = new MusicManager(); 
				
		//create an instance of an album
		Album album = new Album(title, artist, year);
		
		try {
		//find the album using the Business Service
		album = mgr.getAlbum(album);
		
		ResponseDataModel response = new ResponseDataModel(0, "", album);
		return response;
		
		} catch (AlbumNotFoundException e1)
		{
			ResponseDataModel response = new ResponseDataModel(-1, "Album Not Found", album);
			return response;
		} catch (Exception e2)
		{
			ResponseDataModel response = new ResponseDataModel(-2, "System Exception", album);
			return response;
		}
	}
}