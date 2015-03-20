package de.knoobie.project.nagisa.gson.run;

import de.knoobie.project.nagisa.gson.model.bo.TransientArtist;
import de.knoobie.project.nagisa.gson.model.bo.TransientOrganisation;
import de.knoobie.project.nagisa.gson.model.bo.enums.ArtistType;
import de.knoobie.project.nagisa.gson.util.SearchUtils;

public class TransientModelRun {

    public static void main(String[] args) throws Exception {
        test_getOrg("1");
//        test_getArtist("Band", "6310");
//        test_getArtist("Person", "5");
    }

    private static void test_getOrg(String query) throws Exception {
        TransientOrganisation org = new TransientOrganisation(SearchUtils.getOrganisation(query));

        System.out.println("Organisation: " + org.getName() + " / " + org.getLink());
        System.out.println("Desc: " + org.getDescription());
        System.out.println("Region: " + org.getRegion());
        System.out.println("Type: " + org.getType());

        org.getReleases().stream().forEach((release) -> {
            System.out.println(" - " + release.getNames().get(0).getName() + " | " + release.getCatalog()
                    + " | " + release.getLink() + " | " + release.getType() + " | " + release.getRole()
                    + (release.getEvent() != null ? "(Event: " + release.getEvent().getName() + " / Link: "+release.getEvent().getLink()+")" : ""));
        });
    }

    private static void test_getArtist(String person_band, String query) throws Exception {
        TransientArtist artist = new TransientArtist(SearchUtils.getArtist(query));

        System.out.println("test_getArtist()");
        System.out.println(person_band + ": " + artist.getName() + " / " + artist.getLink());

        artist.getAliases().stream().forEach((name) -> {
            System.out.println(" - Alias: " + name.getName() + " | " + name.getLanguage().getHumanizedName());
        });

        System.out.println("Discography:");
        artist.getDiscography().stream().forEach((album) -> {
            System.out.println(" - " + album.getNames().get(0).getName() + " | " + album.getCatalog() + " | " + album.getLink() + " | " + album.getType() + " | " + album.getRoles());
        });

        System.out.println("FeaturedOn:");
        artist.getFeaturedOn().stream().forEach((album) -> {
            System.out.println(" - " + album.getNames().get(0).getName() + " | " + album.getCatalog() + " | " + album.getLink() + " | " + album.getType() + " | " + album.getRoles());
        });

        System.out.println("Picture: " + artist.getPicture().getSmall() + " / " + artist.getPicture().getFull());

        System.out.println(person_band + "Info:");
        if (artist.getType() == ArtistType.unit) {
            System.out.println("Formed: " + artist.getBandInfo().getFormed());
            System.out.println("Member:");
            artist.getBandInfo().getMember().stream().forEach((member) -> {
                System.out.println(" - " + member.getNames().get(0).getName() + " | " + member.getLink());
            });
            System.out.println("FormerMember:");
            artist.getBandInfo().getFormerMember().stream().forEach((member) -> {
                System.out.println(" - " + member.getNames().get(0).getName() + " | " + member.getLink());
            });
        }
        if (artist.getType() == ArtistType.individual) {
            System.out.println("getBirthdate: " + artist.getPersonInfo().getBirthdate());
            System.out.println("getBloodtype: " + artist.getPersonInfo().getBloodtype());
            System.out.println("getGender: " + artist.getPersonInfo().getGender().getHumanizedName());
            System.out.println("getBandMemberOf:");
            artist.getPersonInfo().getBandMemberOf().stream().forEach((member) -> {
                System.out.println(" - " + member.getNames().get(0).getName() + " | " + member.getLink());
            });
        }
    }
}
