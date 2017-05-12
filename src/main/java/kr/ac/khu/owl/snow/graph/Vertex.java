package kr.ac.khu.owl.snow.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	
	private long id;
	private String label;
	private double value;
	private String type;
	
	boolean visited;
	private long cluster;
	List<Vertex> neighbours = new ArrayList<Vertex>();
	
	/**
	 * Instantiates Vertex with the following properties
	 * <p>
	 * 
	 * @param id
	 * @param type
	 * @param label
	 */
	public Vertex(long id, String type, String label) {
		this.id = id;
		this.type = type;
		this.label = label;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public List<Vertex> getNeighbours() {
		return neighbours;
	}
	public void setNeighbours(List<Vertex> neighbours) {
		this.neighbours = neighbours;
	}
	public long getCluster() {
		return cluster;
	}
	public void setCluster(long cluster) {
		this.cluster = cluster;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vertex [id=" + id + ", label=" + label + ", value=" + value + ", type=" + type + ", visited=" + visited
				+ ", cluster=" + cluster + ", neighbours=" + neighbours.size() + "]";
	}
	
	
	
	
}
