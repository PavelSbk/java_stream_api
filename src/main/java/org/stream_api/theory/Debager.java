package org.stream_api.theory;

import java.util.Map;

public class Debager {

    private static int currentRandomValue = 377;

    public static void main(String[] args) {
        ex3();
    }

    private static void ex2() {
        int value1;
        int value2;
        value1 = randomValue(100);
        value2 = randomValue(100);
        System.out.println("Two random values: " + value1 + ", " + value2);
    }

    private static void ex3() {
        boolean firstAppLaunch = true;
        boolean tableIsNotEmpty = false;
        boolean isConnected = true;

        if (firstAppLaunch && tableIsNotEmpty && isConnected) {
            System.out.println("Loading data...");
        } else {
            System.out.println("data loaded.");
        }
    }

    private static int randomValue(int maxValue) {
        currentRandomValue = currentRandomValue * 1103515245 + 12345;
        return Math.abs(currentRandomValue * 65536) % (maxValue + 1);
    }
}
