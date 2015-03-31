package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.ListUtils;
import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.nagisa.gson.model.bo.enums.VGMdbNameLanguage;
import de.knoobie.project.nagisa.gson.model.dto.json.artist.ArtistAlias;
import de.knoobie.project.nagisa.gson.model.dto.json.common.Names;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data
class VGMdbName {

    private String name;
    private String date;
    private VGMdbNameLanguage language;

    public VGMdbName(String name, VGMdbNameLanguage language) {
        this.setName(name);
        this.setDate(StringUtils.EMPTY);
        this.setLanguage(language);
    }

    public VGMdbName(String name, String date, VGMdbNameLanguage language) {
        this.setName(name);
        this.setDate(date);
        this.setLanguage(language);
    }

    public static List<String> getOnlyNames(List<VGMdbName> names) {
        List<String> result = new ArrayList<>();

        if (ListUtils.isEmpty(names)) {
            return result;
        }

        names.stream().forEach((name) -> {
            result.add(name.getName());
        });

        return result;
    }

    public static List<VGMdbName> parseNames(List<ArtistAlias> aliases) {
        List<VGMdbName> list = new ArrayList<>();

        if (ListUtils.isEmpty(aliases)) {
            return list;
        }

        aliases.stream().map((alias) -> parseNames(alias.getNames())).forEach((tempList) -> {
            list.addAll(tempList);
        });

        return list;
    }

    public static List<VGMdbName> parseNames(Names names) {
        return parseNames(names, StringUtils.EMPTY);
    }

    public static List<VGMdbName> parseNames(Names names, String date) {
        List<VGMdbName> list = new ArrayList<>();

        if (names == null) {
            return list;
        }

        if (!StringUtils.isEmpty(names.getEn())) {
            list.add(new VGMdbName(StringUtils.trim(names.getEn()), date, VGMdbNameLanguage.eng));
        }

        if (!StringUtils.isEmpty(names.getEnglish())) {
            list.add(new VGMdbName(StringUtils.trim(names.getEnglish()), date, VGMdbNameLanguage.eng));
        }

        if (!StringUtils.isEmpty(names.getEng_furigana())) {
            list.add(new VGMdbName(StringUtils.trim(names.getEng_furigana()), date, VGMdbNameLanguage.eng_furigana));
        }

        if (!StringUtils.isEmpty(names.getJa())) {
            list.add(new VGMdbName(StringUtils.trim(names.getJa()), date, VGMdbNameLanguage.jap));
        }

        if (!StringUtils.isEmpty(names.getJapanese())) {
            list.add(new VGMdbName(StringUtils.trim(names.getJapanese()), date, VGMdbNameLanguage.jap));
        }

        if (!StringUtils.isEmpty(names.getJa_furigana())) {
            list.add(new VGMdbName(StringUtils.trim(names.getJa_furigana()), date, VGMdbNameLanguage.ja_furigana));
        }

        if (!StringUtils.isEmpty(names.getJa_latn())) {
            list.add(new VGMdbName(StringUtils.trim(names.getJa_latn()), date, VGMdbNameLanguage.ja_latn));
        }

        if (!StringUtils.isEmpty(names.getRomaji())) {
            list.add(new VGMdbName(StringUtils.trim(names.getRomaji()), date, VGMdbNameLanguage.ja_romaji));
        }

        if (!StringUtils.isEmpty(names.getOriginal())) {
            list.add(new VGMdbName(StringUtils.trim(names.getOriginal()), date, VGMdbNameLanguage.original));
        }

        return list;
    }

}
