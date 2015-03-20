package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.ListUtils;
import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.nagisa.gson.model.dto.json.album.AlbumDisc;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data
class TransientAlbumDisc {

    private String discLength;
    private String name;
    private List<TransientAlbumTrack> tracks = new ArrayList<>();

    public TransientAlbumDisc(AlbumDisc disc) {
        if (disc == null) {
            setDiscLength(StringUtils.EMPTY);
            setName(StringUtils.EMPTY);
            return;
        }
        setDiscLength(StringUtils.trim(disc.getDiscLength()));
        setName(StringUtils.trim(disc.getName()));
        
          if (!ListUtils.isEmpty(disc.getTracks())) {
            disc.getTracks().stream().forEach((track) -> {
                getTracks().add(new TransientAlbumTrack(track.getNames(), track.getTrackLength()));
            });
        }
    }

}
