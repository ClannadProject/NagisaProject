package de.knoobie.project.nagisa.gson.model.dto.json.album;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data
class AlbumWebsites {

    private List<AlbumReview> Review = new ArrayList<>();

}
