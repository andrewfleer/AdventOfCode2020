package day2;

import com.andrewfleer.day2.PasswordChecker;
import org.junit.Before;
import org.junit.Test;

public class PasswordCheckerTest {
    String s = "s";
    String a = "a";
    String f = "f";
    String password = "sassafras";
    String[] minAndMax = new String[] {"2","3"};
    PasswordChecker passwordChecker;

    @Before
    public void initialize() {
        passwordChecker = new PasswordChecker();
    }


    @Test
    public void testPasswordValidPasswordRequirement() {
        boolean passwordValid = passwordChecker.isPasswordValid(a,password,minAndMax);

        assert(passwordValid);
    }

    @Test
    public void testPasswordRequirementNotEnough() {
        boolean passwordValid = passwordChecker.isPasswordValid(f, password, minAndMax);

        assert(!passwordValid);
    }

    @Test
    public void testPasswordRequirementTooMany() {
        boolean passwordValid = passwordChecker.isPasswordValid(s, password, minAndMax);

        assert(!passwordValid);
    }
}
