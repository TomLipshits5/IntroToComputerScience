package com;

import Graphs.*;
import Interfaces.*;


public class Main {
    public static void main(String[] args) {
        Graph gr = new GraphAsAdjacencyMatrix(4);
        gr.addEdge(1,0);
        gr.addEdge(1,3);
        gr.addEdge(2,0);
        gr.addEdge(1,3);
        gr.addEdge(2,3);
//        gr.addEdge(2,0);
//        gr.addEdge(3,0);

        GraphAlgorithm con = new FindPathAlgorithm(gr,0,3);
//        Graph connecting = (Graph)con.runAlgorithm();
//        System.out.println(gr);
//        System.out.println(connecting);
        System.out.println((List<Integer>)con.runAlgorithm());


    }


}


