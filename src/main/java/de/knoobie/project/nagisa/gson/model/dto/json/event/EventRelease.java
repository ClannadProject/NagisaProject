package de.knoobie.project.nagisa.gson.model.dto.json.event;

import com.google.gson.annotations.SerializedName;
import de.knoobie.project.nagisa.gson.model.dto.json.common.Names;
import lombok.Data;

public @Data
class EventRelease {

    private String catalog;
    private String link;
    @SerializedName("album_type")
    private String albumType;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("release_type")
    private String releaseType;
    
    private EventReleasePublisher publisher;
    
    @SerializedName("titles")
    private Names names;
}
