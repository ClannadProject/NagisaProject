package de.knoobie.project.nagisa.gson.model.dto.json.album;

import de.knoobie.project.nagisa.gson.model.dto.json.common.Meta;
import de.knoobie.project.nagisa.gson.model.dto.json.common.Names;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

public @Data class Album {

    @SerializedName("media_format")
    private String mediaFormat;

    private String catalog;
    private String category;
    private String classification;
    private String link;
    private String name;
    private String notes;
    @SerializedName("picture_full")
    private String pictureFull;
    @SerializedName("picture_small")
    private String pictureSmall;
    @SerializedName("publish_format")
    private String publishFormat;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("vgmdb_link")
    private String vgmdbLink;

    private Meta meta;
    private Names names;
    private AlbumPublisher publisher;
    private AlbumDistributor distributor;
    private Double rating;
    @SerializedName("release_price")
    private AlbumReleasePrice releasePrice;
    private Integer votes;
    private AlbumWebsites websites;
    
    private List<AlbumComposer> composers = new ArrayList<>();
    private List<AlbumArranger> arrangers = new ArrayList<>();
    private List<AlbumLyricist> lyricists = new ArrayList<>();
    private List<AlbumPerformer> performers = new ArrayList<>();
    private List<AlbumCover> covers = new ArrayList<>();
    private List<AlbumDisc> discs = new ArrayList<>();
    private List<AlbumProduct> products = new ArrayList<>();
    private List<AlbumRelated> related = new ArrayList<>();
    private List<AlbumReprint> reprints = new ArrayList<>();
    private List<AlbumStore> stores = new ArrayList<>();    
    
    private List<String> platforms = new ArrayList<>();
    private List<AlbumReleaseEvent> events = new ArrayList<>();

}
