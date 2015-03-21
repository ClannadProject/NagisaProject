package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.nagisa.gson.model.dto.json.common.Names;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data class VGMdbAlbumTrack {
    
    private List<VGMdbName> names = new ArrayList<>();
    private String trackLength;    
    
    public VGMdbAlbumTrack(Names names, String trackLength){
        this.setNames(VGMdbName.parseNames(names));
        this.setTrackLength(trackLength);
    }
    
}
