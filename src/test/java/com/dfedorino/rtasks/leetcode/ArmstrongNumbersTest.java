package com.dfedorino.rtasks.leetcode;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ArmstrongNumbersTest {
    private final ArmstrongNumbers app = new ArmstrongNumbers();

    @Test
    public void testFillListWithArmstrongNumbers_OneDigitNumbers_TenArmstrongNumbers() {
        int index = 0;
        int previousDigit = 9;
        long maxSum = 10;
        long minSum = 0;
        int[] digits = new int[1];
        List<Long> armstrongNumbers = new ArrayList<>();
        app.fillListWithArmstrongNumbers(index, previousDigit, maxSum, minSum, digits, armstrongNumbers);
        assertThat(armstrongNumbers)
                .hasSize(10)
                .contains(0L)
                .contains(1L)
                .contains(2L)
                .contains(3L)
                .contains(4L)
                .contains(5L)
                .contains(6L)
                .contains(7L)
                .contains(8L)
                .contains(9L);
    }

    @Test
    public void testFillListWithArmstrongNumbers_TwoDigitNumbers_ZeroArmstrongNumbers() {
        int index = 0;
        int previousDigit = 9;
        long maxSum = 100L;
        long minSum = 10L;
        int[] digits = new int[2];
        List<Long> armstrongNumbers = new ArrayList<>();
        app.fillListWithArmstrongNumbers(index, previousDigit, maxSum, minSum, digits, armstrongNumbers);
        assertThat(armstrongNumbers)
                .hasSize(0);
    }

    @Test
    public void testFillListWithArmstrongNumbers_ThreeDigitNumbers_FourArmstrongNumbers() {
        int index = 0;
        int previousDigit = 9;
        long maxSum = 1000L;
        long minSum = 100L;
        int[] digits = new int[3];
        List<Long> armstrongNumbers = new ArrayList<>();
        app.fillListWithArmstrongNumbers(index, previousDigit, maxSum, minSum, digits, armstrongNumbers);
        assertThat(armstrongNumbers)
                .hasSize(4)
                .contains(407L)
                .contains(371L)
                .contains(370L)
                .contains(153L);
    }

    @Test
    public void testFillListWithArmstrongNumbers_FourDigitNumbers_ThreeArmstrongNumbers() {
        int index = 0;
        int previousDigit = 9;
        long maxSum = 10000L;
        long minSum = 1000L;
        int[] digits = new int[4];
        List<Long> armstrongNumbers = new ArrayList<>();
        app.fillListWithArmstrongNumbers(index, previousDigit, maxSum, minSum, digits, armstrongNumbers);
        assertThat(armstrongNumbers)
                .hasSize(3)
                .contains(1634L)
                .contains(8208L)
                .contains(9474L);
    }

    @Test
    public void testFillListWithArmstrongNumbers_FiveDigitNumbers_ThreeArmstrongNumbers() {
        int index = 0;
        int previousDigit = 9;
        long maxSum = 100_000L;
        long minSum = 10_000L;
        int[] digits = new int[5];
        List<Long> armstrongNumbers = new ArrayList<>();
        app.fillListWithArmstrongNumbers(index, previousDigit, maxSum, minSum, digits, armstrongNumbers);
        assertThat(armstrongNumbers)
                .hasSize(3)
                .contains(54748L)
                .contains(92727L)
                .contains(93084L);
    }

    @Test
    public void testFillListWithArmstrongNumbers_SixDigitNumbers_OneArmstrongNumber() {
        int index = 0;
        int previousDigit = 9;
        long maxSum = 1_000_000L;
        long minSum = 100_000L;
        int[] digits = new int[6];
        List<Long> armstrongNumbers = new ArrayList<>();
        app.fillListWithArmstrongNumbers(index, previousDigit, maxSum, minSum, digits, armstrongNumbers);
        assertThat(armstrongNumbers)
                .hasSize(1)
                .contains(548834L);
    }

    @Test
    public void testFillListWithArmstrongNumbers_SevenDigitNumbers_FourArmstrongNumbers() {
        int index = 0;
        int previousDigit = 9;
        long maxSum = 10_000_000L;
        long minSum = 1_000_000L;
        int[] digits = new int[7];
        List<Long> armstrongNumbers = new ArrayList<>();
        app.fillListWithArmstrongNumbers(index, previousDigit, maxSum, minSum, digits, armstrongNumbers);
        assertThat(armstrongNumbers)
                .hasSize(4)
                .contains(1741725L)
                .contains(4210818L)
                .contains(9800817L)
                .contains(9926315L);
    }

    @Test
    public void testFillListWithArmstrongNumbers_EightDigitNumbers_ThreeArmstrongNumbers() {
        int index = 0;
        int previousDigit = 9;
        long maxSum = 100_000_000L;
        long minSum = 10_000_000L;
        int[] digits = new int[8];
        List<Long> armstrongNumbers = new ArrayList<>();
        app.fillListWithArmstrongNumbers(index, previousDigit, maxSum, minSum, digits, armstrongNumbers);
        assertThat(armstrongNumbers)
                .hasSize(3)
                .contains(24678050L)
                .contains(24678051L)
                .contains(88593477L);
    }

    @Test
    public void testFillListWithArmstrongNumbers_NineDigitNumbers_FourArmstrongNumbers() {
        int index = 0;
        int previousDigit = 9;
        long maxSum = 1_000_000_000L;
        long minSum = 100_000_000L;
        int[] digits = new int[9];
        List<Long> armstrongNumbers = new ArrayList<>();
        app.fillListWithArmstrongNumbers(index, previousDigit, maxSum, minSum, digits, armstrongNumbers);
        assertThat(armstrongNumbers)
                .hasSize(4)
                .contains(146511208L)
                .contains(472335975L)
                .contains(534494836L)
                .contains(912985153L);
    }

    @Test
    public void testFillListWithArmstrongNumbers_TenDigitNumbers_OneArmstrongNumber() {
        int index = 0;
        int previousDigit = 9;
        long maxSum = 10_000_000_000L;
        long minSum = 1_000_000_000L;
        int[] digits = new int[10];
        List<Long> armstrongNumbers = new ArrayList<>();
        app.fillListWithArmstrongNumbers(index, previousDigit, maxSum, minSum, digits, armstrongNumbers);
        assertThat(armstrongNumbers)
                .hasSize(1)
                .contains(4679307774L);
    }

    @Test
    public void testFillListWithArmstrongNumbers_ElevenDigitNumbers_EightArmstrongNumbers() {
        int index = 0;
        int previousDigit = 9;
        long maxSum = 100_000_000_000L;
        long minSum = 10_000_000_000L;
        int[] digits = new int[11];
        List<Long> armstrongNumbers = new ArrayList<>();
        app.fillListWithArmstrongNumbers(index, previousDigit, maxSum, minSum, digits, armstrongNumbers);
        assertThat(armstrongNumbers)
                .hasSize(8)
                .contains(32164049650L)
                .contains(32164049651L)
                .contains(40028394225L)
                .contains(42678290603L)
                .contains(44708635679L)
                .contains(49388550606L)
                .contains(82693916578L)
                .contains(94204591914L);
    }

    @Test
    public void testFillListWithArmstrongNumbers_TwelveDigitNumbers_ZeroArmstrongNumbers() {
        int index = 0;
        int previousDigit = 9;
        long maxSum = 1_000_000_000_000L;
        long minSum = 100_000_000_000L;
        int[] digits = new int[12];
        List<Long> armstrongNumbers = new ArrayList<>();
        app.fillListWithArmstrongNumbers(index, previousDigit, maxSum, minSum, digits, armstrongNumbers);
        assertThat(armstrongNumbers)
                .hasSize(0);
    }

    @Test
    public void testFillListWithArmstrongNumbers_ThirteenDigitNumbers_ZeroArmstrongNumbers() {
        int index = 0;
        int previousDigit = 9;
        long maxSum = 10_000_000_000_000L;
        long minSum = 1_000_000_000_000L;
        int[] digits = new int[13];
        List<Long> armstrongNumbers = new ArrayList<>();
        app.fillListWithArmstrongNumbers(index, previousDigit, maxSum, minSum, digits, armstrongNumbers);
        assertThat(armstrongNumbers)
                .hasSize(0);
    }

    @Test
    public void testFillListWithArmstrongNumbers_FourteenDigitNumbers_OneArmstrongNumber() {
        int index = 0;
        int previousDigit = 9;
        long maxSum = 100_000_000_000_000L;
        long minSum = 10_000_000_000_000L;
        int[] digits = new int[14];
        List<Long> armstrongNumbers = new ArrayList<>();
        app.fillListWithArmstrongNumbers(index, previousDigit, maxSum, minSum, digits, armstrongNumbers);
        assertThat(armstrongNumbers)
                .hasSize(1)
                .contains(28116440335967L);
    }

    @Test
    public void testFillListWithArmstrongNumbers_FifteenDigitNumbers_ZeroArmstrongNumber() {
        int index = 0;
        int previousDigit = 9;
        long maxSum = 1_000_000_000_000_000L;
        long minSum = 100_000_000_000_000L;
        int[] digits = new int[15];
        List<Long> armstrongNumbers = new ArrayList<>();
        app.fillListWithArmstrongNumbers(index, previousDigit, maxSum, minSum, digits, armstrongNumbers);
        assertThat(armstrongNumbers)
                .hasSize(0);
    }

    @Test
    public void testFillListWithArmstrongNumbers_SixteenDigitNumbers_TwoArmstrongNumbers() {
        int index = 0;
        int previousDigit = 9;
        long maxSum = 10_000_000_000_000_000L;
        long minSum = 1_000_000_000_000_000L;
        int[] digits = new int[16];
        List<Long> armstrongNumbers = new ArrayList<>();
        app.fillListWithArmstrongNumbers(index, previousDigit, maxSum, minSum, digits, armstrongNumbers);
        assertThat(armstrongNumbers)
                .hasSize(2)
                .contains(4338281769391370L)
                .contains(4338281769391371L);
    }

    @Test
    public void testFillListWithArmstrongNumbers_SeventeenDigitNumbers_ThreeArmstrongNumbers() {
        int index = 0;
        int previousDigit = 9;
        long maxSum = 100_000_000_000_000_000L;
        long minSum = 10_000_000_000_000_000L;
        int[] digits = new int[17];
        List<Long> armstrongNumbers = new ArrayList<>();
        app.fillListWithArmstrongNumbers(index, previousDigit, maxSum, minSum, digits, armstrongNumbers);
        assertThat(armstrongNumbers)
                .hasSize(3)
                .contains(21897142587612075L)
                .contains(35641594208964132L)
                .contains(35875699062250035L);
    }

    @Test
    public void testFillListWithArmstrongNumbers_EighteenDigitNumbers_ZeroArmstrongNumbers() {
        int index = 0;
        int previousDigit = 9;
        long maxSum = 1_000_000_000_000_000_000L;
        long minSum = 100_000_000_000_000_000L;
        int[] digits = new int[18];
        List<Long> armstrongNumbers = new ArrayList<>();
        app.fillListWithArmstrongNumbers(index, previousDigit, maxSum, minSum, digits, armstrongNumbers);
        assertThat(armstrongNumbers)
                .hasSize(0);
    }

    @Test
    public void testFillListWithArmstrongNumbers_NineteenDigitNumbers_FourArmstrongNumbers() {
        int index = 0;
        int previousDigit = 9;
        long maxSum = Long.MAX_VALUE;
        long minSum = 1_000_000_000_000_000_000L;
        int[] digits = new int[19];
        List<Long> armstrongNumbers = new ArrayList<>();
        app.fillListWithArmstrongNumbers(index, previousDigit, maxSum, minSum, digits, armstrongNumbers);
        assertThat(armstrongNumbers)
                .hasSize(4)
                .contains(1517841543307505039L)
                .contains(3289582984443187032L)
                .contains(4498128791164624869L)
                .contains(4929273885928088826L);
    }

//    @Test
//    public void testFillListWithArmstrongNumbersUntil_FirstEighteenDigitNumbers_FortySevenArmstrongNumber() {
//        List<Long> armstrongNumbers = new ArrayList<>();
//        app.fillListWithArmstrongNumbersUntil(1_000_000_000_000_000_000L, armstrongNumbers);
//        assertThat(armstrongNumbers.size()).isEqualTo(47);
//    }
}