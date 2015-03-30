package de.knoobie.project.nagisa.gson.model.dto.json.album;

import de.knoobie.project.nagisa.gson.model.dto.json.common.Names;
import lombok.Data;

public @Data class AlbumRelated {

    private String catalog;
    private String link;
    private Names names;
    private String type;
    private String date;

}