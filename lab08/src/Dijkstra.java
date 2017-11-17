package src;

import java.util.PriorityQueue;
import java.util.ArrayList;

// Algoritmo de Dijkstra
public class Dijkstra {
	final Graph g; 
	final int n; 
	final int source; 
	final int dest;
        final int[] dist;
        final int[] pred;
        final boolean[] settled;
        final PriorityQueue<Node> S;
	Fenetre f; 

	// construtor
	Dijkstra(Graph g, int source, int dest) {
		this.g = g;
		n = g.n;
		this.source = source;
		this.dest = dest;
                
                dist = new int[n];
                pred = new int[n];
                settled = new boolean[n];
                S = new PriorityQueue<>();
                
                pred[source] = source;
                settled[source] = false;
	}
	
	// atualizacao da distancia, da prioridade, e do predecessor de um no
	void update(int y, int x) {
		throw new Error("para completer");
	}
	
	// retorna o próximo nó a ser acomodado
	int nextNode() {
		throw new Error("para completer");
	}
	
	// uma etapa do algoritmo de Dijkstra
	int oneStep() {
		throw new Error("para completar");
	}
	
	// algoritmo de Dijsktra completo
	int compute() {
		throw new Error("para completar");
	}
	
	// desacelera o visualizador
	void slow(){
	    if(f == null) return;
	    try {
	        Thread.sleep(5);
	    } catch (InterruptedException e) {}
	}
}
