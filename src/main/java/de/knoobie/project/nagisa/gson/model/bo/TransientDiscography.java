package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.ListUtils;
import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.nagisa.gson.model.dto.json.common.Names;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data
class TransientDiscography {

    private List<TransientName> names = new ArrayList<>();
    private List<String> roles = new ArrayList<>();
    private String catalog;
    private String date;
    private String link;
    private String type;

    public TransientDiscography(Names names, String link, String type, String date, String catalog, List<String> roles) {
        this.setNames(TransientName.parseNames(names));
        this.setLink(StringUtils.trim(link));
        this.setType(StringUtils.trim(type));
        this.setDate(StringUtils.trim(date));
        this.setCatalog(StringUtils.trim(catalog));
        this.setRoles(ListUtils.isEmpty(roles) ? new ArrayList<>() : roles);
    }

}
