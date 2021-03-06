package org.dongjian.jiuzhang.algorithm.medium;

import org.dongjian.jiuzhang.algorithm.common.UndirectedGraphNode;

import java.util.*;

/**
 * Given a undirected graph, a node and a target, return the nearest node to given node which value of it is target, return NULL if you can't find.
 * <p>
 * There is a mapping store the nodes' values in the given parameters.
 * <p>
 * Example
 * 2-----3  5
 * \    |  |
 * \   |  |
 * \  |  |
 * \ |  |
 * 1 --4
 * Give a node 1, target is 50
 * <p>
 * there a hash named values which is [3,4,10,50,50], represent:
 * Value of node 1 is 3
 * Value of node 2 is 4
 * Value of node 3 is 10
 * Value of node 4 is 50
 * Value of node 5 is 50
 * <p>
 * Return node 4
 */
public class SearchGraphNodes_618_M {
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values, UndirectedGraphNode node, int target) {

        if (null == graph || graph.isEmpty()) {
            return null;
        }

        if (null == node) {
            return null;
        }

        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> visitedNodes = new HashSet<UndirectedGraphNode>();
        queue.add(node);
        visitedNodes.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.remove();

            if (values.get(head) == target) {
                return head;
            }

            for (UndirectedGraphNode neighbor : head.neighbors) {
                if (!visitedNodes.contains(neighbor)) {
                    queue.add(neighbor);
                    visitedNodes.add(neighbor);
                }
            }

        }

        return node;

    }
}
