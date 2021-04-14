package com.dfedorino.rtasks.first_level;

public class Snail {
    public int getDays(int distanceToCover, int distancePerDay, int distancePerNight) {
        int days = 1;
        int coveredDistance = distancePerDay;
        while (coveredDistance < distanceToCover) {
            days++;
            coveredDistance += (distancePerDay - distancePerNight);
        }
        return days;
    }
}
