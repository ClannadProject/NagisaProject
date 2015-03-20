package de.knoobie.project.nagisa.gson.model.dto.json.organisation;

import com.google.gson.annotations.SerializedName;
import de.knoobie.project.nagisa.gson.model.dto.json.common.Meta;
import de.knoobie.project.nagisa.gson.model.dto.json.common.Websites;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data class Organisation {

    private String description;
    private String link;
    private String name;
    private String region;
    private String type;
    @SerializedName("picture_full")
    private String pictureFull;
    @SerializedName("picture_small")
    private String pictureSmall;
    @SerializedName("vgmdb_link")
    private String vgmdbLink;

    private Meta meta;
    private Websites websites;

    private List<OrganisationRelease> releases = new ArrayList<>();

}
