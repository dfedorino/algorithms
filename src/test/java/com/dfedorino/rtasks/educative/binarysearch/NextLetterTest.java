package com.dfedorino.rtasks.educative.binarysearch;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NextLetterTest {
    private final NextLetter nextLetter = new NextLetter();

    @Test
    void example1() {
        char[] letters = {'a', 'c', 'f', 'h'};
        char key = 'f';
        assertThat(nextLetter.searchNextLetter(letters, key)).isEqualTo('h');
    }

    @Test
    void example2() {
        char[] letters = {'a', 'c', 'f', 'h'};
        char key = 'b';
        assertThat(nextLetter.searchNextLetter(letters, key)).isEqualTo('c');
    }

    @Test
    void example3() {
        char[] letters = {'a', 'c', 'f', 'h'};
        char key = 'm';
        assertThat(nextLetter.searchNextLetter(letters, key)).isEqualTo('a');
    }

    @Test
    void example4() {
        char[] letters = {'a', 'c', 'f', 'h'};
        char key = 'h';
        assertThat(nextLetter.searchNextLetter(letters, key)).isEqualTo('a');
    }
}