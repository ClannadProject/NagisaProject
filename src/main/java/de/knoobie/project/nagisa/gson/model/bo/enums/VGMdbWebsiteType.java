package de.knoobie.project.nagisa.gson.model.bo.enums;

import de.knoobie.project.clannadutils.interfaces.AdvancedEnum;

public enum VGMdbWebsiteType implements AdvancedEnum {

    unknown("Unknown"),
    review("Review"),
    personal("Personal"),
    official("Official"),
    reference("Reference");

    private final String humanizedName;

    VGMdbWebsiteType(String humanizedName) {
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
        return VGMdbWebsiteType.values();
    }

}
