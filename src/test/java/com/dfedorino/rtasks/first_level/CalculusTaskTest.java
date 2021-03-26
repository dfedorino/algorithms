package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.expectThrows;

public class CalculusTaskTest {
    /* positive tests */
    @Test
    public void divideApplesPositiveTest() {
        assertEquals(CalculusTasks.divideApples(3, 14), 4);
        assertEquals(CalculusTasks.divideApples(Integer.MAX_VALUE, Integer.MAX_VALUE), 1);
        assertEquals(CalculusTasks.divideApples(0, 0), 0);
    }

    @Test
    public void applesRemainderPositiveTest() {
        assertEquals(CalculusTasks.applesRemainder(3, 14), 2);
        assertEquals(CalculusTasks.applesRemainder(Integer.MAX_VALUE, Integer.MAX_VALUE), 0);
        assertEquals(CalculusTasks.applesRemainder(0, 0), 0);
    }

    @Test
    public void nextAndPreviousPositiveTest() {
        assertEquals(CalculusTasks.nextAndPrevious(179),
                "The next number for the number 179 is 180." + System.lineSeparator() +
                        "The previous number for the number 179 is 178.");
        assertEquals(CalculusTasks.nextAndPrevious(10_000),
                "The next number for the number 10000 is 10001." + System.lineSeparator() +
                        "The previous number for the number 10000 is 9999.");
        assertEquals(CalculusTasks.nextAndPrevious(0),
                "The next number for the number 0 is 1." + System.lineSeparator() +
                        "The previous number for the number 0 is -1.");
        assertEquals(CalculusTasks.nextAndPrevious(-10_000),
                "The next number for the number -10000 is -9999." + System.lineSeparator() +
                        "The previous number for the number -10000 is -10001.");
    }

    @Test
    public void calculateHypotenusePositiveTest() {
        assertEquals(CalculusTasks.calculateHypotenuse(0, 0), 0);
        assertEquals(CalculusTasks.calculateHypotenuse(3, 4), 5);
        assertEquals(CalculusTasks.calculateHypotenuse(1000, 1000), 1414);
    }

    @Test
    public void getLastDigitPositiveTest() {
        assertEquals(CalculusTasks.getLastDigit(179), 9);
        assertEquals(CalculusTasks.getLastDigit(0), 0);
        assertEquals(CalculusTasks.getLastDigit(Integer.MAX_VALUE), 7);
        assertEquals(CalculusTasks.getLastDigit(Integer.MIN_VALUE), 8);
    }

    @Test
    public void getTensPositiveTest() {
        assertEquals(CalculusTasks.getTens(0), 0);
        assertEquals(CalculusTasks.getTens(9), 0);
        assertEquals(CalculusTasks.getTens(10), 1);
        assertEquals(CalculusTasks.getTens(42), 4);
        assertEquals(CalculusTasks.getTens(99), 9);
        assertEquals(CalculusTasks.getTens(179), 7);
        assertEquals(CalculusTasks.getTens(Integer.MAX_VALUE), 4);
    }

    @Test
    public void getDigitsSumPositiveTest() {
        assertEquals(CalculusTasks.getDigitsSum(-999), 27);
        assertEquals(CalculusTasks.getDigitsSum(-99), 18);
        assertEquals(CalculusTasks.getDigitsSum(-9), 9);
        assertEquals(CalculusTasks.getDigitsSum(0), 0);
        assertEquals(CalculusTasks.getDigitsSum(9), 9);
        assertEquals(CalculusTasks.getDigitsSum(99), 18);
        assertEquals(CalculusTasks.getDigitsSum(999), 27);
    }

    @Test
    public void getCurrentTimePositiveTest() {
        assertEquals(CalculusTasks.getCurrentTime(0), "0 0");
        assertEquals(CalculusTasks.getCurrentTime(150), "2 30");
        assertEquals(CalculusTasks.getCurrentTime(720), "0 0");
    }

    @Test
    public void getOverallPricePositiveTest() {
        assertEquals(CalculusTasks.getOverallPrice(0, 0, 0), "0 0");
        assertEquals(CalculusTasks.getOverallPrice(10, 15, 2), "20 30");
        assertEquals(CalculusTasks.getOverallPrice(2, 50, 4), "10 0");
        assertEquals(CalculusTasks.getOverallPrice(
                Integer.MAX_VALUE,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE), "4657802874273744815 9");
    }

