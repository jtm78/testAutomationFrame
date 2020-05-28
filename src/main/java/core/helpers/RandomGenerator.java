package core.helpers;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomGenerator {

    public static String generateAlphabetic() {
        return RandomStringUtils.randomAlphabetic(7);
    }

    public static String generateNumeric() {
        return RandomStringUtils.randomNumeric(6);
    }
}
