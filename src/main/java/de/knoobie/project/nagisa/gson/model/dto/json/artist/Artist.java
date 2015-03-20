package de.knoobie.project.nagisa.gson.model.dto.json.artist;

import com.google.gson.annotations.SerializedName;
import de.knoobie.project.nagisa.gson.model.dto.json.common.Meta;
import de.knoobie.project.nagisa.gson.model.dto.json.common.Websites;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data
class Artist {

    private String birthdate;
    private String birthplace;
    private String notes;
    private String link;
    private String type;
    private String name;
    @SerializedName("vgmdb_link")
    private String vgmdbLink;
    private String sex;
    @SerializedName("picture_full")
    private String pictureFull;
    @SerializedName("picture_small")
    private String pictureSmall;
    private Meta meta;

    private List<ArtistAlias> aliases = new ArrayList<>();
    private List<ArtistDiscography> discography = new ArrayList<>();
    @SerializedName("featured_on")
    private List<ArtistFeaturedOn> featuredOn = new ArrayList<>();

    private ArtistInfo info;

    private List<ArtistLinkage> units = new ArrayList<>();
    private List<ArtistLinkage> members = new ArrayList<>();
    
    private Websites websites;
}
