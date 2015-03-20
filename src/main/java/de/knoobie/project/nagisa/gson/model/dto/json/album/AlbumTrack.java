package de.knoobie.project.nagisa.gson.model.dto.json.album;

import de.knoobie.project.nagisa.gson.model.dto.json.common.Names;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

public @Data class AlbumTrack {

    private Names names;
    @SerializedName("track_length")
    private String trackLength;

}