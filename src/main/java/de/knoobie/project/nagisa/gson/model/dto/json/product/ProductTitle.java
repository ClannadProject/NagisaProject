package de.knoobie.project.nagisa.gson.model.dto.json.product;

import de.knoobie.project.nagisa.gson.model.dto.json.common.Names;
import lombok.Data;

public @Data
class ProductTitle {

    private String date;
    private Names names;
    private String link;
    private String platform;
    private String region;
}
