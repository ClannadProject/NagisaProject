package de.knoobie.project.nagisa.gson.model.dto.json.artist;

import de.knoobie.project.nagisa.gson.model.dto.json.common.Names;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data
class ArtistFeaturedOn {

    private String catalog;
    private String date;
    private String link;
    private String type;
    
    private List<String> roles = new ArrayList<>();
    
    private Names titles;

}