    @Test
    public void getTimeDifferencePositiveTest() {
        assertEquals(CalculusTasks.getTimeDifference(
                0, 0, 0,
                0, 0, 0),
                0
        );
        assertEquals(CalculusTasks.getTimeDifference(
                0, 0, 0,
                11, 59, 59),
                43199
        );
        assertEquals(CalculusTasks.getTimeDifference(
                1, 1, 1,
                2, 2, 2),
                3661
        );
        assertEquals(CalculusTasks.getTimeDifference(
                1, 2, 30,
                1, 3, 20),
                50
        );
        assertEquals(CalculusTasks.getTimeDifference(
                11, 59, 59,
                11, 59, 59),
                0
        );
    }

    /* negative tests */
    @Test
    public void divideApplesNegativeTest() {
        List<Throwable> throwables = Arrays.asList(
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.divideApples(Integer.MIN_VALUE, 14)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.divideApples(3, Integer.MIN_VALUE)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.divideApples(Integer.MIN_VALUE, Integer.MIN_VALUE))
        );
        throwables.forEach(throwable -> assertEquals(
                throwable.getMessage(),
                "The number is not within 0 and " + Integer.MAX_VALUE)
        );
    }

    @Test
    public void applesRemainderNegativeTest() {
        List<Throwable> throwables = Arrays.asList(
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.applesRemainder(Integer.MIN_VALUE, 14)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.applesRemainder(3, Integer.MIN_VALUE)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.applesRemainder(Integer.MIN_VALUE, Integer.MIN_VALUE))
        );
        throwables.forEach(throwable -> assertEquals(
                throwable.getMessage(),
                "The number is not within 0 and " + Integer.MAX_VALUE)
        );
    }

    @Test
    public void nextAndPreviousNegativeTest() {
        List<Throwable> throwables = Arrays.asList(
                expectThrows(IllegalArgumentException.class, () -> CalculusTasks.nextAndPrevious(Integer.MIN_VALUE)),
                expectThrows(IllegalArgumentException.class, () -> CalculusTasks.nextAndPrevious(Integer.MAX_VALUE))
        );
        throwables.forEach(throwable -> assertEquals(
                throwable.getMessage(),
                "The number is not within -10000 and 10000")
        );
    }

    @Test
    public void calculateHypotenuseNegativeTest() {
        List<Throwable> throwables = Arrays.asList(
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.calculateHypotenuse(Integer.MIN_VALUE, Integer.MIN_VALUE)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.calculateHypotenuse(Integer.MAX_VALUE, Integer.MAX_VALUE)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.calculateHypotenuse(Integer.MIN_VALUE, Integer.MAX_VALUE)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.calculateHypotenuse(Integer.MAX_VALUE, Integer.MIN_VALUE))
        );

        throwables.forEach(throwable -> assertEquals(
                throwable.getMessage(),
                "The number is not within 0 and 1000")
        );
    }

    @Test
    public void getTensNegativeTest() {
        Throwable throwable = expectThrows(
                IllegalArgumentException.class,
                () -> CalculusTasks.getTens(Integer.MIN_VALUE));

        assertEquals(
                throwable.getMessage(),
                "The number is not within 0 and " + Integer.MAX_VALUE);
    }

    @Test
    public void getDigitsSumNegativeTest() {
        List<Throwable> throwables = Arrays.asList(
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getDigitsSum(Integer.MIN_VALUE)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getDigitsSum(-1000)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getDigitsSum(1000)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getDigitsSum(Integer.MAX_VALUE))
        );

        throwables.forEach(throwable -> assertEquals(
                throwable.getMessage(),
                "The number is not within -999 and 999")
        );
    }

    @Test
    public void getCurrentTimeNegativeTest() {
        List<Throwable> throwables = Arrays.asList(
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getCurrentTime(Integer.MIN_VALUE)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getCurrentTime(-1)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getCurrentTime(721)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getCurrentTime(Integer.MAX_VALUE))
        );

        throwables.forEach(throwable -> assertEquals(
                throwable.getMessage(),
                "The number is not within 0 and 720")
        );
    }

    @Test
    public void getOverallPriceNegativeTest() {
        List<Throwable> throwables = Arrays.asList(
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getOverallPrice(Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getOverallPrice(Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getOverallPrice(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE))
        );

        throwables.forEach(throwable -> assertEquals(
                throwable.getMessage(),
                "The number is not within 0 and " + Integer.MAX_VALUE)
        );
    }

    @Test
    public void getTimeDifferenceNegativeTestHoursBounds() {
        List<Throwable> throwables = Arrays.asList(
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                12, 0, 0,
                                0, 0, 0)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 0, 0,
                                12, 0, 0)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 0, 0,
                                Integer.MAX_VALUE, 0, 0
                        )),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                Integer.MAX_VALUE, 0, 0,
                                Integer.MAX_VALUE, 0, 0)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                12, 60, 60,
                                0, 0, 0)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 0, 0,
                                12, 60, 60)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                12, 60, 60,
                                12, 60, 60)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
                                0, 0, 0)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 0, 0,
                                Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
                                Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                -12, 0, 0,
                                0, 0, 0)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 0, 0,
                                -12, 0, 0)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 0, 0,
                                Integer.MIN_VALUE, 0, 0
                        )),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                Integer.MIN_VALUE, 0, 0,
                                Integer.MIN_VALUE, 0, 0)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                -12, -60, -60,
                                0, 0, 0)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 0, 0,
                                -12, -60, -60)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                -12, -60, -60,
                                -12, -60, -60)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE,
                                0, 0, 0)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 0, 0,
                                Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE,
                                Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE))
        );

        throwables.forEach(throwable -> assertEquals(
                throwable.getMessage(),
                "The number is not within 0 and 11")
        );
    }

    @Test
    public void getTimeDifferenceNegativeTestMinutesBounds() {
        List<Throwable> throwables = Arrays.asList(
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 60, 0,
                                0, 0, 0)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 0, 0,
                                0, 60, 0)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 0, 0,
                                0, Integer.MAX_VALUE, 0
                        )),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, Integer.MAX_VALUE, 0,
                                0, Integer.MAX_VALUE, 0)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 60, 60,
                                0, 0, 0)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 0, 0,
                                0, 60, 60)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 60, 60,
                                0, 60, 60)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, Integer.MAX_VALUE, Integer.MAX_VALUE,
                                0, 0, 0)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 0, 0,
                                0, Integer.MAX_VALUE, Integer.MAX_VALUE)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, Integer.MAX_VALUE, Integer.MAX_VALUE,
                                0, Integer.MAX_VALUE, Integer.MAX_VALUE)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, -60, 0,
                                0, 0, 0)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 0, 0,
                                0, -60, 0)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 0, 0,
                                0, Integer.MIN_VALUE, 0
                        )),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, Integer.MIN_VALUE, 0,
                                0, Integer.MIN_VALUE, 0)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, -60, -60,
                                0, 0, 0)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 0, 0,
                                0, -60, -60)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, -60, -60,
                                0, -60, -60)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, Integer.MIN_VALUE, Integer.MIN_VALUE,
                                0, 0, 0)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 0, 0,
                                0, Integer.MIN_VALUE, Integer.MIN_VALUE)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, Integer.MIN_VALUE, Integer.MIN_VALUE,
                                0, Integer.MIN_VALUE, Integer.MIN_VALUE))
        );

        throwables.forEach(throwable -> assertEquals(
                throwable.getMessage(),
                "The number is not within 0 and 59")
        );
    }

    @Test
    public void getTimeDifferenceNegativeTestSecondsBounds() {
        List<Throwable> throwables = Arrays.asList(
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 0, 60,
                                0, 0, 0)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 0, 0,
                                0, 0, 60)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 0, 60,
                                0, 0, 60)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 0, 0,
                                0, 0, Integer.MAX_VALUE
                        )),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 0, Integer.MAX_VALUE,
                                0, 0, Integer.MAX_VALUE)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, Integer.MAX_VALUE, Integer.MAX_VALUE,
                                0, 0, 0)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 0, -60,
                                0, 0, 0)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 0, 0,
                                0, 0, -60)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 0, -60,
                                0, 0, -60)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 0, 0,
                                0, 0, Integer.MIN_VALUE
                        )),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 0, Integer.MIN_VALUE,
                                0, 0, Integer.MIN_VALUE))
        );

        throwables.forEach(throwable -> assertEquals(
                throwable.getMessage(),
                "The number is not within 0 and 59")
        );
    }

    @Test
    public void getTimeDifferenceNegativeTestEndBeforeStart() {
        List<Throwable> throwables = Arrays.asList(
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                1, 0, 0,
                                0, 0, 0)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 1, 0,
                                0, 0, 0)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 0, 1,
                                0, 0, 0)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                11, 0, 0,
                                0, 0, 0)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 59, 0,
                                0, 0, 0)),
                expectThrows(
                        IllegalArgumentException.class,
                        () -> CalculusTasks.getTimeDifference(
                                0, 0, 59,
                                0, 0, 0))
        );

        throwables.forEach(throwable -> assertEquals(
                throwable.getMessage(),
                "The number is not within 0 and 0")
        );
    }
}