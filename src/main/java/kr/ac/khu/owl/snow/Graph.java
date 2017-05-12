package kr.ac.khu.owl.snow;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import kr.ac.khu.owl.snow.graph.Edge;

public class Graph<T> {
    private Map<T, Set<T>> map;

    public Graph() {
        map = new HashMap<>();
    }
    
    public Graph addEdge(T src, T destination, boolean directed){
        if(src!=null){
            if(src==destination || src.equals(destination)){
                throw new IllegalArgumentException("Source and Destination can not be same");
            }else{
                Set<T> desitinations = map.get(src);
                if(desitinations==null){
                    desitinations = new HashSet<>();
                }
                if(destination!=null){
                    desitinations.add(destination);
                    Set<T> destinationsOfDestination = map.get(destination);
                    if(destinationsOfDestination==null){
                        map.put(destination, new HashSet<T>());
                    }
                    //destinationsOfDestination.add(src);
                    map.put(destination, destinationsOfDestination);
                }
                map.put(src,desitinations);
            }
        }else{
            throw new IllegalArgumentException("Invalid Source node");
        }
        if(!directed)
        	addEdge(destination, src, true);
        
        return this;
    }

    public Iterable<T> getNeighbors(T vertex) {
        Set<T> neighbors = this.map.get(vertex);
        if (neighbors == null || neighbors.isEmpty()) {
            return Collections.emptySet();
        } else {
            return Collections.unmodifiableSet(neighbors);
        }
    }

    public boolean isVertexExist(T vertex){
        return map.containsKey(vertex);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Graph{");
        sb.append("map=").append(map);
        sb.append('}');
        return sb.toString();
    }
}
