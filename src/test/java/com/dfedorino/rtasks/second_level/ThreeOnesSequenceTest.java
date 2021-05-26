package com.dfedorino.rtasks.second_level;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ThreeOnesSequenceTest {
    private final ThreeOnesSequence app = new ThreeOnesSequence();

    @Test
    public void testCountGoodCombinationsForLength_0_0() {
        assertThat(app.countGoodCombinationsForLength(0)).isEqualTo(0);
    }

    @Test
    public void testCountGoodCombinationsForLength_1_2() {
        assertThat(app.countGoodCombinationsForLength(1)).isEqualTo(2);
    }

    @Test
    public void testCountGoodCombinationsForLength_2_4() {
        assertThat(app.countGoodCombinationsForLength(2)).isEqualTo(4);
    }

    @Test
    public void testCountGoodCombinationsForLength_3_7() {
        assertThat(app.countGoodCombinationsForLength(3)).isEqualTo(7);
    }

    @Test
    public void testCountGoodCombinationsForLength_30_98950096() {
//        long expectedResult = checkManuallyForLength(30); // 98_950_096
        assertThat(app.countGoodCombinationsForLength(30)).isEqualTo(98_950_096);
    }

    private long checkManuallyForLength(int length) {
        long countSequences = 0;
        long border = (long) Math.pow(2, length);
        for (long sequence = 0; sequence < border; sequence++) {
            if (!containsThreeOnes(Long.toBinaryString(sequence))) {
                countSequences++;
            }
        }
        return countSequences;
    }

    private boolean containsThreeOnes(String binaryString) {
        int onesInRow = 0;
        for (int charIndex = 0; charIndex < binaryString.length(); charIndex++) {
            if (binaryString.charAt(charIndex) == '1') {
                onesInRow++;
                if (onesInRow == 3) {
                    return true;
                }
            } else {
                onesInRow = 0;
            }
        }
        return false;
    }
}