package de.knoobie.project.nagisa.gson.model.dto.json.common;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data class Websites {

    private List<Website> Official = new ArrayList<>();
    private List<Website> Personal = new ArrayList<>();
    private List<Website> Reference = new ArrayList<>();
    
    
    
}
