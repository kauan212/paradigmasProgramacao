/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package kauan.bar;

/**
 *
 * @author Kauan
 */

import java.util.Scanner;
public class BarConta {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Entrada de dados
        char sexo = obterSexoValido(sc);
        int qtdCervejas = obterQuantidadeValida(sc, "cervejas");
        int qtdRefrigerantes = obterQuantidadeValida(sc, "refrigerantes");
        int qtdEspetinhos = obterQuantidadeValida (sc, "espetinhos");
        
        // Calcula e exibe o relatório final
        gerarRelatorio(sexo, qtdCervejas, qtdRefrigerantes, qtdEspetinhos);
        
        sc.close();
    }
    
    // Método para obter o sexo válido (F ou M)
    public static char obterSexoValido(Scanner sc) {
        char sexo;
        while (true) {
            System.out.print("Sexo (F ou M): ");
            sexo = Character.toUpperCase(sc.next().charAt(0));
            if (sexo == 'F' || sexo == 'M') {
                break;
            } else {
                System.out.println("Entrada invalida! Informe 'F' ou 'M'.");
            }
        }
        return sexo;
    }
    
    // Método para obter uma qtd valida
    public static int obterQuantidadeValida(Scanner sc, String item) {
        int quantidade;
        while (true) {
            System.out.print("Quantidade de " + item + ": ");
            if (sc.hasNextInt()) {
                quantidade = sc.nextInt();
                if (quantidade >= 0) {
                    break;
                } else {
                    System.out.println("Quantidade nao pode ser negativa.");
                }
            } else {
                System.out.println("Entrada invalida!");
                sc.next(); // Limpa a entrada invalida
            }
        }
        return quantidade;
    }
    
    // Método que gera e exibe o relatorio de consumo
    public static void gerarRelatorio(char sexo, int qtdCervejas, int qtdRefrigerantes, int qtdEspetinhos) {
        double precoIngresso = (sexo == 'M') ? 10.00 : 8.00;
        double consumoCervejas = qtdCervejas * 5.00;
        double consumoRefrigerantes = qtdRefrigerantes * 3.00;
        double consumoEspetinhos = qtdEspetinhos * 7.00;
        double totalConsumo = consumoCervejas + consumoRefrigerantes + consumoEspetinhos;
        
        // Verifica se o couvert artistico será cobrado
        double couvert = (totalConsumo > 30.00) ? 0.00 :4.00;
        double valorTotal = totalConsumo + couvert + precoIngresso;
        
        // Exibição do relatorio detalhado
        System.out.println("\nRELATORIO:");
        System.out.printf("Consumo = R$ %.2f%n", totalConsumo);
        if (couvert == 0.00) {
            System.out.println("Insento de Couvert");
        } else {
            System.out.printf("Couvert = R$ %.2f%n", couvert);
        }
        System.out.printf("Ingresso = R$ %.2f%n", precoIngresso);
        System.out.printf("Valor a pagar = R$ %.2f%n", valorTotal);
    }
}
