
package Heuristica;

public class Heuristica {

    public static void main(String[] args) {
        System.out.println("Resultados do arquivo si535.tsp : \n");
        int[][] matAdj = CriaMatriz.extrairMatrizDeAdjacencia("_si535.tsp.txt", 535, 1);
        HeuristicaPrim h = new HeuristicaPrim(matAdj, 535);
        h.calculaCaminho();
        
        System.out.println("---------------------------------------------------------------------");
        
        System.out.println("Resultados do arquivo pa561.tsp : \n");
        matAdj = CriaMatriz.extrairMatrizDeAdjacencia("_pa561.tsp.txt", 561, 0);
        h = new HeuristicaPrim(matAdj, 561);
        h.calculaCaminho();
        
        System.out.println("---------------------------------------------------------------------");
        
        System.out.println("Resultados do arquivo si1032.tsp : \n");
        matAdj = CriaMatriz.extrairMatrizDeAdjacencia("_si1032.tsp.txt", 1032, 1);
        h = new HeuristicaPrim(matAdj, 1032);
        h.calculaCaminho();
    }
    
}
