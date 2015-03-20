package de.knoobie.project.nagisa.gson.util;

import de.knoobie.project.nagisa.gson.model.bo.TransientAlbum;
import de.knoobie.project.nagisa.gson.model.bo.TransientArtist;
import de.knoobie.project.nagisa.gson.model.bo.TransientEvent;
import de.knoobie.project.nagisa.gson.model.bo.enums.ArtistType;
import de.knoobie.project.nagisa.gson.model.dto.json.artist.Artist;
import de.knoobie.project.nagisa.gson.model.dto.json.artist.ArtistAlias;
import de.knoobie.project.nagisa.gson.model.dto.json.artist.ArtistDiscography;
import de.knoobie.project.nagisa.gson.model.dto.json.organisation.Organisation;
import de.knoobie.project.nagisa.gson.model.dto.json.organisation.OrganisationRelease;
import de.knoobie.project.nagisa.gson.model.dto.json.product.Product;
import de.knoobie.project.nagisa.gson.model.dto.json.product.ProductAlbum;
import de.knoobie.project.nagisa.gson.model.dto.json.product.ProductTitle;
import de.knoobie.project.nagisa.gson.model.dto.json.search.ResultAlbum;
import de.knoobie.project.nagisa.gson.model.dto.json.search.ResultArtist;
import de.knoobie.project.nagisa.gson.model.dto.json.search.ResultOrganisation;
import de.knoobie.project.nagisa.gson.model.dto.json.search.ResultProduct;
import de.knoobie.project.nagisa.gson.model.dto.json.search.SearchResult;
import java.io.IOException;

public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
//        event();
//        test_getArtist("Band", "6310");
//        test_getArtist("Person", "5");
//        event();
//        organisation();
//artist();
//   product();
//        album();
//        search("Nagi Yanagi");
//        getArtist();
//        search("vagran");

//        search("haruhi");
    }

//    private static void event() throws Exception {
//        TransientEvent event = new TransientEvent(SearchUtils.getEvent("175"));
//        System.out.println("-->getName " + event.getName());
//        System.out.println("-->getDescription " + event.getDescription());
//        System.out.println("-->getLink " + event.getLink());
//        System.out.println("-->getStartdate " + event.getStartdate());
//        System.out.println("-->getEnddate " + event.getEnddate());
//
//        System.out.println("Releases:");
//        event.getReleases().stream().forEach((release) -> {
//            System.out.println(" - " + release.getNames().get(0).getName() + " | " + release.getCatalog() + " | " + release.getLink() + " | " + release.getReleaseType()+ " | " + release.getReleaseDate());
//        });
//    }

//    private static void organisation() throws Exception {
//        Organisation p = SearchUtils.getOrganisation("429");
//        System.out.println("-->getName " + p.getName());
//        System.out.println("-->getDescription " + p.getDescription());
//        System.out.println("-->getLink " + p.getLink());
//        System.out.println("-->getRegion " + p.getRegion());
//        System.out.println("-->getPictureFull " + p.getPictureFull());
//        System.out.println("-->getType " + p.getType());
//        for (OrganisationRelease album : p.getReleases()) {
//            System.out.println("------------------------------------------------> ");
//            System.out.println("-getNames-> " + album.getNames().getEn());
//            System.out.println("-getNames-> " + album.getNames().getJa());
//            System.out.println("-Roles-> " + album.getRole());
//            System.out.println("-Type-> " + album.getType());
//            System.out.println("-Link-> " + album.getLink());
//            if (album.getEvent() != null) {
//                System.out.println("-Event Name-> " + album.getEvent().toString());
//            }
//
//        }
//    }

//    private static void artist() throws Exception {
//        Artist p = SearchUtils.getArtist("5");
//        System.out.println("-->getName " + p.getName());
//        System.out.println("-->getNotes " + p.getNotes());
//        System.out.println("-->getLink " + p.getLink());
//        System.out.println("-->getBirthdate " + p.getBirthdate());
//        System.out.println("-->getPictureFull " + p.getPictureFull());
//        System.out.println("-->getSex " + p.getSex());
//        for (ArtistAlias alias : p.getAliases()) {
//            System.out.println("------------------------------------------------> ");
//            System.out.println("-Alias-> " + alias.getNames().getEn());
//        }
//        for (ArtistDiscography album : p.getDiscography()) {
//            System.out.println("------------------------------------------------> ");
//            System.out.println("-ArtistDiscography-> " + album.getTitles().getEn());
//            System.out.println("-ArtistDiscography-> " + album.getTitles().getJa());
//            System.out.println("-Roles-> " + album.getRoles().toString());
//            System.out.println("-Type-> " + album.getType());
//        }
//    }

