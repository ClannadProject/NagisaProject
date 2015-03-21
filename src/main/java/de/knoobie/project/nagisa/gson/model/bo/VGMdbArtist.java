package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.ListUtils;
import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.nagisa.gson.model.bo.enums.VGMdbArtistType;
import de.knoobie.project.nagisa.gson.model.bo.enums.VGMdbNameLanguage;
import de.knoobie.project.nagisa.gson.model.bo.enums.VGMdbWebsiteType;
import de.knoobie.project.nagisa.gson.model.dto.json.artist.Artist;
import de.knoobie.project.nagisa.gson.model.dto.json.common.Names;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data
class VGMdbArtist {

    public static final String VGMDB_DIR = "artist";

    private String name;
    private String link;
    private String description;
    private String vgmdbLink;

    private String Variations;
    // aliases
    private List<VGMdbName> aliases = new ArrayList<>();

    private List<String> CreditedWorks = new ArrayList<>();

    private VGMdbPicture picture;
    private VGMdbMeta meta;

    private List<VGMdbDiscography> discography = new ArrayList<>();
    private List<VGMdbDiscography> featuredOn = new ArrayList<>();
    private List<VGMdbWebsite> websites = new ArrayList<>();

    private VGMdbArtistType type;
    private VGMdbArtistPerson personInfo;
    private VGMdbArtistBand bandInfo;

    // @todo add Album Votes && weighted album rating
    public VGMdbArtist(Names names, String link) {
        this(names, new ArrayList<>(), link);
    }

    public VGMdbArtist(Names names, List<String> aliases, String link) {
        this.setAliases(VGMdbName.parseNames(names));

        if (!ListUtils.isEmpty(aliases)) {
            aliases.stream().forEach((alias) -> {
                this.getAliases().add(new VGMdbName(
                        StringUtils.trim(alias),
                        VGMdbNameLanguage.alias));
            });
        }
        if (!ListUtils.isEmpty(this.getAliases())) {
            this.getAliases().stream().filter((alias) -> (alias.getLanguage() == VGMdbNameLanguage.original
                    || alias.getLanguage() == VGMdbNameLanguage.eng)).forEach((aliasName) -> {
                        this.setName(StringUtils.trim(aliasName.getName()));
                    });
        }
        this.setLink(link);
    }

    public VGMdbArtist(Artist artist) {
        if (artist == null) {
            System.out.println("Generated empty transientartist. Artist was null.");
            return;
        }
        this.setName(StringUtils.trim(artist.getName()));
        this.setAliases(VGMdbName.parseNames(artist.getAliases()));
        this.setLink(StringUtils.trim(artist.getLink()));
        this.setVgmdbLink(StringUtils.trim(artist.getVgmdbLink()));
        this.setDescription(StringUtils.trim(artist.getNotes()));
        this.setLink(StringUtils.trim(artist.getLink()));
        this.setMeta(new VGMdbMeta(artist.getMeta()));

        this.setPicture(new VGMdbPicture(
                StringUtils.trim(artist.getPictureSmall()),
                StringUtils.trim(artist.getPictureFull())));

        if (!ListUtils.isEmpty(artist.getDiscography())) {
            artist.getDiscography().stream().forEach((discograph) -> {
                getDiscography().add(new VGMdbDiscography(
                        discograph.getTitles(),
                        StringUtils.trim(discograph.getLink()),
                        StringUtils.trim(discograph.getType()),
                        StringUtils.trim(discograph.getDate()),
                        StringUtils.trim(discograph.getCatalog()),
                        discograph.getRoles()));
            });
        }

        if (!ListUtils.isEmpty(artist.getFeaturedOn())) {
            artist.getFeaturedOn().stream().forEach((featured) -> {
                getFeaturedOn().add(new VGMdbDiscography(
                        featured.getTitles(),
                        StringUtils.trim(featured.getLink()),
                        StringUtils.trim(featured.getType()),
                        StringUtils.trim(featured.getDate()),
                        StringUtils.trim(featured.getCatalog()),
                        featured.getRoles()));
            });
        }

        if (artist.getWebsites() != null) {
            if (!ListUtils.isEmpty(artist.getWebsites().getOfficial())) {
                artist.getWebsites().getOfficial().stream().forEach((officialWebsite) -> {
                    getWebsites().add(new VGMdbWebsite(
                            officialWebsite.getName(),
                            officialWebsite.getLink(),
                            VGMdbWebsiteType.official));
                });
            }
            if (!ListUtils.isEmpty(artist.getWebsites().getPersonal())) {
                artist.getWebsites().getPersonal().stream().forEach((personalWebsite) -> {
                    getWebsites().add(new VGMdbWebsite(
                            personalWebsite.getName(),
                            personalWebsite.getLink(),
                            VGMdbWebsiteType.personal));
                });
            }

        }

        if (artist.getInfo() == null) {
            this.setType(VGMdbArtistType.unknown);
            return;
        }

        this.setVariations(StringUtils.trim(artist.getInfo().getVariations()));

        if (!ListUtils.isEmpty(artist.getInfo().getCreditedWorks())) {
            artist.getInfo().getCreditedWorks().stream().forEach((creditedWorks) -> {
                getCreditedWorks().add(StringUtils.trim(creditedWorks));
            });
        }

        switch (VGMdbArtistType.getArtistTypeByName(artist.getType())) {
            case individual:
                this.setType(VGMdbArtistType.individual);
                this.setPersonInfo(new VGMdbArtistPerson(artist));
                break;
            case unit:
                this.setType(VGMdbArtistType.unit);
                this.setBandInfo(new VGMdbArtistBand(artist));
                break;
            case unknown:
                this.setType(VGMdbArtistType.unknown);
                break;
        }
    }

}
