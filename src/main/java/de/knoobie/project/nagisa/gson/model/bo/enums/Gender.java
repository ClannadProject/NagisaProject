package de.knoobie.project.nagisa.gson.model.bo.enums;

import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.clannadutils.interfaces.AdvancedEnum;

public enum Gender implements AdvancedEnum {

    unknown("Unknown"),
    male("Male"),
    female("Female");

    private final String humanizedName;

    Gender(String humanizedName) {
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
        return Gender.values();
    }

    public static Gender getGenderByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return Gender.unknown;
        }
        for (Gender gender : Gender.values()) {
            if (gender.name().equalsIgnoreCase(name)) {
                return gender;
            }
        }

        return Gender.unknown;
    }

}
