package com.revature;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * We generate a queue to traverse through the graph
 * put the 1st node into the queue
 * we repeatedly extract that node and put its neighbors into the queue
 *
 */
public class BreadthFirstSearch {

	private Queue<Node> queue;
	static ArrayList<Node> node = new ArrayList<Node>();
	
	public BreadthFirstSearch() {
		super();
		queue = new LinkedList<Node>();
	}
	
	public void bfs(Node node) {
		// insert the root node into the queue that belongs to this object
		queue.add(node);
		
		// set the node passed through as visited
		node.visited = true;
		
		while(!queue.isEmpty()) {
			
			// pop the head off the queue and print it out
			Node element = queue.remove();
			System.out.println(element.data + ", ");
			
			//find out the neighbors of the element we just popped off
			List<Node> neighbors = element.getNeighbors();
			
			//iterate through the list of neighbors, check if they've been visited and if not, we add them to the queue
			for(int i=0; i < neighbors.size(); i++) {
				Node n = neighbors.get(i);
				// check if its visited is true or false
				if(n!= null && !n.visited) {
					queue.add(n);
					n.visited = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// Build a representation of the graph in the image
		Node node40 = new Node(40);
		Node node10 = new Node(10);
		Node node20 = new Node(20);
		Node node30 = new Node(30);
		Node node60 = new Node(60);
		Node node70 = new Node(70);
		Node node50 = new Node(50);

		node40.addNeighbors(node10);
		node40.addNeighbors(node20);
		node10.addNeighbors(node30);
		node20.addNeighbors(node10);
		node20.addNeighbors(node30);
		node20.addNeighbors(node60);
		node20.addNeighbors(node50);
		node30.addNeighbors(node60);
		node60.addNeighbors(node70);
		node50.addNeighbors(node70);
		
		// We have to instanciate the above class in the main method 
		BreadthFirstSearch bfsExample = new BreadthFirstSearch();
		
		bfsExample.bfs(node40);
	}
	
}
