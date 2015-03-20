package de.knoobie.project.nagisa.gson.model.dto.json.event;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data
class Event {

    private String startdate;
    private String enddate;
    private String link;
    private String name;
    private String notes;
    @SerializedName("vgmdb_link")
    private String vgmdbLink;
    private List<EventRelease> releases = new ArrayList<>();


}
