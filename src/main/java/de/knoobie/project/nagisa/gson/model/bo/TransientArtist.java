package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.ListUtils;
import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.nagisa.gson.model.bo.enums.ArtistType;
import de.knoobie.project.nagisa.gson.model.bo.enums.WebsiteType;
import de.knoobie.project.nagisa.gson.model.dto.json.artist.Artist;
import de.knoobie.project.nagisa.gson.model.dto.json.common.Names;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data
class TransientArtist {

    private String name;
    private String link;
    private String description;
    private String vgmdbLink;

    private String Variations;
    // aliases
    private List<TransientName> aliases = new ArrayList<>();

    private List<String> CreditedWorks = new ArrayList<>();

    private TransientPicture picture;
    private TransientMeta meta;

    private List<TransientDiscography> discography = new ArrayList<>();
    private List<TransientDiscography> featuredOn = new ArrayList<>();
    private List<TransientWebsite> websites = new ArrayList<>();

    private ArtistType type;
    private TransientArtistPerson personInfo;
    private TransientArtistBand bandInfo;

    // @todo add Album Votes && weighted album rating
    public TransientArtist(Names names, String link) {
        this.setAliases(TransientName.parseNames(names));
        this.setLink(link);
    }

    public TransientArtist(Artist artist) {
        if (artist == null) {
            System.out.println("Generated empty transientartist. Artist was null.");
            return;
        }
        this.setName(StringUtils.trim(artist.getName()));
        this.setAliases(TransientName.parseNames(artist.getAliases()));
        this.setLink(StringUtils.trim(artist.getLink()));
        this.setVgmdbLink(StringUtils.trim(artist.getVgmdbLink()));
        this.setDescription(StringUtils.trim(artist.getNotes()));
        this.setLink(StringUtils.trim(artist.getLink()));
        this.setMeta(new TransientMeta(artist.getMeta()));

        this.setPicture(new TransientPicture(
                StringUtils.trim(artist.getPictureSmall()),
                StringUtils.trim(artist.getPictureFull())));

        if (!ListUtils.isEmpty(artist.getDiscography())) {
            artist.getDiscography().stream().forEach((discograph) -> {
                getDiscography().add(new TransientDiscography(
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
                getFeaturedOn().add(new TransientDiscography(
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
                    getWebsites().add(new TransientWebsite(
                            officialWebsite.getName(),
                            officialWebsite.getLink(),
                            WebsiteType.official));
                });
            }
            if (!ListUtils.isEmpty(artist.getWebsites().getPersonal())) {
                artist.getWebsites().getPersonal().stream().forEach((personalWebsite) -> {
                    getWebsites().add(new TransientWebsite(
                            personalWebsite.getName(),
                            personalWebsite.getLink(),
                            WebsiteType.personal));
                });
            }

        }

        if (artist.getInfo() == null) {
            this.setType(ArtistType.unknown);
            return;
        }

        this.setVariations(StringUtils.trim(artist.getInfo().getVariations()));

        if (!ListUtils.isEmpty(artist.getInfo().getCreditedWorks())) {
            artist.getInfo().getCreditedWorks().stream().forEach((creditedWorks) -> {
                getCreditedWorks().add(StringUtils.trim(creditedWorks));
            });
        }

        switch (ArtistType.getArtistTypeByName(artist.getType())) {
            case individual:
                this.setType(ArtistType.individual);
                this.setPersonInfo(new TransientArtistPerson(artist));
                break;
            case unit:
                this.setType(ArtistType.unit);
                this.setBandInfo(new TransientArtistBand(artist));
                break;
            case unknown:
                this.setType(ArtistType.unknown);
                break;
        }
    }

}
