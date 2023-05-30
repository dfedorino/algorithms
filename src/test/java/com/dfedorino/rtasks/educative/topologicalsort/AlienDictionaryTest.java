package com.dfedorino.rtasks.educative.topologicalsort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AlienDictionaryTest {
    private final AlienDictionary alienDictionary = new AlienDictionary();
    @Test
    void shouldReturnExpectedOrderExample1() {
        String[] words = {"ba", "bc", "ac", "cab"};
        assertThat(alienDictionary.findOrder(words)).isEqualTo("bac");
    }

    @Test
    void shouldReturnExpectedOrderExample2() {
        String[] words = {"cab", "aaa", "aab"};
        assertThat(alienDictionary.findOrder(words)).isEqualTo("cab");
    }

    @Test
    void shouldReturnExpectedOrderExample3() {
        String[] words = {"ywx", "wz", "xww", "xz", "zyy", "zwz"};
        assertThat(alienDictionary.findOrder(words)).isEqualTo("ywxz");
    }

}