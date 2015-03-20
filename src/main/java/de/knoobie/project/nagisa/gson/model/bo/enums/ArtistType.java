package de.knoobie.project.nagisa.gson.model.bo.enums;

import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.clannadutils.interfaces.AdvancedEnum;

public enum ArtistType implements AdvancedEnum {

    unknown("Unknown"),
    individual("Individual"),
    unit("Band/Group/Unit");

    private final String humanizedName;

    ArtistType(String humanizedName) {
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
        return ArtistType.values();
    }

    public static ArtistType getArtistTypeByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return ArtistType.unknown;
        }
        for (ArtistType gender : ArtistType.values()) {
            if (gender.name().equalsIgnoreCase(name)) {
                return gender;
            }
        }

        return ArtistType.unknown;
    }

}
