package binary_search;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class logistics {

    public static boolean canAllocate(Integer[] itemWeights, int maxCapacity, int numVehicles) {
        Integer[] sortedWeights = itemWeights.clone();
        Arrays.sort(sortedWeights, Collections.reverseOrder());
        int[] vehicles = new int[numVehicles];

        for (int weight : sortedWeights) {
            if (weight > maxCapacity) {
                return false;
            }

            int minRemaining = Integer.MAX_VALUE;
            int bestIdx = -1;
            for (int i = 0; i < numVehicles; i++) {
                int remaining = maxCapacity - vehicles[i];
                if (remaining >= weight && remaining < minRemaining) {
                    minRemaining = remaining;
                    bestIdx = i;
                }
            }

            if (bestIdx == -1) {
                return false;
            }

            vehicles[bestIdx] += weight;
        }

        return true;
    }

    public static void findMinMaxCapacity() {
        Scanner scanner = new Scanner(System.in);
        int numItems = scanner.nextInt();
        int numVehicles = scanner.nextInt();
        Integer[] weights = new Integer[numItems];

        for (int i = 0; i < numItems; i++) {
            weights[i] = scanner.nextInt();
        }

        int lowerBound = Arrays.stream(weights).max(Integer::compare).get();
        int upperBound = Arrays.stream(weights).mapToInt(Integer::intValue).sum();
        int bestResult = upperBound;

        while (lowerBound <= upperBound) {
            int midValue = (lowerBound + upperBound) / 2;
            if (canAllocate(weights, midValue, numVehicles)) {
                bestResult = midValue;
                upperBound = midValue - 1;
            } else {
                lowerBound = midValue + 1;
            }
        }

        System.out.println(bestResult);
    }

    public static void main(String[] args) {
        findMinMaxCapacity();
    }
}