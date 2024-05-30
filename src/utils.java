import enums.Nodes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class utils {
	private utils() {
	}

	static HashMap<String, String> getParentsOfGraf(HashMap<String, Integer> costs,
	                                                HashMap<String, HashMap<String, Integer>> tableOfNodes) {
		String node = Nodes.START.toString();
		HashMap<String, String> parents = new HashMap<>();
		Set<String> processed = new HashSet<>();


		while (node != null) {
			int cost = costs.get(node);
			HashMap<String, Integer> neighbors = tableOfNodes.get(node);
			if (neighbors != null) {
				for (String n : neighbors.keySet()) {
					int newCost = cost + neighbors.get(n);
					if (newCost < costs.get(n)) {
						costs.put(n, newCost);
						parents.put(n, node);
					}
				}
			}
			processed.add(node);
			node = Dijkstra.findLowestNode(costs, processed);
		}
		return parents;
	}

	static HashMap<String, Integer> copyCostsOfNodes(HashMap<String, HashMap<String, Integer>> tableOfNodes) {
		HashMap<String, Integer> costs = new HashMap<>();


		for (String node : tableOfNodes.keySet()) {
			if (node.equals(Nodes.START.toString())) {
				costs.put(node, 0);
			}
			else {
				costs.put(node, Integer.MAX_VALUE);
			}
		}
		return costs;
	}

	static void printPath(HashMap<String, String> parents, String currentNode) {
		if (currentNode == null || !parents.containsKey(currentNode)) {
			return;
		}
		printPath(parents, parents.get(currentNode));
		System.out.print(currentNode + " ");
		System.out.println();
	}
}
