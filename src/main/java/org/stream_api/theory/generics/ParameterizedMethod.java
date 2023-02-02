package org.stream_api.theory.generics;

import java.util.Arrays;
import java.util.List;

/**
 * Parameterized Methods Это методы у которых в параметрах есть generic
 */

public class ParameterizedMethod {

    public static void main(String[] args) {
        List<Integer> listI = Arrays.asList(1, 23, 3, 4, 5, 6);
        System.out.println(GenMethod.getSecondElement(listI));
        List<String> listS = Arrays.asList("ab", "cd", "ef");
        System.out.println(GenMethod.getSecondElement(listS));
    }
}

class GenMethod {
    /**
     * В параметре - лист данных типа <T>, т.е. любых
     * <T> T это -
     * <T> - означает, что в этом методе используется generic
     * T - возвращаемый тип
     */
    public static <T> T getSecondElement(List<T> al) {
        return al.get(1);
    }
}
