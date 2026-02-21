package com.messie.trainoptimizer;

import com.messie.trainoptimizer.graph.DijkstraService;
import com.messie.trainoptimizer.graph.Graph;
import com.messie.trainoptimizer.model.Station;
import com.messie.trainoptimizer.data.TrainDataLoader;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Graph graph = TrainDataLoader.loadSampleGraph();
        DijkstraService dijkstra = new DijkstraService();
        Map<Station, Integer> distances = dijkstra.shortestPath(graph, new Station("Colombo Fort"));

        distances.forEach((station, distance) ->
                System.out.println("Colombo -> " + station + " : " + distance + " minutes"));
    }
}