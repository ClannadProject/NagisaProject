package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.nagisa.gson.model.dto.json.product.ProductTitle;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data
class VGMdbProductMerchandise {

    private String date;
    private String link;
    private String platform;
    private String region;
    private List<VGMdbName> names = new ArrayList<>();

    public VGMdbProductMerchandise(ProductTitle release) {
        if (release == null) {
            this.setDate(StringUtils.EMPTY);
            this.setLink(StringUtils.EMPTY);
            this.setPlatform(StringUtils.EMPTY);
            this.setRegion(StringUtils.EMPTY);
            return;
        }

        this.setDate(StringUtils.trim(release.getDate()));
        this.setLink(StringUtils.trim(release.getLink()));
        this.setRegion(StringUtils.trim(release.getRegion()));
        this.setPlatform(StringUtils.trim(release.getPlatform()));
        this.setNames(VGMdbName.parseNames(release.getNames()));
    }

}
