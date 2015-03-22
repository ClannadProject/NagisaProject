package de.knoobie.project.nagisa.gson.util;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import de.knoobie.project.clannadutils.common.IOUtils;
import de.knoobie.project.clannadutils.common.NetUtils;
import de.knoobie.project.clannadutils.common.StringUtils;
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
import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class VGMdb {

    private static final String VGMDB_URL = "http://vgmdb.info";
    private static final String VGMDB_FORMAT_PARAMETER = "format=json";

    public static VGMdbSearch search(String query) throws
            IllegalArgumentException, JsonSyntaxException, IOException {
        return new VGMdbSearch(get(createJSON(VGMdbSearch.VGMDB_DIR, query), SearchResult.class));
    }

    public static VGMdbArtist getArtist(String query) throws
            IllegalArgumentException, JsonSyntaxException, IOException {
        return new VGMdbArtist(get(createJSON(VGMdbArtist.VGMDB_DIR, query), Artist.class));
    }

    public static VGMdbAlbum getAlbum(String query) throws
            IllegalArgumentException, JsonSyntaxException, IOException {
        return new VGMdbAlbum(get(createJSON(VGMdbAlbum.VGMDB_DIR, query), Album.class));
    }

    public static VGMdbProduct getProduct(String query) throws
            IllegalArgumentException, JsonSyntaxException, IOException {
        return new VGMdbProduct(get(createJSON(VGMdbProduct.VGMDB_DIR, query), Product.class));
    }

    public static VGMdbEvent getEvent(String query) throws
            IllegalArgumentException, JsonSyntaxException, IOException {
        return new VGMdbEvent(get(createJSON(VGMdbEvent.VGMDB_DIR, query), Event.class));
    }

    public static VGMdbOrganisation getOrganisation(String query) throws
            IllegalArgumentException, JsonSyntaxException, IOException {
        return new VGMdbOrganisation(get(createJSON(VGMdbOrganisation.VGMDB_DIR, query), Organisation.class));
    }

    private static <T> T get(String json, Class<T> classOfT) throws JsonSyntaxException {
        if (!StringUtils.isEmpty(json)) {
            json = json.replaceAll("\\\\\"", "");
//            stringToFile(json, "C:\\kantai-json.txt");
//            System.out.println(json);
        }
        return new GsonBuilder()
                //    .setPrettyPrinting()
                //    .disableHtmlEscaping()
                .create().fromJson(json, classOfT);
    }

//    private static void stringToFile( String text, String fileName )
// {
// try
// {
//     File file = new File( fileName );
//
//    // if file doesnt exists, then create it 
//    if ( ! file.exists( ) )
//    {
//        file.createNewFile( );
//    }
//
//    FileWriter fw = new FileWriter( file.getAbsoluteFile( ) );
//    BufferedWriter bw = new BufferedWriter( fw );
//    bw.write( text );
//    bw.close( );
//    //System.out.println("Done writing to " + fileName); //For testing 
// }
// catch( IOException e )
// {
// System.out.println("Error: " + e);
// e.printStackTrace( );
// }
//} 
    private static String createJSON(String hierachy, String query) throws IOException, IllegalArgumentException {
        try {
            return readUrl(VGMDB_URL
                    + "/"
                    + NetUtils.normalizeFragment(hierachy)
                    + "/"
                    + NetUtils.normalizeFragment(query)
                    + "?"
                    + VGMDB_FORMAT_PARAMETER);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Couldn't find any data with query: " + query, e);
        }
    }

    private static String readUrl(String url) throws IOException, FileNotFoundException {
        return IOUtils.getString(new BufferedReader(
                new InputStreamReader(NetUtils.getInputStream(url), "UTF-8")));

    }
}
