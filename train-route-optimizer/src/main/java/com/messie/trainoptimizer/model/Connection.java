package com.messie.trainoptimizer.model;

public class Connection {

    private Station destination;
    private int duration; // in minutes

    public Connection(Station destination, int duration) {
        this.destination = destination;
        this.duration = duration;
    }

    public Station getDestination() {
        return destination;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "To " + destination + " : " + duration + " min";
    }
}