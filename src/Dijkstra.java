import enums.Nodes;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class Dijkstra {
    private Dijkstra (){}
    static Random rand = new Random();
    public static HashMap<String, HashMap<String, Integer>> generateGraf() {
        HashMap<String, HashMap<String, Integer>> tableOfNodes = new HashMap<>();

        HashMap<String, Integer> innerMapStart = new HashMap<>();
        innerMapStart.put(Nodes.B.toString(), rand.nextInt(10));
        innerMapStart.put(Nodes.C.toString(), rand.nextInt(10));

        HashMap<String, Integer> innerMapB = new HashMap<>();
        innerMapB.put(Nodes.D.toString(), rand.nextInt(10));
        innerMapB.put(Nodes.E.toString(), rand.nextInt(10));

        HashMap<String, Integer> innerMapC = new HashMap<>();
        innerMapC.put(Nodes.B.toString(), rand.nextInt(10));
        innerMapC.put(Nodes.D.toString(), rand.nextInt(10));
        innerMapC.put(Nodes.E.toString(), rand.nextInt(10));

        HashMap<String, Integer> innerMapD = new HashMap<>();
        innerMapD.put(Nodes.FINISH.toString(), rand.nextInt(10));
        innerMapD.put(Nodes.E.toString(), rand.nextInt(10));

        HashMap<String, Integer> innerMapE = new HashMap<>();
        innerMapE.put(Nodes.FINISH.toString(), rand.nextInt(10));
        innerMapE.put(Nodes.D.toString(), rand.nextInt(10));

        tableOfNodes.put(Nodes.START.toString(), innerMapStart);
        tableOfNodes.put(Nodes.B.toString(), innerMapB);
        tableOfNodes.put(Nodes.C.toString(), innerMapC);
        tableOfNodes.put(Nodes.D.toString(), innerMapD);
        tableOfNodes.put(Nodes.E.toString(), innerMapE);
        tableOfNodes.put(Nodes.FINISH.toString(), null);

        return tableOfNodes;
    }

    public static String findLowestNode(HashMap<String, Integer> costs, Set<String> processed) {
        Integer lowestCost = Integer.MAX_VALUE;
        String lowestNode = null;

        for (String node : costs.keySet()) {
            Integer cost = costs.get(node);
            if (cost < lowestCost && !processed.contains(node)) {
                lowestCost = cost;
                lowestNode = node;
            }
        }
        return lowestNode;
    }


}
