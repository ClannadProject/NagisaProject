package de.knoobie.project.nagisa.gson.model.dto.json.search;

import com.google.gson.annotations.SerializedName;
import de.knoobie.project.nagisa.gson.model.dto.json.common.Names;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data
class ResultArtist {

    private String link;
    
    @SerializedName("titles")
    private Names names;
    
    private List<String> aliases = new ArrayList<>();
}
