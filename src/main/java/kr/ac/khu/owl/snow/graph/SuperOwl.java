package kr.ac.khu.owl.snow.graph;

import java.awt.Window.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import info.debatty.java.stringsimilarity.Levenshtein;
import kr.ac.khu.owl.snow.Utility;

public class SuperOwl {
	public enum TYPE{Manufacturer, Product, Price, Description}
	public double threshold = 0.5;
	
	public static void main_two(String[] args) {
		// TODO Auto-generated method stub
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
		
		SnowOwl snowOwl = new SnowOwl();
		//. product to manufacturer 
		snowOwl.addEdge(new Edge(v1, v5), false);
		snowOwl.addEdge(new Edge(v1, v6), false);
		snowOwl.addEdge(new Edge(v2, v8), false);
		snowOwl.addEdge(new Edge(v3, v9), false);
		snowOwl.addEdge(new Edge(v4, v7), false);
		
		//. product to description
		snowOwl.addEdge(new Edge(v5, v14), false);
		snowOwl.addEdge(new Edge(v6, v15), false);
		snowOwl.addEdge(new Edge(v8, v16), false);
		snowOwl.addEdge(new Edge(v9, v17), false);
		snowOwl.addEdge(new Edge(v7, v18), false);
		
		//. product to price
		snowOwl.addEdge(new Edge(v6, v10), false);
		snowOwl.addEdge(new Edge(v8, v11), false);
		snowOwl.addEdge(new Edge(v8, v12), false);
		snowOwl.addEdge(new Edge(v9, v11), false);
		snowOwl.addEdge(new Edge(v7, v13), false);
		
		Utility.bfs(v1, 1);
	}
	
	public double computeSimilarity(Vertex v1, Vertex v2){
		
		double labelSim = computeContentSim(v1.getLabel(), v2.getLabel());
		double structSim = computeStructuralSim(v1, v2);
		
		return (labelSim + structSim) /2;
	}
	
	
	private double computeContentSim(String n1, String n2) {	
		Levenshtein lv = new Levenshtein();
		double diff = lv.distance(n1, n2);
		double maxLength = n1.length() > n2.length() ? n1.length() : n2.length();
		double sim = ( (maxLength - diff) / maxLength ) * 100;
		
		return	sim;
	}

	private double computeStructuralSim(Vertex v1, Vertex v2) {
		int total = v1.getNeighbours().size() + v2.getNeighbours().size();
		List<Vertex> intersection = new ArrayList<Vertex>(v1.getNeighbours());
		intersection.retainAll(v2.getNeighbours());
		double union = total - intersection.size();
		return ((double) intersection.size()/union);
	}

	public static void main(String[] args){
		List<TYPE> types = new ArrayList<TYPE>(Arrays.asList(TYPE.Manufacturer, TYPE.Product, TYPE.Description, TYPE.Price));
		SnowOwl snowOwl = new SnowOwl();
		
		for(TYPE t : types){
			List<Vertex> tTypeVertices = snowOwl.getTypeVertices(t.name());
			double numClusters = summarize(tTypeVertices);
		}
	}

	private static double summarize(List<Vertex> tTypeVertices) {
		//for()
		return 0;
	}
}
