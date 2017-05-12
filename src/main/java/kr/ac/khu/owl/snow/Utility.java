package kr.ac.khu.owl.snow;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import kr.ac.khu.owl.snow.graph.Vertex;

public class Utility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	// breadth-first search from a single source
	public static void bfs(Vertex rootNode, int s) {
		// BFS uses Queue data structure
	    Queue<Vertex> queue = new LinkedList<Vertex>();
	    queue.add(rootNode);
	    System.out.println(rootNode);
	    rootNode.setVisited(true);
	    while(!queue.isEmpty()) {
	        Vertex node = queue.remove();
	        Vertex child=null;
	        while((child=getNextNeighbour(node))!=null) {
	            child.setVisited(true);
	            System.out.println(child);
	            queue.add(child);
	        }
	    }
	    // Clear visited property of nodes
	    //clearNodes();
	}
	
	private static Vertex getNextNeighbour(Vertex v) {
		List<Vertex> neighbours = v.getNeighbours();
		for(Vertex neighbour : neighbours) {
			if(!neighbour.isVisited())
				return neighbour;
		}
		return null;
	}
}
