package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.ListUtils;
import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.clannadutils.interfaces.AdvancedEnum;
import de.knoobie.project.nagisa.gson.model.bo.enums.NameLanguage;
import de.knoobie.project.nagisa.gson.model.dto.json.artist.ArtistAlias;
import de.knoobie.project.nagisa.gson.model.dto.json.common.Names;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data
class TransientName {

    private String name;
    private NameLanguage language;

    public TransientName(String name, NameLanguage language) {
        this.setName(name);
        this.setLanguage(language);
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
        List<TransientName> list = new ArrayList<>();

        if (names == null) {
            return list;
        }

        if (!StringUtils.isEmpty(names.getEn())) {
            list.add(new TransientName(StringUtils.trim(names.getEn()), NameLanguage.eng));
        }

        if (!StringUtils.isEmpty(names.getEnglish())) {
            list.add(new TransientName(StringUtils.trim(names.getEnglish()), NameLanguage.eng));
        }

        if (!StringUtils.isEmpty(names.getEng_furigana())) {
            list.add(new TransientName(StringUtils.trim(names.getEng_furigana()), NameLanguage.eng_furigana));
        }

        if (!StringUtils.isEmpty(names.getJa())) {
            list.add(new TransientName(StringUtils.trim(names.getJa()), NameLanguage.jap));
        }

        if (!StringUtils.isEmpty(names.getJa_furigana())) {
            list.add(new TransientName(StringUtils.trim(names.getJa_furigana()), NameLanguage.ja_furigana));
        }

        if (!StringUtils.isEmpty(names.getJa_latn())) {
            list.add(new TransientName(StringUtils.trim(names.getJa_latn()), NameLanguage.ja_latn));
        }

        if (!StringUtils.isEmpty(names.getRomaji())) {
            list.add(new TransientName(StringUtils.trim(names.getRomaji()), NameLanguage.ja_romaji));
        }

        if (!StringUtils.isEmpty(names.getOriginal())) {
            list.add(new TransientName(StringUtils.trim(names.getOriginal()), NameLanguage.original));
        }

        return list;
    }

}
