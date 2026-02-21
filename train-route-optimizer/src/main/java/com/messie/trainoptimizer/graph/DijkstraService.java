package com.messie.trainoptimizer.graph;

import com.messie.trainoptimizer.model.Connection;
import com.messie.trainoptimizer.model.Station;
import java.util.*;

public class DijkstraService {

    public Map<Station, Integer> shortestPath(Graph graph, Station source) {
        Map<Station, Integer> distances = new HashMap<>();
        Map<Station, Station> previous = new HashMap<>();
        PriorityQueue<StationDistance> pq = new PriorityQueue<>(Comparator.comparingInt(sd -> sd.distance));

        for (Station station : graph.getAdjacencyList().keySet()) {
            distances.put(station, Integer.MAX_VALUE);
        }

        distances.put(source, 0);
        pq.add(new StationDistance(source, 0));

        while (!pq.isEmpty()) {
            StationDistance current = pq.poll();
            Station currentStation = current.station;

            for (Connection connection : graph.getAdjacencyList().get(currentStation)) {
                Station neighbor = connection.getDestination();
                int newDist = distances.get(currentStation) + connection.getDuration();

                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    previous.put(neighbor, currentStation);
                    pq.add(new StationDistance(neighbor, newDist));
                }
            }
        }

        return distances;
    }

    private static class StationDistance {
        Station station;
        int distance;
        StationDistance(Station station, int distance) {
            this.station = station;
            this.distance = distance;
        }
    }
}