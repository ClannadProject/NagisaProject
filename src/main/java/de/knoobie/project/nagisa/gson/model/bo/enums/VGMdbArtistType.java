package de.knoobie.project.nagisa.gson.model.bo.enums;

import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.clannadutils.interfaces.AdvancedEnum;

public enum VGMdbArtistType implements AdvancedEnum {

    unknown("Unknown"),
    individual("Individual"),
    unit("Band/Group/Unit");

    private final String humanizedName;

    VGMdbArtistType(String humanizedName) {
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
        return VGMdbArtistType.values();
    }

    public static VGMdbArtistType getArtistTypeByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return VGMdbArtistType.unknown;
        }
        for (VGMdbArtistType gender : VGMdbArtistType.values()) {
            if (gender.name().equalsIgnoreCase(name)) {
                return gender;
            }
        }

        return VGMdbArtistType.unknown;
    }

}
