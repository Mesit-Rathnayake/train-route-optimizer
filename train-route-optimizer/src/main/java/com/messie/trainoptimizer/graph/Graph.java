package com.messie.trainoptimizer.graph;

import com.messie.trainoptimizer.model.Connection;
import com.messie.trainoptimizer.model.Station;
import java.util.*;

public class Graph {

    private Map<Station, List<Connection>> adjacencyList = new HashMap<>();

    public void addStation(Station station) {
        adjacencyList.putIfAbsent(station, new ArrayList<>());
    }

    public void addConnection(Station from, Station to, int duration) {
        adjacencyList.get(from).add(new Connection(to, duration));
        adjacencyList.get(to).add(new Connection(from, duration)); // bidirectional
    }

    public Map<Station, List<Connection>> getAdjacencyList() {
        return adjacencyList;
    }
}