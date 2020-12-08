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
        goodPassport.setBirthYear("1971");
        goodPassport.setIssueYear("2012");
        goodPassport.setExpirationYear("2028");
        goodPassport.setEyeColor("BLU");
        goodPassport.setHairColor("#12345a");
        goodPassport.setHeight("70in");
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
