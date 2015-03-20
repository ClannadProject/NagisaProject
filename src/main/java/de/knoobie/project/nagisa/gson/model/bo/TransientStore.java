package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.StringUtils;
import lombok.Data;

public @Data class TransientStore {
    
    private String name;  
    private String link;    
    
    public TransientStore(String name, String link){
        this.setName(StringUtils.trim(name));
        this.setLink(StringUtils.trim(link));
    }    
}
