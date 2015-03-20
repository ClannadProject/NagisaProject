package de.knoobie.project.nagisa.gson.model.dto.json.search;

import de.knoobie.project.nagisa.gson.model.dto.json.common.Names;
import lombok.Data;

public @Data class ResultProduct {
    
    private String link; 
    private String type;    
    private Names names;
}
