package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.StringUtils;
import lombok.Data;

public @Data class VGMdbPicture {

    private String small;
    private String full;
    private String thumbnail;
    private String name;
    
    public VGMdbPicture(String small, String full){
        this.setSmall(small);
        this.setFull(full);  
        this.setThumbnail(StringUtils.EMPTY);
        this.setName(StringUtils.EMPTY);      
    }
    
    public VGMdbPicture(String name, String thumbnail, String small, String full){
        this.setName(name); 
        this.setThumbnail(thumbnail);
        this.setSmall(small);
        this.setFull(full);    
    }
    
}
