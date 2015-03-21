package de.knoobie.project.nagisa.gson.model.bo;

import de.knoobie.project.clannadutils.common.StringUtils;
import de.knoobie.project.nagisa.gson.model.dto.json.common.Meta;
import lombok.Data;

public @Data
class VGMdbMeta {

    private String addedDate;
    private String addedUser;
    private String editedDate;
    private String editedUser;

    private Integer freedb;
    private Integer ttl;
    private Integer visitors;

    public VGMdbMeta() {
        this.setAddedDate(StringUtils.EMPTY);
        this.setAddedUser(StringUtils.EMPTY);
        this.setEditedDate(StringUtils.EMPTY);
        this.setEditedUser(StringUtils.EMPTY);
        this.setFreedb(0);
        this.setTtl(0);
        this.setVisitors(0);
    }

    public VGMdbMeta(Meta meta) {
        super();

        if (meta == null) {
            return;
        }

        this.setAddedDate(StringUtils.trim(meta.getAddedDate()));
        this.setAddedUser(StringUtils.trim(meta.getAddedUser()));
        this.setEditedDate(StringUtils.trim(meta.getEditedDate()));
        this.setEditedUser(StringUtils.trim(meta.getEditedUser()));
        this.setFreedb(meta.getFreedb() == null ? 0 : meta.getFreedb());
        this.setTtl(meta.getTtl()== null ? 0 : meta.getTtl());
        this.setVisitors(meta.getVisitors()== null ? 0 : meta.getVisitors());
    }

}
