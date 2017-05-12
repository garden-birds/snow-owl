package kr.ac.khu.owl.snow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;

import kr.ac.khu.owl.snow.graph.SuperOwl.TYPE;
import kr.ac.khu.owl.snow.graph.Vertex;

public class BreadthFirstIterator<T> implements Iterator<T> {
    private Set<T> visited = new HashSet<>();
    private Queue<T> queue = new LinkedList<>();
    private Graph<T> graph;

    public BreadthFirstIterator(Graph<T> g, T startingVertex) {
        if(g.isVertexExist(startingVertex)) {
            this.graph = g;
            this.queue.add(startingVertex);
            this.visited.add(startingVertex);
        }else{
            throw new IllegalArgumentException("Vertext does not exits");
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasNext() {
        return !this.queue.isEmpty();
    }

    @Override
    public T next() {
        if(!hasNext())
            throw new NoSuchElementException();
        //removes from front of queue
        T next = queue.remove();
        for (T neighbor : this.graph.getNeighbors(next)) {
            if (!this.visited.contains(neighbor)) {
                this.queue.add(neighbor);
                this.visited.add(neighbor);
            }
        }
        return next;
    }

    public static void main(String[] args) {
    	Vertex v1 = new Vertex(1, TYPE.Manufacturer.name(), "Sony");
		Vertex v2 = new Vertex(2, TYPE.Manufacturer.name(), "Bose");
		Vertex v3 = new Vertex(3, TYPE.Manufacturer.name(), "Bose electronics");
		Vertex v4 = new Vertex(4, TYPE.Manufacturer.name(), "Bosch");
		Vertex v5 = new Vertex(5, TYPE.Product.name(), "Product 1");
		Vertex v6 = new Vertex(6, TYPE.Product.name(), "Product 2");
		Vertex v7 = new Vertex(7, TYPE.Product.name(), "Product 3");
		Vertex v8 = new Vertex(8, TYPE.Product.name(), "Product 4");
		Vertex v9 = new Vertex(9, TYPE.Product.name(), "Product 5");
		Vertex v10 = new Vertex(10, TYPE.Price.name(), "292");
		Vertex v11 = new Vertex(11, TYPE.Price.name(), "299");
		Vertex v12 = new Vertex(12, TYPE.Price.name(), "229");
		Vertex v13 = new Vertex(13, TYPE.Price.name(), "599");
		Vertex v14 = new Vertex(14, TYPE.Description.name(), "Noise Cancelling Headphones");
		Vertex v15 = new Vertex(15, TYPE.Description.name(), "Premium Noise Cancelling Headphones");
		Vertex v16 = new Vertex(16, TYPE.Description.name(), "Bose Noise Cancelling Headphones");
		Vertex v17 = new Vertex(17, TYPE.Description.name(), "Quite Comfort 25 Noise Cancelling Headphones");
		Vertex v18 = new Vertex(18, TYPE.Description.name(), "Dish Washer");	
		
		Graph<Vertex> snowOwl = new Graph<>();
		//. product to manufacturer 
		snowOwl.addEdge(v1, v5, false);
		snowOwl.addEdge(v1, v6, false);
		snowOwl.addEdge(v2, v8, false);
		snowOwl.addEdge(v3, v9, false);
		snowOwl.addEdge(v4, v7, false);
		
		//. product to description
		snowOwl.addEdge(v5, v14, false);
		snowOwl.addEdge(v6, v15, false);
		snowOwl.addEdge(v8, v16, false);
		snowOwl.addEdge(v9, v17, false);
		snowOwl.addEdge(v7, v18, false);
		
		//. product to price
		snowOwl.addEdge(v6, v10, false);
		snowOwl.addEdge(v8, v11, false);
		snowOwl.addEdge(v8, v12, false);
		snowOwl.addEdge(v9, v11, false);
		snowOwl.addEdge(v7, v13, false);
        
		List<Vertex> representatives = new ArrayList<>();
		representatives.addAll(Arrays.asList(v1, v5, v10, v14));
        DepthFirstIterator<Vertex> dfs = null; 
        
        for(Vertex t : representatives) {
        	dfs = new DepthFirstIterator<>(snowOwl,t);
	        while (dfs.hasNext()){
	            System.out.println(dfs.next());
	        }
        }
    }
}