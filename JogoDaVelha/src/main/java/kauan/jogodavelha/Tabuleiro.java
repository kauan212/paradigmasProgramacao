/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kauan.jogodavelha;

/**
 *
 * @author Kauan
 */
public class Tabuleiro {
    private char[][] matriz;
    
    public Tabuleiro() {
        matriz = new char [3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = ' ';
            }
        }
    }
    
    //Exibe o tabuleiro atual
    public void exibir() {
        System.out.println("  _______________________________ ");
        System.out.println(" /          0    1    2           \\ ");
        System.out.println("| == .   _________________   <X>  |  ");
        System.out.println("|       |                 |       |");
        //System.out.println("\n  0   1   2");
        for (int i = 0; i <3; i++) {
            System.out.print("|   " + i + "   |  " + "  ");
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println("    |       |");
            if (i < 2) System.out.println("|       |   -----------   |       |");
        }
        System.out.println("|       |_________________|  <O>  |");
        System.out.println(" \\_______________________________/");
        System.out.println();
    }
    
    // Verifica se a jogada é válida
    public boolean jogadaValida(int linha, int coluna) {
        return linha >= 0 && linha < 3 && coluna >= 0 && coluna <3 && matriz[linha][coluna] == ' ';
    }
    
    // Realiza a jogada no tabuleiro
    public void realizarJogada(int linha, int coluna, char simbolo) {
        matriz[linha][coluna] = simbolo;
    }
    
    // Verifica se há um vencedor
    public boolean verificarVencedor(char simbolo) {
        // Verifica linhas
        for (int i = 0; i < 3; i++) {
            if (matriz[i][0] == simbolo && matriz[i][1] == simbolo && matriz[i][2] == simbolo) {
                return true;
            }
        }
        
        // Verifica colunas
        for (int i = 0; i < 3; i++) {
            if (matriz[0][i] == simbolo && matriz[1][i] == simbolo && matriz[2][i] == simbolo) {
                return true;
            }
        }
        
        // Verifica diagonais
        if (matriz[0][0] == simbolo && matriz[1][1] == simbolo && matriz[2][2] == simbolo) {
            return true;
        }
        if (matriz[0][2] == simbolo && matriz[1][1] == simbolo && matriz[2][0] == simbolo) {
            return true;
        }
        
        return false;
    }
    
}
