
package forcabruta;

import java.util.ArrayList;
import java.util.Random;

public class ForcaBruta {

    private static void imprimirCaminho(ArrayList<ArestaDirecionada> arestasCaminhoCurto) {
		
        if (arestasCaminhoCurto == null) {
                System.err.println("Erro!!");
                return;
        }

        for (int i = 0; i < arestasCaminhoCurto.size(); i++) {
                ArestaDirecionada arestaAtual = arestasCaminhoCurto.get(i);
                System.out.println("\t" + arestaAtual.origem.idenficicacao + " --> " + arestaAtual.destino.idenficicacao
                                + "\tpeso:  " + arestaAtual.peso);
        }
    }
    
    @SuppressWarnings("resource")   //evita avisos de compilação
    public static void main(String[] args) {
        
        // Registra vertices
        ArrayList<Vertice> vertices = new ArrayList<Vertice>();
        for (Integer contadorVertice = 0; contadorVertice < 14; contadorVertice++) {
                vertices.add(new Vertice(contadorVertice.toString()));
        }

        // cria matriz de adjacencia aleatoriamente
        Random random = new Random();
        ArrayList<Integer[][]> matrizesComArestas = new ArrayList<Integer[][]>();
        for (int qtdCidades = 2; qtdCidades <= 14; qtdCidades++) {
                Integer[][] matrizAdjacencia = new Integer[qtdCidades][qtdCidades];

                for (int linha = 0; linha < qtdCidades; linha++) {
                        for (int coluna = 0; coluna < qtdCidades; coluna++) {
                                if (coluna == linha) {
                                        matrizAdjacencia[linha][coluna] = 0;
                                } else {
                                        matrizAdjacencia[linha][coluna] = random.nextInt(999) + 1; // Sempre havera um caminho direto entre duas cidades
                                }
                        }
                }

                matrizesComArestas.add(matrizAdjacencia);
        }

        // Imprime resolucoes
        System.out.println("Respostas:\n");
        for (int indiceMatrizAdjacencia = 0; indiceMatrizAdjacencia < matrizesComArestas.size(); indiceMatrizAdjacencia++) {
                Integer[][] matrizAdjacenciaAtual = matrizesComArestas.get(indiceMatrizAdjacencia);
                System.out.println("Grafo com " + matrizesComArestas.get(indiceMatrizAdjacencia).length + " vértices (cidades):");

                CaixeiroViajante caixeiroViajante = new CaixeiroViajante(new Grafo(matrizAdjacenciaAtual, vertices));

                long inicioDeExecucao = System.currentTimeMillis();
                ForcaBruta.imprimirCaminho(caixeiroViajante.solucaoForcaBruta());
                long tempoFinalDeExecucao = System.currentTimeMillis() - inicioDeExecucao;

                System.out.println("        Tempo de execução: " + tempoFinalDeExecucao + "ms.\n");
        }
        
    }
    
}
