package de.knoobie.project.nagisa.gson.model.dto.json.album;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

public @Data class AlbumDisc {

    @SerializedName("disc_length")
    private String discLength;
    private String name;
    private List<AlbumTrack> tracks = new ArrayList<>();

}