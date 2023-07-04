package com.venkat.coderpad;

public class GolfBallCapacity {
	public static void main(String[] args) {
        double busLength = 10.0; // meters
        double busWidth = 2.5; // meters
        double busHeight = 2.5; // meters

        double availableVolume = busLength * busWidth * busHeight * 0.7; // assuming 70% of the total volume is available

        double golfBallDiameter = 4.3; // centimeters
        double golfBallRadius = golfBallDiameter / 2.0 / 100.0; // meters

        double golfBallVolume = (4.0 / 3.0) * Math.PI * Math.pow(golfBallRadius, 3);

        int numberOfGolfBalls = (int) (availableVolume / golfBallVolume);

        System.out.println("Number of golf balls that can fit in a school bus: " + numberOfGolfBalls);
    }
}
