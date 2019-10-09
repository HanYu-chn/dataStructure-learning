/**
 * projectName: dataStructure-Learning
 * fileName: DepthFirstSearch.java
 * packageName: Algorithm.Search
 * date: 2019-10-08 21:54
 * copyright(c) HanYu
 */
package Algorithm.Search;

import java.util.*;

/**
 * @version: V1.0
 * @author: HanYu
 * @className: DepthFirstSearch
 * @packageName: Algorithm.Search
 * @description: 深度优先搜索
 * @data: 2019-10-08 21:54
 **/
public class DepthFirstSearch {
    public static void main(String[] args) {
        Map<Character, LinkedList<Character>> graph = initGraph();
        search(graph,'A');
    }
    /*---------------------------------------分割线-----------------------------------------**/
    public static void search(Map<Character, LinkedList<Character>> graph,Character start) {
        if(graph == null || graph.size() == 0) return;
        HashSet<Character> visited = new HashSet<>();
        search(graph,visited,start);
    }
    /*---------------------------------------分割线-----------------------------------------**/
    private static void search(Map<Character, LinkedList<Character>> graph, HashSet<Character> visited, Character start) {
        if(graph == null || graph.size() == 0 || start == null) return;
        if(visited.contains(start)) return;
        visited.add(start);
        System.out.print(visited.size() == graph.size() ? start : start + "-"); //打印元素,表示遍历到该元素
        LinkedList<Character> neighborList = graph.get(start);
        if(neighborList == null) return;
        for (Character neighbor : neighborList) {
            search(graph,visited,neighbor);
        }
    }

    private static Map<Character, LinkedList<Character>> initGraph() {
        Map<Character, LinkedList<Character>> graph = new HashMap<>();
        //A
        LinkedList<Character> neighborA = new LinkedList<>();
        neighborA.add('B');
        neighborA.add('D');
        graph.put('A',neighborA);

        //B
        LinkedList<Character> neighborB = new LinkedList<>();
        neighborB.add('E');
        neighborB.add('F');
        neighborB.add('C');
        graph.put('B',neighborB);

        //C
        LinkedList<Character> neighborC = new LinkedList<>();
        neighborC.add('B');
        neighborC.add('D');
        neighborC.add('G');
        neighborC.add('H');
        graph.put('C',neighborC);

        //D
        LinkedList<Character> neighborD = new LinkedList<>();
        neighborD.add('A');
        neighborD.add('C');
        neighborD.add('I');
        graph.put('D',neighborD);

        //E
        LinkedList<Character> neighborE = new LinkedList<>();
        neighborE.add('B');
        neighborE.add('F');
        neighborE.add('G');
        graph.put('E',neighborE);

        //F
        LinkedList<Character> neighborF = new LinkedList<>();
        neighborF.add('B');
        neighborF.add('E');
        neighborF.add('G');
        graph.put('F',neighborF);

        //G
        LinkedList<Character> neighborG = new LinkedList<>();
        neighborG.add('E');
        neighborG.add('F');
        neighborG.add('C');
        neighborG.add('H');
        neighborG.add('I');
        graph.put('G',neighborG);

        //H
        LinkedList<Character> neighborH = new LinkedList<>();
        neighborH.add('C');
        neighborH.add('G');
        neighborH.add('I');
        graph.put('H',neighborH);

        //I
        LinkedList<Character> neighborI = new LinkedList<>();
        neighborE.add('D');
        neighborE.add('H');
        neighborE.add('G');
        graph.put('I',neighborI);

        return graph;
    }
}