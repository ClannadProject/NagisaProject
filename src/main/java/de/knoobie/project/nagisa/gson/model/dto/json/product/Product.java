package de.knoobie.project.nagisa.gson.model.dto.json.product;

import com.google.gson.annotations.SerializedName;
import de.knoobie.project.nagisa.gson.model.dto.json.common.Meta;
import de.knoobie.project.nagisa.gson.model.dto.json.common.Websites;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author cKnoobie
 */
public @Data
class Product {

    private List<ProductAlbum> albums = new ArrayList<>();
    private String description;
    private List<ProductTitle> francises = new ArrayList<>();
    private String link;
    private Meta meta;   
    private String name;
    @SerializedName("real_name")
    private String realName;
    // only by Francise
    private List<ProductTitle> titles = new ArrayList<>();
    private List<String> organizations = new ArrayList<>();;
    @SerializedName("picture_full")
    private String pictureFull;
    @SerializedName("picture_small")
    private String pictureSmall;
    @SerializedName("release_date")
    private String releaseDate;
    // only by Game? Game Version // Releases in different countries inkl. platform & region
    // by Video -> Empty
    // by Francise -> non existend
    private List<ProductTitle> releases = new ArrayList<>();
    // Game, Video, Francise  -- Radio & Drama, Print Publication, Goods
    private String type;
    @SerializedName("vgmdb_link")
    private String vgmdbLink;
    
    private Websites websites;
    
}
