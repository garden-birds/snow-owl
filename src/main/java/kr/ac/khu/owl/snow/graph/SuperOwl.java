package kr.ac.khu.owl.snow.graph;

import kr.ac.khu.owl.snow.Utility;

public class SuperOwl {
	enum TYPE{Manufacturer, Product, Price, Description}
	public static void main(String[] args) {
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
		snowOwl.addEdge(new Edge(v2, v9), false);
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

}
