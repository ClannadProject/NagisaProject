package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.nagisa.gson.model.dto.json.common.Names;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data class TransientProduct {
    
    private List<TransientName> names = new ArrayList<>();
    private String link;    
    
    public TransientProduct(Names names, String link){
        this.setNames(TransientName.parseNames(names));
        this.setLink(StringUtils.trim(link));
    }
    
}
