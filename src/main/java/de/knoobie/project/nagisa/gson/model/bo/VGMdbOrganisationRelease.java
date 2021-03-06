package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.nagisa.gson.model.dto.json.organisation.OrganisationRelease;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data
class VGMdbOrganisationRelease {

    private String catalog;
    private String date;
    private String link;
    private String role;
    private String type;

    private Boolean reprint;
    private VGMdbEvent event;

    private List<VGMdbName> names = new ArrayList<>();

    public VGMdbOrganisationRelease(OrganisationRelease release) {
        if (release == null) {
            this.setDate(StringUtils.EMPTY);
            this.setCatalog(StringUtils.EMPTY);
            this.setLink(StringUtils.EMPTY);
            this.setRole(StringUtils.EMPTY);
            this.setType(StringUtils.EMPTY);
            this.setReprint(Boolean.FALSE);
            return;
        }

        this.setNames(VGMdbName.parseNames(release.getNames()));
        this.setDate(StringUtils.trim(release.getDate()));
        this.setCatalog(StringUtils.trim(release.getCatalog()));
        this.setLink(StringUtils.trim(release.getLink()));
        this.setRole(StringUtils.trim(release.getRole()));
        this.setType(StringUtils.trim(release.getType()));
        this.setReprint(release.getReprint() == null ? Boolean.FALSE : release.getReprint());
        if (release.getEvent()!= null) {
            this.setEvent(new VGMdbEvent(release.getEvent()));
        }
    }

}
