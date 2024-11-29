/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package kauan.jogodavelha;

/**
 *
 * @author Kauan
 */

import java.util.Scanner;

public class JogoDaVelha {

    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro(); // Instancia o tabuleiro
        Jogador jogadorX = new Jogador('X');
        Jogador jogadorO = new Jogador('O');
        
        Scanner scanner = new Scanner(System.in);
        boolean vencedor = false;
        int jogadas = 0;
        Jogador jogadorAtual = jogadorX;
        
        System.out.println("  ######## JOGO DA VELHA ########");
        
        while (!vencedor && jogadas <9) {
            tabuleiro.exibir();
            System.out.println("Vez do jogador " + jogadorAtual.getSimbolo());
            int linha, coluna;
            
            // Validação da jogada
            while (true) {
                System.out.println("Digite a linha (0-2): ");
                linha = scanner.nextInt();
                System.out.println("Digite a coluna (0-2): ");
                coluna = scanner.nextInt();
                
                if (tabuleiro.jogadaValida(linha, coluna)) {
                    break;
                } else {
                    System.out.println("Jogada invalida! Tente novamente.");                    
                }
            }
            
            // Realiza a jogada
            tabuleiro.realizarJogada(linha, coluna, jogadorAtual.getSimbolo());
            jogadas++;
            
            // Verifica se há vencedor
            if (tabuleiro.verificarVencedor(jogadorAtual.getSimbolo())) {
                vencedor = true;
                tabuleiro.exibir();
                System.out.println("Parabens! O Jogador " + jogadorAtual.getSimbolo() + " venceu!");
            } else if (jogadas == 9) {
                tabuleiro.exibir();
                System.out.println("Empate! Nenhum jogador venceu.");
            }
            
            // Alterna o jogador
            jogadorAtual = (jogadorAtual == jogadorX) ? jogadorO : jogadorX;
        }
        
        scanner.close();
    }
}
