package core.helpers;

import lombok.extern.log4j.Log4j;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigInteger;

public class RandomGenerator {

    public static String generateAlphabetic() {
        return RandomStringUtils.randomAlphabetic(7);
    }

    public static BigInteger generateNumeric() {
        return BigInteger.valueOf(Long.parseLong(RandomStringUtils.randomNumeric(6)));

    }
}
