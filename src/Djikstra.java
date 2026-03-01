import java.util.*;

public class Djikstra{
// Usamos UM HashMap para implementar grafos, chave é o nome, valor é a lista de vizinhos

    class Graph {
        Map<String, List<Edge>> graph = new HashMap<>();

        public Graph(String g, List<Edge> neighboors){
            this.graph.put(g, neighboors);
        }
    }
// Criamos a representação de aresta onde um grafo encontra outro e colocamos o peso que sera usado para calcular a distancia.
    class Edge {
        String neighboor;
        int weight;

        public Edge(String n, int w){
            this.neighboor = n;
            this.weight = w;
        }
    }
// implementamos o comparable para que a lista de prioridade saiba ordenar os nos corretamente,
// essa classe serve para calcular a distancia geral, não é uma representação da estrutura de dados
// apenas uma estrutura auxiliar.

    class Node implements Comparable<Node>{
        String nome;
        int distance;

        public Node(String n, int d){
            this.nome = n;
            this.distance = d;
        }
// comparamos pela distancia, essa sera o parametro para a fila de prioridade.
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
// passamos o grafo completo e o no inicial como parametro.
    public Map<String,Integer> shortestPath(Graph g, String source){
        Map<String, Integer> distance = new HashMap<>();
        PriorityQueue<Node> shortest = new PriorityQueue<>();
        Set<String> visited = new HashSet<>();
// para cada nó no grafo pegamos o nome dos vizinhos e setamos a distancia como o maior numero possível, menos o no inicial.
        for(String v: g.graph.keySet()){
            distance.put(v, Integer.MAX_VALUE);
        }
        distance.put(source, 0);

        shortest.add(new Node(source, 0));
// o no inicial é colocado na fila, e iniciamos o loop, o nó inicial é tirado da fila e verifica se não há loop,
// caso não houver adicionamos na lista de visitado e pegamos cada vizinho, e pegamos a distancia e verificamos
// se a distancia for menor do que a apresentada na discandcia colocamos a distancia e o vizinho no map de distancia,
// e por fim adicionamos o vizinho a fila para ser processado, até que a lista esteja vazia.
        while(!shortest.isEmpty()){

            Node current = shortest.poll();

            if(!visited.contains(current.nome)){
                visited.add(current.nome);
                for(Edge edge: g.graph.getOrDefault(current.nome, Collections.emptyList())){
                    int newDist = distance.get(current.nome) + edge.weight;
                    if(newDist < distance.get(edge.neighboor)){
                        distance.put(edge.neighboor, newDist);
                        shortest.add(new Node(edge.neighboor, newDist));
                    }

                }
            }

        }

        return distance;

    }
}
