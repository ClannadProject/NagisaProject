package de.knoobie.project.nagisa.gson.model.bo.enums;

import de.knoobie.project.clannadutils.interfaces.AdvancedEnum;

public enum NameLanguage implements AdvancedEnum {

    alias("Alias"),
    eng("English"),
    eng_furigana("English from Furigana"),
    jap("Japanese"),
    ja_latn("Japanese (Latein)"),
    ja_romaji("Japanese (Romaji)"),
    ja_furigana("Japanese (Furigana)"),
    original("Original");

    private final String humanizedName;

    NameLanguage(String humanizedName) {
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
        return NameLanguage.values();
    }

}
