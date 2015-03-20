package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.ListUtils;
import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.nagisa.gson.model.bo.enums.Gender;
import de.knoobie.project.nagisa.gson.model.dto.json.artist.Artist;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data
class TransientArtistPerson {

    // Person
    private String birthdate;
    private String birthplace;
    private String Bloodtype;
    private Gender gender;
    // info -> Units -> BandMemberOf
    private List<TransientPerson> bandMemberOf = new ArrayList<>();

    public TransientArtistPerson(Artist artist) {
        if (artist == null) {
            return;

        }
        this.setBirthdate(StringUtils.trim(artist.getBirthdate()));
        this.setBirthplace(StringUtils.trim(artist.getBirthplace()));
        this.setGender(Gender.getGenderByName(StringUtils.trim(artist.getSex())));

        if (artist.getInfo() == null) {
            return;
        }
        this.setBloodtype(StringUtils.trim(artist.getInfo().getBloodtype()));
        
        if (!ListUtils.isEmpty(artist.getUnits())) {
            artist.getUnits().stream().forEach((bandMember) -> {
                getBandMemberOf().add(new TransientPerson(
                        bandMember.getNames(),
                        StringUtils.trim(bandMember.getLink())));
            });
        }
    }
}