//    private static void product() throws IOException, Exception {
//        Product p = SearchUtils.getProduct("1122");
//        System.out.println(p.getName());
//        System.out.println("-->getName " + p.getName());
//        for (ProductTitle title : p.getTitles()) {
//            System.out.println("------------------------------------------------> ");
//            System.out.println("-Title-> " + title.getNames().getEnglish());
//            System.out.println("-Title-> " + title.getNames().getEn());
//        }
//        for (ProductAlbum album : p.getAlbums()) {
//            System.out.println("------------------------------------------------> ");
//            System.out.println("-Album Name-> " + album.getNames().getEnglish());
//            System.out.println("-Album Name-> " + album.getNames().getEn());
//            System.out.println("-Album Name-> " + album.getNames().getJa());
//        }
//    }

    private static void test_getArtist(String person_band, String query) throws Exception {
        TransientArtist artist = VGMdb.getArtist(query);

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

    private static void album() throws IOException, Exception {
        TransientAlbum p = VGMdb.getAlbum("38626");
        System.out.println(p.getName());
        p.getNames().stream().forEach((name) -> {
            System.out.println("Language: " + name.getLanguage().getHumanizedName() + " - Name: " + name.getName());
        });

        System.out.println("-> Arrangers: ");
        p.getArrangers().stream().forEach((arranger) -> {
            System.out.println("Name: " + arranger.getNames().get(0).getName() + " - Link: " + arranger.getLink());
        });

        System.out.println("-> Composer: ");
        p.getComposers().stream().forEach((composer) -> {
            System.out.println("Name: " + composer.getNames().get(0).getName() + " - Link: " + composer.getLink());
        });

        System.out.println("-> Performer: ");
        p.getPerformers().stream().forEach((performer) -> {
            System.out.println("Name: " + performer.getNames().get(0).getName() + " - Link: " + performer.getLink());
        });

        System.out.println("-> CDs: ");
        p.getDiscs().stream().forEach((disc) -> {
            System.out.println("----> CD --- " + disc.getName() + "(+" + disc.getDiscLength() + ")");
            disc.getTracks().stream().forEach((track) -> {
                System.out.println("--> Track");
                track.getNames().stream().forEach((name) -> {
                    System.out.println("-----> " + name.getName() + " - Language: " + name.getLanguage().getHumanizedName());
                });
            });
        });

//        for (AlbumTrack track : p.getDiscs().get(0).getTracks()) {
//            System.out.println("------------------------------------------------> ");
//            System.out.println("----> " + track.getNames().getEnglish());
//            System.out.println("----> " + track.getNames().getEn());
//            System.out.println("----> " + track.getNames().getEng_furigana());
//            System.out.println("----> " + track.getNames().getJa());
//            System.out.println("----> " + track.getNames().getJa_furigana());
//            System.out.println("----> " + track.getNames().getOriginal());
//            System.out.println("----> " + track.getNames().getRomaji());
//        }
    }

//    private static void getArtist() throws Exception {
//        Artist artist = SearchUtils.getArtist("13234");
//
//        System.out.println("Name " + artist.getName());
//        System.out.println("Name " + artist.getNameReal());
//        System.out.println("Name " + artist.getNameTrans());
//        System.out.println("Notes " + artist.getNotes());
//        for (Discography disco : artist.getDiscography()) {
//            System.out.println("--> " + disco.getDate() + " --- " + disco.getType());
//            System.out.println("--> " + disco.getNames().getEn() + " --- " + disco.getCatalog());
//        }
//    }
    private static void search(String query) throws Exception {

        SearchResult p = VGMdb.find(query);
        System.out.println("-->getLink " + p.getLink());
        System.out.println("-->getQuery " + p.getQuery());
        System.out.println("--> Anzahl getAlbums = " + p.getResults().getAlbums().size());
        for (ResultAlbum album : p.getResults().getAlbums()) {
            System.out.println("------------------------------------------------> ");
            System.out.println("-Link -> " + album.getLink());
            System.out.println("-Album Name-> " + album.getNames().getEnglish());
            System.out.println("-Album Name-> " + album.getNames().getEn());
            System.out.println("-Album Name-> " + album.getNames().getJa());
        }
        System.out.println("--> Anzahl getArtists = " + p.getResults().getArtists().size());
        for (ResultArtist artist : p.getResults().getArtists()) {
            System.out.println("------------------------------------------------> ");
            System.out.println("-Link -> " + artist.getLink());
            System.out.println("-getAliases-> " + artist.getAliases().toString());
            if (artist.getNames() != null) {
                System.out.println("-artist Name-> " + artist.getNames().getEnglish());
                System.out.println("-artist Name-> " + artist.getNames().getEn());
                System.out.println("-artist Name-> " + artist.getNames().getJa());
            }
        }
        System.out.println("--> Anzahl getOrgs = " + p.getResults().getOrgs().size());
        for (ResultOrganisation organisation : p.getResults().getOrgs()) {
            System.out.println("------------------------------------------------> ");
            System.out.println("-Link -> " + organisation.getLink());
            System.out.println("-organisation Name-> " + organisation.getNames().getEnglish());
            System.out.println("-organisation Name-> " + organisation.getNames().getEn());
            System.out.println("-organisation Name-> " + organisation.getNames().getJa());
        }
        System.out.println("--> Anzahl getProducts = " + p.getResults().getProducts().size());
        for (ResultProduct product : p.getResults().getProducts()) {
            System.out.println("------------------------------------------------> ");
            System.out.println("-Link -> " + product.getLink());
            System.out.println("-Type -> " + product.getType());
//            System.out.println("-getAliases-> " + product.getAliases().toString());
            System.out.println("-product Name-> " + product.getNames().getEnglish());
            System.out.println("-product Name-> " + product.getNames().getEn());
            System.out.println("-product Name-> " + product.getNames().getJa());
        }
    }
}
