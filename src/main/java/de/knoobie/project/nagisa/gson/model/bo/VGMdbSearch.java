package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.ListUtils;
import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.nagisa.gson.model.dto.json.search.SearchResult;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data
class VGMdbSearch {

    public static final String VGMDB_DIR = "search";

    private String query;
    private String link;
    private String vgmdbLink;

    private VGMdbMeta meta;

    private List<String> sections = new ArrayList<>();
    private List<VGMdbAlbum> albums = new ArrayList<>();
    private List<VGMdbArtist> artists = new ArrayList<>();
    private List<VGMdbOrganisation> orgs = new ArrayList<>();
    private List<VGMdbProduct> products = new ArrayList<>();

    public VGMdbSearch(SearchResult searchResult) {
        if (searchResult == null) {
            return;
        }
        this.setLink(StringUtils.trim(searchResult.getLink()));
        this.setQuery(StringUtils.trim(searchResult.getQuery()));
        this.setVgmdbLink(StringUtils.trim(searchResult.getVgmdbLink()));
        this.setMeta(new VGMdbMeta(searchResult.getMeta()));

        if (!ListUtils.isEmpty(searchResult.getSections())) {
            searchResult.getSections().stream().forEach((section) -> {
                getSections().add(StringUtils.trim(section));
            });
        }

        if (searchResult.getResults() == null) {
            return;
        }

        if (!ListUtils.isEmpty(searchResult.getResults().getAlbums())) {
            searchResult.getResults().getAlbums().stream().forEach((album) -> {
                getAlbums().add(new VGMdbAlbum(
                        album.getNames(),
                        album.getLink(),
                        album.getCatalog(),
                        StringUtils.EMPTY,
                        album.getReleaseDate(),
                        Boolean.FALSE,
                        null));
            });
        }

        if (!ListUtils.isEmpty(searchResult.getResults().getArtists())) {
            searchResult.getResults().getArtists().stream().forEach((artist) -> {
                getArtists().add(new VGMdbArtist(
                        artist.getNames(),
                        artist.getAliases(),
                        artist.getLink()));
            });
        }

        if (!ListUtils.isEmpty(searchResult.getResults().getOrgs())) {
            searchResult.getResults().getOrgs().stream().forEach((org) -> {
                getOrgs().add(new VGMdbOrganisation(
                        org.getNames(),
                        org.getLink()));
            });
        }

        if (!ListUtils.isEmpty(searchResult.getResults().getProducts())) {
            searchResult.getResults().getProducts().stream().forEach((product) -> {
                getProducts().add(new VGMdbProduct(
                        product.getNames(),
                        product.getLink(),
                        product.getType()));
            });
        }

    }
}
