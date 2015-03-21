package de.knoobie.project.nagisa.gson.util;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import de.knoobie.project.clannadutils.common.IOUtils;
import de.knoobie.project.clannadutils.common.NetUtils;
import de.knoobie.project.nagisa.gson.model.bo.VGMdbAlbum;
import de.knoobie.project.nagisa.gson.model.bo.VGMdbArtist;
import de.knoobie.project.nagisa.gson.model.bo.VGMdbEvent;
import de.knoobie.project.nagisa.gson.model.bo.VGMdbOrganisation;
import de.knoobie.project.nagisa.gson.model.bo.VGMdbProduct;
import de.knoobie.project.nagisa.gson.model.bo.VGMdbSearch;
import de.knoobie.project.nagisa.gson.model.dto.json.album.Album;
import de.knoobie.project.nagisa.gson.model.dto.json.artist.Artist;
import de.knoobie.project.nagisa.gson.model.dto.json.event.Event;
import de.knoobie.project.nagisa.gson.model.dto.json.organisation.Organisation;
import de.knoobie.project.nagisa.gson.model.dto.json.product.Product;
import de.knoobie.project.nagisa.gson.model.dto.json.search.SearchResult;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class VGMdb {

    private static final String VGMDB_URL = "http://vgmdb.info";
    private static final String VGMDB_FORMAT_PARAMETER = "format=json";
    
    public static VGMdbSearch search(String query) throws
            JsonSyntaxException, IOException, FileNotFoundException {
        return new VGMdbSearch(get(createJSON(VGMdbSearch.VGMDB_DIR, query), SearchResult.class));
    }
    
    public static VGMdbArtist getArtist(String query) throws
            JsonSyntaxException, IOException, FileNotFoundException {
        return new VGMdbArtist(get(createJSON(VGMdbArtist.VGMDB_DIR, query), Artist.class));
    }

    public static VGMdbAlbum getAlbum(String query) throws
            JsonSyntaxException, IOException, FileNotFoundException {
        return new VGMdbAlbum(get(createJSON(VGMdbAlbum.VGMDB_DIR, query), Album.class));
    }

    public static VGMdbProduct getProduct(String query) throws
            JsonSyntaxException, IOException, FileNotFoundException {
        return new VGMdbProduct(get(createJSON(VGMdbProduct.VGMDB_DIR, query), Product.class));
    }

    public static VGMdbEvent getEvent(String query) throws
            JsonSyntaxException, IOException, FileNotFoundException {
        return new VGMdbEvent(get(createJSON(VGMdbEvent.VGMDB_DIR, query), Event.class));
    }

    public static VGMdbOrganisation getOrganisation(String query) throws
            JsonSyntaxException, IOException, FileNotFoundException {
        return new VGMdbOrganisation(get(createJSON(VGMdbOrganisation.VGMDB_DIR, query), Organisation.class));
    }

    private static <T> T get(String json, Class<T> classOfT) throws JsonSyntaxException {
        return new GsonBuilder().create().fromJson(json, classOfT);
    }

    private static String createJSON(String hierachy, String query) throws IOException, FileNotFoundException  {
        return readUrl(VGMDB_URL
                + "/"
                + NetUtils.normalizeFragment(hierachy)
                + "/"
                + NetUtils.normalizeFragment(query)
                + "?"
                + VGMDB_FORMAT_PARAMETER);
    }

    private static String readUrl(String url) throws IOException, FileNotFoundException {
        return IOUtils.getString(new BufferedReader(
                new InputStreamReader(NetUtils.getInputStream(url))));

    }
}
