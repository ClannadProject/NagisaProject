package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.ListUtils;
import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.nagisa.gson.model.dto.json.common.Names;
import de.knoobie.project.nagisa.gson.model.dto.json.event.Event;
import de.knoobie.project.nagisa.gson.model.dto.json.organisation.OrganisationReleaseEvent;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data
class TransientEvent {

    private String startdate;
    private String enddate;
    private String link;
    private String shortname;
    private String name;
    private String description;
    private String vgmdbLink;

    private List<TransientEventRelease> releases = new ArrayList<>();
    
    public TransientEvent(OrganisationReleaseEvent event) {
        if (event == null) {
            return;
        }
        this.setName(StringUtils.trim(event.getName()));
        this.setLink(StringUtils.trim(event.getLink()));
        this.setShortname(StringUtils.trim(event.getShortname()));
    }
    
    public TransientEvent(Event event) {
        if (event == null) {
            return;
        }
        this.setName(StringUtils.trim(event.getName()));
        this.setDescription(StringUtils.trim(event.getNotes()));
        this.setStartdate(StringUtils.trim(event.getStartdate()));
        this.setEnddate(StringUtils.trim(event.getEnddate()));
        this.setLink(StringUtils.trim(event.getLink()));
        this.setVgmdbLink(StringUtils.trim(event.getVgmdbLink()));
        this.setShortname(StringUtils.EMPTY);

        if (!ListUtils.isEmpty(event.getReleases())) {
            event.getReleases().stream().forEach((release) -> {
                getReleases().add(new TransientEventRelease(release));
            });
        }
    }

}
