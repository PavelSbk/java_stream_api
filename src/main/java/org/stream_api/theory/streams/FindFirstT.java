package org.stream_api.theory.streams;

import java.util.Arrays;

/**
 * findFirst - вернет  вернёт объект типа Optional, соответствующий условию, который стоит первым
 * >>> collection.stream().findFirst().orElse("10")
 */

public class FindFirstT {

    public static void main(String[] args) {
        int[] arr = {1,5,16,77,89,21};
        Arrays.stream(arr).findFirst();
        System.out.println(Arrays.stream(arr).findFirst().getAsInt());
    }
}
