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
        
        //Entrada de dados
        System.out.print("Sexo (F ou M): ");
        char sexo = sc.next().charAt(0);
        
        System.out.print("Quantidade de cervejas: ");
        int qtdCervejas = sc.nextInt();
        
        System.out.print("Quantidade de refrigerantes: ");
        int qtdRefrigerantes = sc.nextInt();
        
        System.out.print("Quantidade de espetinhos: ");
        int qtdEspetinhos = sc.nextInt();
        
        // Cálculos de consumo
        double precoIngresso = (sexo == 'M') ? 10.00 : 8.00;
        double consumoCervejas = qtdCervejas * 5.00;
        double consumoRefrigerantes = qtdRefrigerantes * 3.00;
        double consumoEspetinhos = qtdEspetinhos * 7.00;
        double totalConsumo = consumoCervejas + consumoRefrigerantes + consumoEspetinhos;
        
        // Verifica se há cobrança de couvert artistico
        double couvert = (totalConsumo > 30.00) ? 0.00 : 4.00;
        
        // Cálculo do valor total a pagar
        double valorTotal = totalConsumo + couvert + precoIngresso;
        
        // Exibição do relatorio
        System.out.println("\nRELATORIO:");
        System.out.printf("Consumo = R$ %.2f%n", totalConsumo);
        if (couvert == 0.00) {
            System.out.println("Isento de Couvert");    
        } else {
            System.out.printf("Couvert = R$ %.2f%n", couvert);
        }
        System.out.printf("Ingresso = R$ %.2f%n", precoIngresso);
        System.out.printf("Valor a pagar = R$ %.2f%n", valorTotal);
        
        sc.close();
    }
}
