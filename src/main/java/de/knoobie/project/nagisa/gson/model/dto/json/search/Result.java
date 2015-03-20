package de.knoobie.project.nagisa.gson.model.dto.json.search;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data
class Result {

    private List<ResultAlbum> albums = new ArrayList<>();
    private List<ResultArtist> artists = new ArrayList<>();
    private List<ResultOrganisation> orgs = new ArrayList<>();
    private List<ResultProduct> products = new ArrayList<>();

}
