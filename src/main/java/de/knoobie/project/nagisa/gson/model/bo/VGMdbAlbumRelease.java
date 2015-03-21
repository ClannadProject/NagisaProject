package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.nagisa.gson.model.dto.json.album.AlbumReleasePrice;
import lombok.Data;

public @Data
class VGMdbAlbumRelease {

    private String releaseDate;
    private String currency;
    private Double price;

    public VGMdbAlbumRelease() {
        this.setReleaseDate(StringUtils.EMPTY);
        this.setPrice(0.0);
        this.setCurrency(StringUtils.EMPTY);
    }

    public VGMdbAlbumRelease(String releaseDate, AlbumReleasePrice releasePrice) {
        this.setReleaseDate(StringUtils.trim(releaseDate));
        this.setPrice(releasePrice == null || releasePrice.getPrice() == null ? 0.0 : releasePrice.getPrice());
        this.setCurrency(releasePrice == null || StringUtils.isEmpty(releasePrice.getCurrency())
                ? StringUtils.EMPTY : StringUtils.trim(releasePrice.getCurrency()));
    }

}
