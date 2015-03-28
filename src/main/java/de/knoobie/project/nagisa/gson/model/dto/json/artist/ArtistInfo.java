package de.knoobie.project.nagisa.gson.model.dto.json.artist;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;


public @Data class ArtistInfo {

    @SerializedName("Album Votes")
    private String AlbumVotes;
    private String Birthdate;
    private String Bloodtype;    
    private String[] Variations;
    private String Formed;
    
    @SerializedName("Former Members")
    private List<ArtistLinkage> formerMembers = new ArrayList<>();
    
    private List<ArtistAlias> Aliases = new ArrayList<>();
    @SerializedName("Credited works")
    private List<String> CreditedWorks = new ArrayList<>();
    @SerializedName("Weighted album rating")
    private List<String> WeightedAlbumRating = new ArrayList<>();
 //   private List<ArtistLinkage> Units = new ArrayList<>();
    private List<ArtistLinkage> Member = new ArrayList<>();


}
