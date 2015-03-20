package de.knoobie.project.nagisa.gson.model.dto.json.common;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

public @Data
class Meta {

    @SerializedName("added_date")
    private String addedDate;
    @SerializedName("added_user")
    private String addedUser;

    @SerializedName("edited_date")
    private String editedDate;
    @SerializedName("edited_user")
    private String editedUser;

    private Integer freedb;
    private Integer ttl;
    private Integer visitors;

}
