package de.knoobie.project.nagisa.gson.model.dto.json.search;

import de.knoobie.project.nagisa.gson.model.dto.json.common.Names;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data
class ResultArtist {

    private String link;
    private Names names;
    
    private List<String> aliases = new ArrayList<>();
}
