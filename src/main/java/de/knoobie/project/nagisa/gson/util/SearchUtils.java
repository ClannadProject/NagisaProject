package de.knoobie.project.nagisa.gson.util;

import com.google.gson.GsonBuilder;
import de.knoobie.project.nagisa.gson.model.dto.json.album.Album;
import de.knoobie.project.nagisa.gson.model.dto.json.artist.Artist;
import de.knoobie.project.nagisa.gson.model.dto.json.event.Event;
import de.knoobie.project.nagisa.gson.model.dto.json.organisation.Organisation;
import de.knoobie.project.nagisa.gson.model.dto.json.product.Product;
import de.knoobie.project.nagisa.gson.model.dto.json.search.SearchResult;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author cKnoobie
 */
public class SearchUtils {

    private static final String VGMDB_DIR_SEARCH = "search";
    private static final String VGMDB_DIR_ALBUM = "album";
    private static final String VGMDB_DIR_ARTIST = "artist";
    private static final String VGMDB_DIR_PRODUCT = "product";
    private static final String VGMDB_DIR_ORGANISATION = "org";
    private static final String VGMDB_DIR_EVENT = "event";
    
    public static SearchResult find(String query) throws Exception {
        return new GsonBuilder().create().fromJson(createJSON(VGMDB_DIR_SEARCH, query), SearchResult.class);
    }
    
    public static Artist getArtist(String query) throws Exception{
        return new GsonBuilder().create().fromJson(createJSON(VGMDB_DIR_ARTIST, query), Artist.class);        
    }
    
    public static Album getAlbum(String query) throws Exception{
        return new GsonBuilder().create().fromJson(createJSON(VGMDB_DIR_ALBUM, query), Album.class);        
    }
    
    public static Product getProduct(String query) throws Exception{
        return new GsonBuilder().create().fromJson(createJSON(VGMDB_DIR_PRODUCT, query), Product.class);        
    }
    
    public static Event getEvent(String query) throws Exception{
        return new GsonBuilder().create().fromJson(createJSON(VGMDB_DIR_EVENT, query), Event.class);        
    }
    
    public static Organisation getOrganisation(String query) throws Exception{
        return new GsonBuilder().create().fromJson(createJSON(VGMDB_DIR_ORGANISATION, query), Organisation.class);        
    }

    private static String createJSON(String hierachy, String query) throws Exception {
        return readUrl("http://vgmdb.info/" + hierachy.replace(" ", "%20") + "/" + query.replace(" ", "%20") + "?format=json");
    }

    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));

            StringBuilder buffer = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1) {
                buffer.append(chars, 0, read);
            }
//            System.out.println("buffer ->" + buffer.toString());
            return buffer.toString().trim();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}
