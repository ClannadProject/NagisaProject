package de.knoobie.project.nagisa.gson.run;

import de.knoobie.project.nagisa.gson.model.bo.VGMdbArtist;
import de.knoobie.project.nagisa.gson.model.bo.VGMdbEvent;
import de.knoobie.project.nagisa.gson.model.bo.enums.VGMdbArtistType;
import de.knoobie.project.nagisa.gson.util.VGMdb;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author cKnoobie
 */
public class TransientModelRunTest {

    public TransientModelRunTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    
    public void testEventModel() throws Exception {
        final String id = "175";
        VGMdbEvent event = VGMdb.getEvent(id);
        
        assertEquals("Event("+id+"):getName", "Comic Market 87", event.getName());
        assertEquals("Event("+id+"):getLink", "event/175", event.getLink());
        assertEquals("Event("+id+"):getVgmdbLink", "http://vgmdb.net/event/175?perpage=99999", event.getVgmdbLink());
        assertEquals("Event("+id+"):getStartdate", "2014-12-27", event.getStartdate());
        assertEquals("Event("+id+"):getEnddate", "2014-12-29", event.getEnddate());
        assertEquals("Event("+id+"):getReleases", 10, event.getReleases().size());
    }

    public void testArtistModel() throws Exception {
        VGMdbArtist artist = VGMdb.getArtist("6310");
        
        
        assertEquals("Artist(6310):getName", "abingdon boys school", artist.getName());
        
//        test_getArtist("Band", "6310");
//        test_getArtist("Person", "5");
//        
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
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

    /**
     * Test of main method, of class TransientModelRun.
     */
    @Test
    public void testMain() throws Exception {
//        testArtistModel();
          testEventModel();
    }

}
