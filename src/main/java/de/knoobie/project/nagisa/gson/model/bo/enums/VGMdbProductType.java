package de.knoobie.project.nagisa.gson.model.bo.enums;

import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.clannadutils.interfaces.AdvancedEnum;

public enum VGMdbProductType implements AdvancedEnum {

    unknown("Unknown"),
    Game("Game"),
    Video("Video"),
    Franchise("Franchise"),
    Radio_Drama("Radio & Drama"),
    Print_Publication("Print Publication"),
    Goods("Goods");

    private final String humanizedName;

    VGMdbProductType(String humanizedName) {
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
        return VGMdbProductType.values();
    }

    public static VGMdbProductType getProductTypeByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return VGMdbProductType.unknown;
        }
        for (VGMdbProductType gender : VGMdbProductType.values()) {
            if (gender.getHumanizedName().equalsIgnoreCase(name)) {
                return gender;
            }
        }

        return VGMdbProductType.unknown;
    }

}
