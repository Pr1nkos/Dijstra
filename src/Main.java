import enums.Nodes;

import java.util.HashMap;



public class Main {
    public static void main(String[] args) {

        HashMap<String, HashMap<String, Integer>> tableOfNodes = Dijkstra.generateGraf();
        System.out.println("Граф: " + tableOfNodes);

        HashMap<String, Integer> costs = utils.copyCostsOfNodes(tableOfNodes);
        HashMap<String, String> parents = utils.getParentsOfGraf(costs, tableOfNodes);


        System.out.println("Стоимость узлов: " + costs);
        System.out.println("Родительские узлы: " + parents);

        System.out.println("Кратчайший путь от " + Nodes.START + " до " + Nodes.FINISH + ":");
        utils.printPath(parents, Nodes.FINISH.toString());
        System.out.println("Общая стоимость: " + costs.get(Nodes.FINISH.toString()));

    }


}
