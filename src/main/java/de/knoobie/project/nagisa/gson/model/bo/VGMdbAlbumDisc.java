package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.ListUtils;
import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.nagisa.gson.model.dto.json.album.AlbumDisc;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data
class VGMdbAlbumDisc {

    private String discLength;
    private String name;
    private List<VGMdbAlbumTrack> tracks = new ArrayList<>();

    public VGMdbAlbumDisc(AlbumDisc disc) {
        if (disc == null) {
            setDiscLength(StringUtils.EMPTY);
            setName(StringUtils.EMPTY);
            return;
        }
        setDiscLength(StringUtils.trim(disc.getDiscLength()));
        setName(StringUtils.trim(disc.getName()));
        
          if (!ListUtils.isEmpty(disc.getTracks())) {
            disc.getTracks().stream().forEach((track) -> {
                getTracks().add(new VGMdbAlbumTrack(track.getNames(), track.getTrackLength()));
            });
        }
    }

}
