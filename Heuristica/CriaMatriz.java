/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heuristica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CriaMatriz {
    
    public static int[][] extrairMatrizDeAdjacencia(String nomeDoArquivo, int tamanho, int diagonalSuperior) {
        File file = new File(nomeDoArquivo);
        int[][] matrizDeAdjacencia = new int[tamanho][tamanho];
        
        try {
            Scanner scanner = new Scanner(file);      
            while (!scanner.next().equals("EDGE_WEIGHT_SECTION")) {}
            
            int i, j;
            for (i = 0; i < tamanho; i++) {
                if(diagonalSuperior == 0) {                    
                    for (j = 0; j <= i; j++) {
                        matrizDeAdjacencia[i][j] = matrizDeAdjacencia[j][i] = scanner.nextInt();
                    }                    
                } else if(diagonalSuperior == 1){                    
                    for (j = i; j < tamanho; j++) {
                        matrizDeAdjacencia[i][j] = matrizDeAdjacencia[j][i] = scanner.nextInt();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao abrir o arquivo '"+nomeDoArquivo+"'");
        }
        return matrizDeAdjacencia;
    }
    
}
