package com.messie.trainoptimizer.data;

import com.messie.trainoptimizer.model.Station;
import com.messie.trainoptimizer.graph.Graph;

public class TrainDataLoader {

    public static Graph loadSampleGraph() {
        Graph graph = new Graph();

        Station colombo = new Station("Colombo Fort");
        Station kandy = new Station("Kandy");
        Station galle = new Station("Galle");
        Station badulla = new Station("Badulla");

        graph.addStation(colombo);
        graph.addStation(kandy);
        graph.addStation(galle);
        graph.addStation(badulla);

        graph.addConnection(colombo, kandy, 150);
        graph.addConnection(colombo, galle, 120);
        graph.addConnection(kandy, badulla, 180);

        return graph;
    }
}