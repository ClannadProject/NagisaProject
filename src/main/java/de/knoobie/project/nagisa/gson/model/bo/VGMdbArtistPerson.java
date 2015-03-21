package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.ListUtils;
import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.nagisa.gson.model.bo.enums.VGMdbGender;
import de.knoobie.project.nagisa.gson.model.dto.json.artist.Artist;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data
class VGMdbArtistPerson {

    // Person
    private String birthdate;
    private String birthplace;
    private String Bloodtype;
    private VGMdbGender gender;
    // info -> Units -> BandMemberOf
    private List<VGMdbPerson> bandMemberOf = new ArrayList<>();

    public VGMdbArtistPerson(Artist artist) {
        if (artist == null) {
            return;

        }
        this.setBirthdate(StringUtils.trim(artist.getBirthdate()));
        this.setBirthplace(StringUtils.trim(artist.getBirthplace()));
        this.setGender(VGMdbGender.getGenderByName(StringUtils.trim(artist.getSex())));

        if (artist.getInfo() == null) {
            return;
        }
        this.setBloodtype(StringUtils.trim(artist.getInfo().getBloodtype()));
        
        if (!ListUtils.isEmpty(artist.getUnits())) {
            artist.getUnits().stream().forEach((bandMember) -> {
                getBandMemberOf().add(new VGMdbPerson(
                        bandMember.getNames(),
                        StringUtils.trim(bandMember.getLink())));
            });
        }
    }
}
