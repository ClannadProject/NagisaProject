package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.StringUtils;
import lombok.Data;

public @Data class VGMdbAlbumReprint {
    
    private String name;  
    private String catalog;
    private String link;
    
    public VGMdbAlbumReprint(String name, String catalog, String link){
        this.setName(StringUtils.trim(name));
        this.setCatalog(StringUtils.trim(catalog));
        this.setLink(StringUtils.trim(link));
    }
    
}
