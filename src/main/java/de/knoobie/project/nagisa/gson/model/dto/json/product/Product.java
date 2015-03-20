package de.knoobie.project.nagisa.gson.model.dto.json.product;

import com.google.gson.annotations.SerializedName;
import de.knoobie.project.nagisa.gson.model.dto.json.common.Meta;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author cKnoobie
 */
public @Data
class Product {

    private String link;
    private String name;
    private String type;
    @SerializedName("vgmdb_link")
    private String vgmdbLink;
    private Meta meta;
    private List<ProductAlbum> albums = new ArrayList<>();
    private List<ProductTitle> titles = new ArrayList<>();
}
