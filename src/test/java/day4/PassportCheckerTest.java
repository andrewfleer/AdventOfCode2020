package day4;

import com.andrewfleer.day4.Passport;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PassportCheckerTest {
    Passport goodPassport;
    Passport badPassport;
    List<Passport> passports;

    @Before
    public void initialize() {
        passports = new ArrayList<Passport>();
        createBadPassport();
        createGoodPassport();
        passports.add(badPassport);
        passports.add(goodPassport);

    }

    private void createBadPassport() {
        badPassport = new Passport();
        badPassport.setPassportId("ABC123");
        badPassport.setBirthYear("19870717");
    }

    private void createGoodPassport() {
        goodPassport = new Passport();
        goodPassport.setPassportId("ABC123");
        goodPassport.setBirthYear("19870717");
        goodPassport.setIssueYear("20201207");
        goodPassport.setExpirationYear("20301207");
        goodPassport.setEyeColor("BLUE");
        goodPassport.setHairColor("BROWN");
        goodPassport.setHeight("70");
    }

    @Test
    public void testBadPassport() {
        assert(!badPassport.isValid());
    }

    @Test
    public void testGoodPassport() {
        assert(goodPassport.isValid());
    }
}
