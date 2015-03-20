package de.knoobie.project.nagisa.gson.model.bo.enums;

import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.clannadutils.interfaces.AdvancedEnum;

public enum ProductType implements AdvancedEnum {

    unknown("Unknown"),
    Game("Game"),
    Video("Video"),
    Francise("Francise"),
    Radio_Drama("Radio & Drama"),
    Print_Publication("Print Publication"),
    Goods("Goods");

    private final String humanizedName;

    ProductType(String humanizedName) {
        this.humanizedName = humanizedName;
    }

    @Override
    public String getHumanizedName() {
        return this.humanizedName;
    }

    @Override
    public String getEnumconstant() {
        return name();
    }

    @Override
    public AdvancedEnum[] getValues() {
        return ProductType.values();
    }

    public static ProductType getArtistTypeByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return ProductType.unknown;
        }
        for (ProductType gender : ProductType.values()) {
            if (gender.getHumanizedName().equalsIgnoreCase(name)) {
                return gender;
            }
        }

        return ProductType.unknown;
    }

}
