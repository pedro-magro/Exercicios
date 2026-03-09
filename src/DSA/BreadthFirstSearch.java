package DSA;

import java.util.*;

public class BreadthFirstSearch {

    public Boolean FindNearestWay(HashMap<String, List<String>> graph){

        int counter = 0;
        Queue<String> fila = new ArrayDeque<>(graph.get("eu"));

        Set<String> verificado =new HashSet<>();

        while(!fila.isEmpty()){

            String verificando = fila.poll();
            if(verificado.add(verificando)){
                counter++;
                if(verificando.equals("Rodolfo")){
                    System.out.println("Achamos o alvo: " + verificando + " e o caminho mais curto tem: " + counter + "saltos.");
                    return true;
                }
                else{
                    fila.addAll(graph.get(verificando));
                }
            }

        }
        return false;
    }

    public static void main(String[] args){
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("eu", Arrays.asList("João", "Ana", "Pedro"));
        graph.put("João", Arrays.asList("Cleber", "Marcos"));
        graph.put("Ana", Arrays.asList("Mateus", "Rodolfo"));
        graph.put("Pedro", Arrays.asList("Cristian"));
        graph.put("Cleber", Arrays.asList("Felipe", "Marcos"));
        graph.put("Marcos", Collections.emptyList());
        graph.put("Mateus", Arrays.asList("Rodolfo", "Pedro"));
        graph.put("Rodolfo", Collections.emptyList());
        graph.put("Cristian", Arrays.asList("Felipe"));
        graph.put("Felipe", Collections.emptyList());



    }


}
