package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.nagisa.gson.model.dto.json.common.Names;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data class VGMdbPerson {
    
    private List<VGMdbName> names = new ArrayList<>();
    private String link;    
    
    public VGMdbPerson(Names names, String link){
        this.setNames(VGMdbName.parseNames(names));
        this.setLink(link);
    }
    
}
