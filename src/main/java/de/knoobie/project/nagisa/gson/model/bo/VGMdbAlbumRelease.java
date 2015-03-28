package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.nagisa.gson.model.dto.json.album.AlbumReleasePrice;
import lombok.Data;

public @Data
class VGMdbAlbumRelease {

    private String releaseDate;
    private String currency;
    private String price;

    public VGMdbAlbumRelease() {
        this.setReleaseDate(StringUtils.EMPTY);
        this.setPrice("");
        this.setCurrency(StringUtils.EMPTY);
    }

    public VGMdbAlbumRelease(String releaseDate, AlbumReleasePrice releasePrice) {
        this.setReleaseDate(StringUtils.trim(releaseDate));
        this.setPrice(releasePrice == null || releasePrice.getPrice() == null ? "0" : releasePrice.getPrice());
        this.setCurrency(releasePrice == null || StringUtils.isEmpty(releasePrice.getCurrency())
                ? StringUtils.EMPTY : StringUtils.trim(releasePrice.getCurrency()));
    }

}
