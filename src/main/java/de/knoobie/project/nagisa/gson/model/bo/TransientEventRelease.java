package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.nagisa.gson.model.dto.json.event.EventRelease;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data
class TransientEventRelease {

    private String link;
    private String catalog;
    private String albumType;
    private String releaseDate;
    private String releaseType;

    private TransientPerson publisher;
    private List<TransientName> names = new ArrayList<>();

    public TransientEventRelease(EventRelease release) {
        if (release == null) {
            this.setAlbumType(StringUtils.EMPTY);
            this.setCatalog(StringUtils.EMPTY);
            this.setLink(StringUtils.EMPTY);
            this.setReleaseDate(StringUtils.EMPTY);
            this.setReleaseType(StringUtils.EMPTY);
            return;
        }

        this.setAlbumType(StringUtils.trim(release.getAlbumType()));
        this.setCatalog(StringUtils.trim(release.getCatalog()));
        this.setLink(StringUtils.trim(release.getLink()));
        this.setReleaseDate(StringUtils.trim(release.getReleaseDate()));
        this.setReleaseType(StringUtils.trim(release.getReleaseType()));
        this.setNames(TransientName.parseNames(release.getNames()));
        if (release.getPublisher() != null) {
            this.setPublisher(new TransientPerson(release.getPublisher().getNames(), StringUtils.EMPTY));
        }
    }

}
