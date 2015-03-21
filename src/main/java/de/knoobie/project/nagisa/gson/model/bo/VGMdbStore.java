package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.StringUtils;
import lombok.Data;

public @Data class VGMdbStore {
    
    private String name;  
    private String link;    
    
    public VGMdbStore(String name, String link){
        this.setName(StringUtils.trim(name));
        this.setLink(StringUtils.trim(link));
    }    
}
