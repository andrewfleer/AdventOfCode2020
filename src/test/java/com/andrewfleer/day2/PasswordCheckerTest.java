package com.andrewfleer.day2;

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
    public void testPasswordValidPasswordRequirementPart1() {
        boolean passwordValid = passwordChecker.isPasswordValidPart1(a,password,minAndMax);

        assert(passwordValid);
    }

    @Test
    public void testPasswordRequirementPart1NotEnough() {
        boolean passwordValid = passwordChecker.isPasswordValidPart1(f, password, minAndMax);

        assert(!passwordValid);
    }

    @Test
    public void testPasswordRequirementPart1TooMany() {
        boolean passwordValid = passwordChecker.isPasswordValidPart1(s, password, minAndMax);

        assert(!passwordValid);
    }

    @Test
    public void testPasswordRequirementPart2PassFirstPosition() {
        String[] positions = new String[] {"1", "5"};

        boolean passwordValid = passwordChecker.isPasswordValidPart2(s, password, positions);

        assert(passwordValid);
    }

    @Test
    public void testPasswordRequirementPart2PassSecondPosition() {
        String[] positions = new String[] {"1", "5"};

        boolean passwordValid = passwordChecker.isPasswordValidPart2(a, password, positions);

        assert(passwordValid);
    }

    @Test
    public void testPasswordRequirementPart2FailBothPositions() {
        String[] positions = new String[] {"1", "4"};

        boolean passwordValid = passwordChecker.isPasswordValidPart2(s, password, positions);

        assert(!passwordValid);
    }

    @Test
    public void testPasswordRequirementPart2FailNoPositions() {
        String[] positions = new String[] {"1", "4"};

        boolean passwordValid = passwordChecker.isPasswordValidPart2(f, password, positions);

        assert(!passwordValid);
    }
}
