package de.knoobie.project.nagisa.gson.model.dto.json.product;

import com.google.gson.annotations.SerializedName;
import de.knoobie.project.nagisa.gson.model.dto.json.common.Names;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author cKnoobie
 */
public @Data
class ProductAlbum {

    private String catalog;
    private String date;
    private String link;
    private String type;
    private Boolean reprint;
    @SerializedName("titles")
    private Names names;
    private List<String> classifications = new ArrayList<>();

}
