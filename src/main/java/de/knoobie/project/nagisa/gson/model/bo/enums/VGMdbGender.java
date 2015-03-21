package de.knoobie.project.nagisa.gson.model.bo.enums;

import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.clannadutils.interfaces.AdvancedEnum;

public enum VGMdbGender implements AdvancedEnum {

    unknown("Unknown"),
    male("Male"),
    female("Female");

    private final String humanizedName;

    VGMdbGender(String humanizedName) {
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
        return VGMdbGender.values();
    }

    public static VGMdbGender getGenderByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return VGMdbGender.unknown;
        }
        for (VGMdbGender gender : VGMdbGender.values()) {
            if (gender.name().equalsIgnoreCase(name)) {
                return gender;
            }
        }

        return VGMdbGender.unknown;
    }

}
