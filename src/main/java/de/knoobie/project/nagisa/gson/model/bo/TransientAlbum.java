package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.ListUtils;
import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.nagisa.gson.model.bo.enums.WebsiteType;
import de.knoobie.project.nagisa.gson.model.dto.json.album.Album;
import de.knoobie.project.nagisa.gson.model.dto.json.common.Names;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data
class TransientAlbum {

    public static final String VGMDB_DIR = "album";

    private String catalog;
    private String category;
    private String classification;
    private String releaseDate;
    // contains -> 'album/12345'
    private String link;
    private String vgmdbLink;
    private String mediaFormat;
    private String name;
    private String description;
    private String publishFormat;
    // type only comes from Album -> relatedAlbum
    private String type;
    private Integer votes;

    private Double rating;
    private Boolean reprint;

    private TransientPicture picture;
    private List<TransientPicture> pictures = new ArrayList<>();

    private List<String> platforms = new ArrayList<>();

    private List<TransientName> names = new ArrayList<>();
    private List<TransientAlbumDisc> discs = new ArrayList<>();

    // Contains -> arrangers, composers, performers, 
    private List<TransientPerson> performers = new ArrayList<>();
    private List<TransientPerson> arrangers = new ArrayList<>();
    private List<TransientPerson> composers = new ArrayList<>();
    private List<TransientProduct> products = new ArrayList<>();

    private TransientOrganisation publisher;
    private TransientOrganisation distributor;
    private TransientAlbumRelease release;
    private TransientMeta meta;

    private List<TransientAlbum> relatedAlbums = new ArrayList<>();
    private List<TransientAlbumReprint> reprints = new ArrayList<>();

    private List<TransientStore> stores = new ArrayList<>();
    private List<TransientWebsite> websites = new ArrayList<>();

    public TransientAlbum(Names names, String link, String catalog, String type) {
        if (names == null) {
            this.setLink(StringUtils.EMPTY);
            this.setCatalog(StringUtils.EMPTY);
            this.setType(StringUtils.EMPTY);
            return;
        }
        this.setNames(TransientName.parseNames(names));
        this.setLink(StringUtils.trim(link));
        this.setCatalog(StringUtils.trim(catalog));
        this.setType(StringUtils.trim(type));
    }

    public TransientAlbum(Names names, String link, String catalog, String type,
            String releaseDate, Boolean reprint, List<String> classifications) {
        this(names, link, catalog, type);
        if (names == null) {
            this.setReleaseDate(StringUtils.EMPTY);
            this.setReprint(Boolean.FALSE);
            this.setClassification(StringUtils.EMPTY);
            return;
        }
        this.setReleaseDate(StringUtils.trim(releaseDate));
        this.setReprint(reprint == null ? Boolean.FALSE : reprint);
        this.setClassification(ListUtils.getListAsString(classifications));
    }

