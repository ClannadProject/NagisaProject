package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.nagisa.gson.model.bo.enums.WebsiteType;
import lombok.Data;

public @Data
class TransientWebsite {
    
    private String name;    
    private String link;    
    private WebsiteType type;
    
    public TransientWebsite(String name, String link, WebsiteType type) {
        this.setName(StringUtils.trim(name));
        this.setLink(StringUtils.trim(link));
        this.setType(type == null ? WebsiteType.unknown : type);
    }    
}
