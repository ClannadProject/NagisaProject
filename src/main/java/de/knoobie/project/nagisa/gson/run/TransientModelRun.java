package de.knoobie.project.nagisa.gson.run;

import com.google.gson.JsonSyntaxException;
import de.knoobie.project.clannadutils.common.ListUtils;
import de.knoobie.project.nagisa.gson.model.bo.VGMdbArtist;
import de.knoobie.project.nagisa.gson.model.bo.VGMdbName;
import de.knoobie.project.nagisa.gson.model.bo.VGMdbOrganisation;
import de.knoobie.project.nagisa.gson.model.bo.VGMdbProduct;
import de.knoobie.project.nagisa.gson.model.bo.VGMdbSearch;
import de.knoobie.project.nagisa.gson.model.bo.enums.VGMdbArtistType;
import de.knoobie.project.nagisa.gson.util.VGMdb;
import java.io.IOException;

public class TransientModelRun {

    public static void main(String[] args) throws IllegalArgumentException, JsonSyntaxException, IOException {


//        test_getOrg("1");
//        test_getArtist("Band", "6310");
//        test_getArtist("Person", "5");
//        test_Product("1018"); // Francise
//        test_Product("1019"); // Game
//        test_Product("1020"); // Video
//        test_Product("1021"); // Video
//        test_Product("1028"); // Game
        test_search("vagran");
    }

    private static void test_search(String query) throws IllegalArgumentException, JsonSyntaxException, IOException {
        VGMdbSearch search = VGMdb.search(query);

        System.out.println("Query: " + search.getQuery() + " / " + search.getLink());

        System.out.println("Albums:");
        search.getAlbums().stream().forEach((album) -> {
            System.out.println(" - " + album.getNames().get(0).getName() + " | " + album.getLink()
                    + " | " + album.getCatalog() + " | " + album.getReleaseDate());
        });

        System.out.println("Artists:");
        search.getArtists().stream().forEach((artist) -> {
            System.out.println(" - " + artist.getName() + "("
                    + ListUtils.getListAsString(VGMdbName.getOnlyNames(artist.getAliases())) + ") | " + artist.getLink());
        });

        System.out.println("Organisations:");
        search.getOrgs().stream().forEach((org) -> {
            System.out.println(" - " + ListUtils.getListAsString(VGMdbName.getOnlyNames(org.getAliases())) + " | " + org.getLink());
        });

        System.out.println("Products:");
        search.getProducts().stream().forEach((product) -> {
            System.out.println(" - " + product.getNames().get(0).getName() + " | " + product.getLink()
                    + " | " + product.getType());
        });
    }

    private static void test_Product(String query) throws Exception {
        VGMdbProduct product = VGMdb.getProduct(query);

        System.out.println("Product: " + product.getName() + " / " + product.getLink());
        System.out.println("getDescription: " + product.getDescription());
        System.out.println("getReleaseDate: " + product.getReleaseDate());
        System.out.println("getOrganizations: " + product.getOrganizations());

        System.out.println("Type: " + product.getType().getHumanizedName());

        System.out.println("Francise:");
        product.getFrancises().stream().forEach((francise) -> {
            System.out.println(" - " + francise.getNames().get(0).getName() + " | " + francise.getLink()
                    + " | " + francise.getPlatform() + " | " + francise.getRegion());
        });

        System.out.println("Titles:");
        product.getTitles().stream().forEach((title) -> {
            System.out.println(" - " + title.getNames().get(0).getName() + " | " + title.getLink()
                    + " | " + title.getPlatform() + " | " + title.getRegion());
        });

        System.out.println("Releases:");
        product.getReleases().stream().forEach((release) -> {
            System.out.println(" - " + release.getNames().get(0).getName() + " | " + release.getLink()
                    + " | " + release.getPlatform() + " | " + release.getRegion());
        });

        System.out.println("Albums:");
        product.getAlbums().stream().forEach((album) -> {
            System.out.println(" - " + album.getNames().get(0).getName() + " | " + album.getCatalog()
                    + " | " + album.getLink() + " | " + album.getType());
        });
    }

    private static void test_getOrg(String query) throws Exception {
        VGMdbOrganisation org = VGMdb.getOrganisation(query);

        System.out.println("Organisation: " + org.getName() + " / " + org.getLink());
        System.out.println("Desc: " + org.getDescription());
        System.out.println("Region: " + org.getRegion());
        System.out.println("Type: " + org.getType());

        org.getReleases().stream().forEach((release) -> {
            System.out.println(" - " + release.getNames().get(0).getName() + " | " + release.getCatalog()
                    + " | " + release.getLink() + " | " + release.getType() + " | " + release.getRole()
                    + (release.getEvent() != null ? "(Event: " + release.getEvent().getName() + " / Link: " + release.getEvent().getLink() + ")" : ""));
        });
    }

    private static void test_getArtist(String person_band, String query) throws Exception {
        VGMdbArtist artist = VGMdb.getArtist(query);

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
        if (artist.getType() == VGMdbArtistType.unit) {
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
        if (artist.getType() == VGMdbArtistType.individual) {
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
