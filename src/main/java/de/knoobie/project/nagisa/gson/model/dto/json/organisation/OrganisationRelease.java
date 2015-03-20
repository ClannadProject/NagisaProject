package de.knoobie.project.nagisa.gson.model.dto.json.organisation;

import com.google.gson.annotations.SerializedName;
import de.knoobie.project.nagisa.gson.model.dto.json.common.Names;
import lombok.Data;

public @Data
class OrganisationRelease {

    private String catalog;
    private String date;
    private String link;
    private String role;
    private String type;

    private Boolean reprint;

    private OrganisationReleaseEvent event;
    
    @SerializedName("titles")
    private Names names;
}
