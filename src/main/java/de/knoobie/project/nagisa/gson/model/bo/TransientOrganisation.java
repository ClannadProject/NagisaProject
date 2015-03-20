package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.nagisa.gson.model.dto.json.common.Names;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data class TransientOrganisation {
    
    private List<TransientName> names = new ArrayList<>();
    private String link;    
    
    public TransientOrganisation(Names names, String link){
        this.setNames(TransientName.parseNames(names));
        this.setLink(link);
    }
    
}
