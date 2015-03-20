package de.knoobie.project.nagisa.gson.model.dto.json.search;

import com.google.gson.annotations.SerializedName;
import de.knoobie.project.nagisa.gson.model.dto.json.common.Meta;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data
class SearchResult {

@SerializedName("vgmdb_link")
private String vgmdbLink;
private String link;
private String query;

private Meta meta;

private Result results;

private List<String> sections = new ArrayList<>();

}
