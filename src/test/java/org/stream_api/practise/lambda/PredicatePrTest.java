package org.stream_api.practise.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;

class PredicatePrTest {

    @Test
    public void whenRemoveF() {
        List<String> inputList = new ArrayList<>(List.of(
                "Remove",
                "from",
                "string",
                "by",
                "literal",
                "fast"
        ));
        char inputChar = 0x46;
        List<String> result = PredicatePr.removeBy(inputList, inputChar);
        List<String> expected = new ArrayList<>(List.of(
                "Remove",
                "string",
                "by",
                "literal"
        ));
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void removeWhenArrayHasSBH(){
        List<String> inputList = new ArrayList<>(List.of(
                "Remove",
                "H",
                "from",
                "List",
                "of",
                "string",
                "by",
                "literal",
                "fast"
        ));
        List<String> expected = new ArrayList<>(List.of(
                "Remove",
                "from",
                "List",
                "of",
                "literal",
                "fast"
        ));
        char[] chArrForRemove = {'S', 'b', 'h'};
        List<String> result = PredicatePr.removeByArr(inputList, chArrForRemove);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void removeWhenArrayHasHB(){
        List<String> inputList = new ArrayList<>(List.of(
                "Remove",
                "H",
                "from",
                "List",
                "of",
                "strings",
                "by"
        ));
        List<String> expected = new ArrayList<>(List.of(
                "Remove",
                "from",
                "List",
                "of",
                "strings"
        ));
        char[] chArrForRemove = {'h', 'b'};
        List<String> result = PredicatePr.removeByArr(inputList, chArrForRemove);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void removeWhenLengthIsNotSameAsKey() {
        Map<Integer, String> inputMap = new HashMap<>(Map.of(
                1, "Zz",
                2, "A",
                3, "Aaz",
                4, "Zagz",
                5, "Zag"
        ));
        Map<Integer, String> expected = new HashMap<>(Map.of(
                3, "Aaz",
                4, "Zagz"
        ));
        Map<Integer, String> result = PredicatePr.removeFromMap(inputMap);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void trueWhen1234() {
        int input = 1234;
        boolean result = PredicatePr.numberCheck(input);
        assertThat(result).isTrue();
    }
    @Test
    public void falseWhen12345() {
        int input = 12345;
        boolean result = PredicatePr.numberCheck(input);
        assertThat(result).isFalse();
    }
}