package kr.ac.khu.owl.snow.graph;

import java.util.ArrayList;
import java.util.List;

public class SnowOwl {
	
	private List<Vertex> vertices = new ArrayList<Vertex>();
	private List<Edge> edges = new ArrayList<Edge>();
	
	/**
	 * adds edge either directed or undirected
	 * <p>
	 * 
	 * @param e
	 * @param directed
	 */
	public void addEdge(Edge e, boolean directed) {
		edges.add(e);
		e.getSource().neighbours.add(e.getTarget());
		e.getTarget().neighbours.add(e.getSource());
		if(!directed)
			edges.add(new Edge(e.getTarget(), e.getSource()));
	}
	
	public boolean removeEdge(Edge e) {
		return false;
	}
	public boolean removeVertex(Vertex v) {
		return false;
	}

	public List<Vertex> getVertices() {
		return vertices;
	}

	public void setVertices(List<Vertex> vertices) {
		this.vertices = vertices;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	public int getNumberOfEdges() {
		return this.edges.size();
	}
	public int getNumberOfVertices() {
		return this.vertices.size();
	}
}