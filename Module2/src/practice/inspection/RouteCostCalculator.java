package practice.inspection;

import java.util.Random;

public class RouteCostCalculator {
    private static final double TAX_RATE = 1.1;
    private static final double FUEL_PRICE = 22500.0;
    public double calculateRouteCost(double[] distances, double maxBudget) {

        double totalCost = 0;
        System.out.println("Bắt đầu tính toán lộ trình...");
        long startTime = System.currentTimeMillis();

        for (double distance : distances) {
            double stepCost = distance * FUEL_PRICE * TAX_RATE;
            totalCost += stepCost;
            if (totalCost > maxBudget) {
                System.out.println("Không đủ ngân sách");
                long endTime = System.currentTimeMillis();
                System.out.println("Thời gian chạy (Legacy): " + (endTime - startTime) + " ms");
                return -1;
            }

        }
        long endTime = System.currentTimeMillis();
        System.out.println("Thời gian chạy (Legacy): " + (endTime - startTime) + " ms");
        return totalCost;
    }

    public static void main(String[] args) {
        RouteCostCalculator calc = new RouteCostCalculator();
        double[] arr = new double[1_000_000];

        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1 + random.nextDouble() * 4;
        }
        double result = calc.calculateRouteCost(arr, Double.MAX_VALUE);
        System.out.println(result);
    }
}
