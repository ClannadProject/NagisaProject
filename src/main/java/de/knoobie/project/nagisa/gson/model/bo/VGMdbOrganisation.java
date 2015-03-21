package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.ListUtils;
import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.nagisa.gson.model.dto.json.common.Names;
import de.knoobie.project.nagisa.gson.model.dto.json.organisation.Organisation;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data
class VGMdbOrganisation {

    public static final String VGMDB_DIR = "org";

    private String link;
    private String name;
    private String description;
    private String region;
    private String type;
    private String vgmdbLink;

    private VGMdbPicture picture;
    private VGMdbMeta meta;

    private List<VGMdbName> aliases = new ArrayList<>();
    private List<VGMdbOrganisationRelease> releases = new ArrayList<>();

    public VGMdbOrganisation(Names names, String link) {
        this.setAliases(VGMdbName.parseNames(names));
        this.setLink(StringUtils.trim(link));
    }

    public VGMdbOrganisation(Organisation organisation) {
        if (organisation == null) {
            System.out.println("Generated empty transientorganisation. Organisation was null.");
            return;
        }

        this.setLink(StringUtils.trim(organisation.getLink()));
        this.setName(StringUtils.trim(organisation.getName()));
        this.setDescription(StringUtils.trim(organisation.getDescription()));
        this.setRegion(StringUtils.trim(organisation.getRegion()));
        this.setType(StringUtils.trim(organisation.getType()));
        this.setVgmdbLink(StringUtils.trim(organisation.getVgmdbLink()));

        this.setPicture(new VGMdbPicture(StringUtils.trim(organisation.getPictureSmall()),
                StringUtils.trim(organisation.getPictureFull())));
        this.setMeta(new VGMdbMeta(organisation.getMeta()));

        if (!ListUtils.isEmpty(organisation.getReleases())) {
            organisation.getReleases().stream().forEach((release) -> {
                getReleases().add(new VGMdbOrganisationRelease(release));
            });
        }
    }

}
