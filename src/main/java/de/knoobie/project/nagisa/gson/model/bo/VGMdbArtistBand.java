package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.ListUtils;
import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.nagisa.gson.model.dto.json.artist.Artist;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data
class VGMdbArtistBand {

    private String Formed;
    private List<VGMdbPerson> member = new ArrayList<>();
    private List<VGMdbPerson> formerMember = new ArrayList<>();

    public VGMdbArtistBand(Artist artist) {
        if (artist == null) {
            return;

        }

        if (artist.getInfo() == null) {
            return;
        }
        this.setFormed(StringUtils.trim(artist.getInfo().getFormed()));
        
        if (!ListUtils.isEmpty(artist.getMembers())) {
            artist.getMembers().stream().forEach((bandMember) -> {
                getMember().add(new VGMdbPerson(
                        bandMember.getNames(),
                        StringUtils.trim(bandMember.getLink())));
            });
        }
        
        if (!ListUtils.isEmpty(artist.getInfo().getFormerMembers())) {
            artist.getInfo().getFormerMembers().stream().forEach((bandMember) -> {
                getFormerMember().add(new VGMdbPerson(
                        bandMember.getNames(),
                        StringUtils.trim(bandMember.getLink())));
            });
        }
    }
}