    public TransientAlbum(Album album) {
        if (album == null) {
            System.out.println("Generated empty transientalbum. Album was null.");
            return;
        }
        this.setType(StringUtils.EMPTY);
        this.setCatalog(StringUtils.trim(album.getCatalog()));
        this.setCategory(StringUtils.trim(album.getCategory()));
        this.setClassification(StringUtils.trim(album.getClassification()));
        this.setLink(StringUtils.trim(album.getLink()));
        this.setMediaFormat(StringUtils.trim(album.getMediaFormat()));
        this.setReleaseDate(StringUtils.trim(album.getReleaseDate()));
        this.setDescription(StringUtils.trim(album.getNotes()));
        this.setPicture(new TransientPicture(StringUtils.trim(album.getPictureSmall()),
                StringUtils.trim(album.getPictureFull())));
        this.setPublishFormat(StringUtils.trim(album.getPublishFormat()));
        this.setVgmdbLink(StringUtils.trim(album.getVgmdbLink()));

        this.setName(StringUtils.trim(album.getName()));
        this.setNames(TransientName.parseNames(album.getNames()));

        if (!ListUtils.isEmpty(album.getPerformers())) {
            album.getPerformers().stream().forEach((performer) -> {
                getPerformers().add(new TransientPerson(
                        performer.getNames(),
                        StringUtils.trim(performer.getLink())));
            });
        }

        if (!ListUtils.isEmpty(album.getArrangers())) {
            album.getArrangers().stream().forEach((arranger) -> {
                getArrangers().add(new TransientPerson(
                        arranger.getNames(),
                        StringUtils.trim(arranger.getLink())));
            });
        }

        if (!ListUtils.isEmpty(album.getComposers())) {
            album.getComposers().stream().forEach((composer) -> {
                getComposers().add(new TransientPerson(
                        composer.getNames(),
                        StringUtils.trim(composer.getLink())));
            });
        }

        if (album.getPublisher() != null) {
            this.setPublisher(new TransientOrganisation(
                    album.getPublisher().getNames(),
                    StringUtils.trim(album.getPublisher().getLink())));
        }

        if (album.getDistributor() != null) {
            this.setDistributor(new TransientOrganisation(
                    album.getDistributor().getNames(),
                    StringUtils.trim(album.getDistributor().getLink())));
        }

        if (!ListUtils.isEmpty(album.getCovers())) {
            album.getCovers().stream().forEach((cover) -> {
                getPictures().add(new TransientPicture(
                        StringUtils.trim(cover.getName()),
                        StringUtils.trim(cover.getThumb()),
                        StringUtils.trim(cover.getMedium()),
                        StringUtils.trim(cover.getFull())));
            });
        }

        if (!ListUtils.isEmpty(album.getDiscs())) {
            album.getDiscs().stream().forEach((disc) -> {
                getDiscs().add(new TransientAlbumDisc(disc));
            });
        }

        if (!ListUtils.isEmpty(album.getPlatforms())) {
            album.getPlatforms().stream().forEach((platform) -> {
                getPlatforms().add(platform);
            });
        }

        if (!ListUtils.isEmpty(album.getProducts())) {
            album.getPlatforms().stream().forEach((platform) -> {
                getPlatforms().add(platform);
            });
        }

        if (!ListUtils.isEmpty(album.getProducts())) {
            album.getProducts().stream().forEach((product) -> {
                getProducts().add(new TransientProduct(
                        product.getNames(),
                        StringUtils.trim(product.getLink())));
            });
        }

        if (!ListUtils.isEmpty(album.getRelated())) {
            album.getRelated().stream().forEach((relatedAlbum) -> {
                getRelatedAlbums().add(new TransientAlbum(
                        relatedAlbum.getNames(),
                        relatedAlbum.getLink(),
                        relatedAlbum.getCatalog(),
                        relatedAlbum.getType()));
            });
        }

        if (!ListUtils.isEmpty(album.getReprints())) {
            this.setReprint(Boolean.TRUE);
            album.getReprints().stream().forEach((relatedAlbum) -> {
                getReprints().add(new TransientAlbumReprint(
                        relatedAlbum.getNote(),
                        relatedAlbum.getCatalog(),
                        relatedAlbum.getLink()));
            });
        } else {
            this.setReprint(Boolean.FALSE);
        }

        if (!ListUtils.isEmpty(album.getStores())) {
            album.getStores().stream().forEach((store) -> {
                getStores().add(new TransientStore(
                        store.getName(),
                        store.getLink()));
            });
        }

        if (album.getWebsites() != null) {
            album.getWebsites().getReview().stream().forEach((review) -> {
                getWebsites().add(new TransientWebsite(
                        review.getName(),
                        review.getLink(),
                        WebsiteType.review));
            });
        }

        this.setRelease(new TransientAlbumRelease(
                album.getReleaseDate(),
                album.getReleasePrice()));

        this.setVotes(album.getVotes());
        this.setRating(album.getRating());
        this.setMeta(new TransientMeta(album.getMeta()));
    }

}
