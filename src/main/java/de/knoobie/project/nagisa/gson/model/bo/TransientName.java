package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.ListUtils;
import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.nagisa.gson.model.bo.enums.NameLanguage;
import de.knoobie.project.nagisa.gson.model.dto.json.artist.ArtistAlias;
import de.knoobie.project.nagisa.gson.model.dto.json.common.Names;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data
class TransientName {

    private String name;
    private String date;
    private NameLanguage language;

    public TransientName(String name, NameLanguage language) {
        this.setName(name);
        this.setDate(StringUtils.EMPTY);
        this.setLanguage(language);
    }

    public TransientName(String name, String date, NameLanguage language) {
        this.setName(name);
        this.setDate(date);
        this.setLanguage(language);
    }

    public static List<String> getOnlyNames(List<TransientName> names) {
        List<String> result = new ArrayList<>();

        if (ListUtils.isEmpty(names)) {
            return result;
        }

        names.stream().forEach((name) -> {
            result.add(name.getName());
        });

        return result;
    }

    public static List<TransientName> parseNames(List<ArtistAlias> aliases) {
        List<TransientName> list = new ArrayList<>();

        if (ListUtils.isEmpty(aliases)) {
            return list;
        }

        aliases.stream().map((alias) -> parseNames(alias.getNames())).forEach((tempList) -> {
            list.addAll(tempList);
        });

        return list;
    }

    public static List<TransientName> parseNames(Names names) {
        return parseNames(names, StringUtils.EMPTY);
    }

    public static List<TransientName> parseNames(Names names, String date) {
        List<TransientName> list = new ArrayList<>();

        if (names == null) {
            return list;
        }

        if (!StringUtils.isEmpty(names.getEn())) {
            list.add(new TransientName(StringUtils.trim(names.getEn()), date, NameLanguage.eng));
        }

        if (!StringUtils.isEmpty(names.getEnglish())) {
            list.add(new TransientName(StringUtils.trim(names.getEnglish()), date, NameLanguage.eng));
        }

        if (!StringUtils.isEmpty(names.getEng_furigana())) {
            list.add(new TransientName(StringUtils.trim(names.getEng_furigana()), date, NameLanguage.eng_furigana));
        }

        if (!StringUtils.isEmpty(names.getJa())) {
            list.add(new TransientName(StringUtils.trim(names.getJa()), date, NameLanguage.jap));
        }

        if (!StringUtils.isEmpty(names.getJa_furigana())) {
            list.add(new TransientName(StringUtils.trim(names.getJa_furigana()), date, NameLanguage.ja_furigana));
        }

        if (!StringUtils.isEmpty(names.getJa_latn())) {
            list.add(new TransientName(StringUtils.trim(names.getJa_latn()), date, NameLanguage.ja_latn));
        }

        if (!StringUtils.isEmpty(names.getRomaji())) {
            list.add(new TransientName(StringUtils.trim(names.getRomaji()), date, NameLanguage.ja_romaji));
        }

        if (!StringUtils.isEmpty(names.getOriginal())) {
            list.add(new TransientName(StringUtils.trim(names.getOriginal()), date, NameLanguage.original));
        }

        return list;
    }

}
