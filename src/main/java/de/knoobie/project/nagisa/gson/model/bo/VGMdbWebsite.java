package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.nagisa.gson.model.bo.enums.VGMdbWebsiteType;
import lombok.Data;

public @Data
class VGMdbWebsite {
    
    private String name;    
    private String link;    
    private VGMdbWebsiteType type;
    
    public VGMdbWebsite(String name, String link, VGMdbWebsiteType type) {
        this.setName(StringUtils.trim(name));
        this.setLink(StringUtils.trim(link));
        this.setType(type == null ? VGMdbWebsiteType.unknown : type);
    }    
}
