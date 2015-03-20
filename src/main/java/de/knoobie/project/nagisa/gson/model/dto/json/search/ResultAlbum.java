package de.knoobie.project.nagisa.gson.model.dto.json.search;

import com.google.gson.annotations.SerializedName;
import de.knoobie.project.nagisa.gson.model.dto.json.common.Names;
import lombok.Data;

public @Data class ResultAlbum {

    @SerializedName("release_date")
    private String releaseDate;
    private String catalog;
    private String link;
    
    @SerializedName("titles")
    private Names names;
}
