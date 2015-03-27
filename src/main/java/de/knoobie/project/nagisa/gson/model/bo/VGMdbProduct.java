package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.ListUtils;
import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.nagisa.gson.model.bo.enums.VGMdbNameLanguage;
import de.knoobie.project.nagisa.gson.model.bo.enums.VGMdbProductType;
import de.knoobie.project.nagisa.gson.model.bo.enums.VGMdbWebsiteType;
import de.knoobie.project.nagisa.gson.model.dto.json.common.Names;
import de.knoobie.project.nagisa.gson.model.dto.json.product.Product;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data
class VGMdbProduct {

    public static final String VGMDB_DIR = "product";

    private String description;
    private String link;
    private VGMdbMeta meta;
    private String name;

    private String organizations;
    private VGMdbPicture picture;
    private String releaseDate;
    private VGMdbProductType type;
    private String vgmdbLink;

    // need 4 another VGMdbProduct
    private List<VGMdbName> names = new ArrayList<>();

    /**
     * Alle Titel die zu diesem Francise gehören -> z.B. Clannad 5 Stk ( Games &
     * Series )
     */
    private List<VGMdbProductMerchandise> titles = new ArrayList<>();

    /**
     * Francise des Products -> z.B. 'Shigatsu wa Kimi no Uso' / 'Clannad'
     */
    private List<VGMdbProductMerchandise> franchises = new ArrayList<>();
    /**
     * Release einer Serie / eines Games -> z.B. Shigatsu wa Kimi no Uso Anime
     * Serie / Clannad Game
     */
    private List<VGMdbProductMerchandise> releases = new ArrayList<>();

    /**
     * Alben related to this Product
     */
    private List<VGMdbAlbum> albums = new ArrayList<>();

    private List<VGMdbWebsite> websites = new ArrayList<>();

    public VGMdbProduct(Names names, String link) {
        this(names, link, StringUtils.EMPTY);
    }

    public VGMdbProduct(Names names, String link, String type) {
        this.setNames(VGMdbName.parseNames(names));
        this.setLink(StringUtils.trim(link));
        this.setType(VGMdbProductType.getProductTypeByName(type));
    }

    public VGMdbProduct(Product product) {
        if (product == null) {
            return;
        }

        this.setName(StringUtils.trim(product.getName()));
        this.getNames().add(new VGMdbName(StringUtils.trim(product.getRealName()), VGMdbNameLanguage.original));
        this.setLink(StringUtils.trim(product.getLink()));
        this.setReleaseDate(StringUtils.trim(product.getReleaseDate()));
        this.setDescription(StringUtils.trim(product.getDescription()));
        this.setOrganizations(ListUtils.getListAsString(product.getOrganizations()));
        this.setType(VGMdbProductType.getProductTypeByName(product.getType()));
        this.setVgmdbLink(StringUtils.trim(product.getVgmdbLink()));
        this.setMeta(new VGMdbMeta(product.getMeta()));
        this.setPicture(new VGMdbPicture(StringUtils.trim(product.getPictureSmall()),
                StringUtils.trim(product.getPictureFull())));

        if (!ListUtils.isEmpty(product.getAlbums())) {
            product.getAlbums().stream().forEach((album) -> {
                getAlbums().add(new VGMdbAlbum(
                        album.getNames(),
                        album.getLink(),
                        album.getCatalog(),
                        album.getType(),
                        album.getDate(),
                        album.getReprint(),
                        album.getClassifications()));
            });
        }

        if (!ListUtils.isEmpty(product.getTitles())) {
            product.getTitles().stream().forEach((merchandise) -> {
                getTitles().add(new VGMdbProductMerchandise(merchandise));
            });
        }
        if (!ListUtils.isEmpty(product.getFranchises())) {
            product.getFranchises().stream().forEach((franchise) -> {
                getFranchises().add(new VGMdbProductMerchandise(franchise));
            });
        }
        if (!ListUtils.isEmpty(product.getReleases())) {
            product.getReleases().stream().forEach((release) -> {
                getReleases().add(new VGMdbProductMerchandise(release));
            });
        }

        if (product.getWebsites() != null) {
            if (!ListUtils.isEmpty(product.getWebsites().getOfficial())) {
                product.getWebsites().getOfficial().stream().forEach((officialWebsite) -> {
                    getWebsites().add(new VGMdbWebsite(
                            officialWebsite.getName(),
                            officialWebsite.getLink(),
                            VGMdbWebsiteType.official));
                });
            }
            if (!ListUtils.isEmpty(product.getWebsites().getPersonal())) {
                product.getWebsites().getPersonal().stream().forEach((personalWebsite) -> {
                    getWebsites().add(new VGMdbWebsite(
                            personalWebsite.getName(),
                            personalWebsite.getLink(),
                            VGMdbWebsiteType.personal));
                });
            }
            if (!ListUtils.isEmpty(product.getWebsites().getReference())) {
                product.getWebsites().getReference().stream().forEach((referenceWebsite) -> {
                    getWebsites().add(new VGMdbWebsite(
                            referenceWebsite.getName(),
                            referenceWebsite.getLink(),
                            VGMdbWebsiteType.reference));
                });
            }
        }
    }
    
    
}
