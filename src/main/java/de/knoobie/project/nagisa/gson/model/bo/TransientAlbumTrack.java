package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.nagisa.gson.model.dto.json.common.Names;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data class TransientAlbumTrack {
    
    private List<TransientName> names = new ArrayList<>();
    private String trackLength;    
    
    public TransientAlbumTrack(Names names, String trackLength){
        this.setNames(TransientName.parseNames(names));
        this.setTrackLength(trackLength);
    }
    
}
