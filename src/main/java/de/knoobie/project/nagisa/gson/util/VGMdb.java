package de.knoobie.project.nagisa.gson.util;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import de.knoobie.project.clannadutils.common.IOUtils;
import de.knoobie.project.clannadutils.common.NetUtils;
import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.nagisa.gson.model.bo.TransientAlbum;
import de.knoobie.project.nagisa.gson.model.bo.TransientArtist;
import de.knoobie.project.nagisa.gson.model.bo.TransientEvent;
import de.knoobie.project.nagisa.gson.model.bo.TransientOrganisation;
import de.knoobie.project.nagisa.gson.model.bo.TransientProduct;
import de.knoobie.project.nagisa.gson.model.bo.TransientSearch;
import de.knoobie.project.nagisa.gson.model.dto.json.album.Album;
import de.knoobie.project.nagisa.gson.model.dto.json.artist.Artist;
import de.knoobie.project.nagisa.gson.model.dto.json.event.Event;
import de.knoobie.project.nagisa.gson.model.dto.json.organisation.Organisation;
import de.knoobie.project.nagisa.gson.model.dto.json.product.Product;
import de.knoobie.project.nagisa.gson.model.dto.json.search.SearchResult;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;

/**
 *
 * @author cKnoobie
 */
public class VGMdb {

    private static final String VGMDB_URL = "http://vgmdb.info";
    private static final String VGMDB_FORMAT_PARAMETER = "format=json";
    
    public static TransientSearch search(String query) throws
            JsonSyntaxException, IllegalArgumentException, SocketTimeoutException, MalformedURLException, IOException {
        return new TransientSearch(get(createJSON(TransientSearch.VGMDB_DIR, query), SearchResult.class));
    }
    
    public static TransientArtist getArtist(String query) throws
            JsonSyntaxException, IllegalArgumentException, SocketTimeoutException, MalformedURLException, IOException {
        return new TransientArtist(get(createJSON(TransientArtist.VGMDB_DIR, query), Artist.class));
    }

    public static TransientAlbum getAlbum(String query) throws
            JsonSyntaxException, IllegalArgumentException, SocketTimeoutException, MalformedURLException, IOException {
        return new TransientAlbum(get(createJSON(TransientAlbum.VGMDB_DIR, query), Album.class));
    }

    public static TransientProduct getProduct(String query) throws
            JsonSyntaxException, IllegalArgumentException, SocketTimeoutException, MalformedURLException, IOException {
        return new TransientProduct(get(createJSON(TransientProduct.VGMDB_DIR, query), Product.class));
    }

    public static TransientEvent getEvent(String query) throws
            JsonSyntaxException, IllegalArgumentException, SocketTimeoutException, MalformedURLException, IOException {
        return new TransientEvent(get(createJSON(TransientEvent.VGMDB_DIR, query), Event.class));
    }

    public static TransientOrganisation getOrganisation(String query) throws
            JsonSyntaxException, IllegalArgumentException, SocketTimeoutException, MalformedURLException, IOException {
        return new TransientOrganisation(get(createJSON(TransientOrganisation.VGMDB_DIR, query), Organisation.class));
    }

    private static <T> T get(String json, Class<T> classOfT) throws JsonSyntaxException, IllegalArgumentException {
        if (StringUtils.isEmpty(json)) {
            throw new IllegalArgumentException("JSON can't be empty/null");
        }
        return new GsonBuilder().create().fromJson(json, classOfT);
    }

    private static String createJSON(String hierachy, String query) throws SocketTimeoutException, MalformedURLException, IOException {
        return readUrl(VGMDB_URL
                + "/"
                + NetUtils.normalizeFragment(hierachy)
                + "/"
                + NetUtils.normalizeFragment(query)
                + "?"
                + VGMDB_FORMAT_PARAMETER);
    }

    private static String readUrl(String url) throws SocketTimeoutException, MalformedURLException, IOException {
        return IOUtils.getString(new BufferedReader(
                new InputStreamReader(NetUtils.getInputStream(url))));

    }
}
