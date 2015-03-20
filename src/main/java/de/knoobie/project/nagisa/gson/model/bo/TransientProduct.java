package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.ListUtils;
import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.nagisa.gson.model.bo.enums.NameLanguage;
import de.knoobie.project.nagisa.gson.model.bo.enums.ProductType;
import de.knoobie.project.nagisa.gson.model.dto.json.common.Names;
import de.knoobie.project.nagisa.gson.model.dto.json.product.Product;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data
class TransientProduct {

    public static final String VGMDB_DIR = "product";

    private String description;
    private String link;
    private TransientMeta meta;
    private String name;

    private String organizations;
    private TransientPicture picture;
    private String releaseDate;
    private ProductType type;
    private String vgmdbLink;

    // need 4 another TransientProduct
    private List<TransientName> names = new ArrayList<>();

    /**
     * Alle Titel die zu diesem Francise gehören -> z.B. Clannad 5 Stk ( Games &
     * Series )
     */
    private List<TransientProductMerchandise> titles = new ArrayList<>();

    /**
     * Francise des Products -> z.B. 'Shigatsu wa Kimi no Uso' / 'Clannad'
     */
    private List<TransientProductMerchandise> francises = new ArrayList<>();
    /**
     * Release einer Serie / eines Games -> z.B. Shigatsu wa Kimi no Uso Anime
     * Serie / Clannad Game
     */
    private List<TransientProductMerchandise> releases = new ArrayList<>();

    /**
     * Alben related to this Product
     */
    private List<TransientAlbum> albums = new ArrayList<>();

    public TransientProduct(Names names, String link) {
        this(names, link, StringUtils.EMPTY);
    }

    public TransientProduct(Names names, String link, String type) {
        this.setNames(TransientName.parseNames(names));
        this.setLink(StringUtils.trim(link));
        this.setType(ProductType.getProductTypeByName(type));
    }

    public TransientProduct(Product product) {
        if (product == null) {
            return;
        }

        this.setName(StringUtils.trim(product.getName()));
        this.getNames().add(new TransientName(StringUtils.trim(product.getRealName()), NameLanguage.original));
        this.setLink(StringUtils.trim(product.getLink()));
        this.setReleaseDate(StringUtils.trim(product.getReleaseDate()));
        this.setDescription(StringUtils.trim(product.getDescription()));
        this.setOrganizations(ListUtils.getListAsString(product.getOrganizations()));
        this.setType(ProductType.getProductTypeByName(product.getType()));
        this.setVgmdbLink(StringUtils.trim(product.getVgmdbLink()));
        this.setMeta(new TransientMeta(product.getMeta()));
        this.setPicture(new TransientPicture(StringUtils.trim(product.getPictureSmall()),
                StringUtils.trim(product.getPictureFull())));

        if (!ListUtils.isEmpty(product.getAlbums())) {
            product.getAlbums().stream().forEach((album) -> {
                getAlbums().add(new TransientAlbum(
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
                getTitles().add(new TransientProductMerchandise(merchandise));
            });
        }
        if (!ListUtils.isEmpty(product.getFrancises())) {
            product.getFrancises().stream().forEach((francise) -> {
                getFrancises().add(new TransientProductMerchandise(francise));
            });
        }
        if (!ListUtils.isEmpty(product.getReleases())) {
            product.getReleases().stream().forEach((release) -> {
                getReleases().add(new TransientProductMerchandise(release));
            });
        }
    }
}
