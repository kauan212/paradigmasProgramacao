/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package kauan.impostoderenda;

/**
 *
 * @author Kauan
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class ImpostoDeRenda {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            //Leitura de dados com validação
            double rendaAnualSalario = lerValor(scanner, "Renda anual com salario: ");
            double rendaAnualServico = lerValor(scanner, "Renda anual com prestacao de servicos: ");
            double rendaAnualCapital = lerValor(scanner, "Renda anual com ganho de capital: ");
            double gastosMedicos = lerValor(scanner, "Gastos medicos: ");
            double gastosEducacionais = lerValor(scanner, "Gastos educacionais: ");
            
            //Cálculos
            double impostoSalario = calcularImpostoSalario(rendaAnualSalario);
            double impostoServico = calcularImpostoServico(rendaAnualServico);
            double impostoCapital = calcularImpostoCapital(rendaAnualCapital);
            double impostoBrutoTotal = impostoSalario + impostoServico + impostoCapital;
            
            double maximoDedutivel = calcularMaximoDedutivel(impostoBrutoTotal);
            double gastosDedutiveis = calcularDeducoes(gastosMedicos, gastosEducacionais, maximoDedutivel);
            double impostoDevido = calcularImpostoDevido(impostoBrutoTotal, gastosDedutiveis);
            
            //Exibição do relatório
            exibirRelatorio(impostoSalario, impostoServico,impostoCapital, impostoBrutoTotal, maximoDedutivel, gastosDedutiveis, impostoDevido);
            
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada invalida. Por favor, insira numeros validos.");
        } finally {
            scanner.close();
        }
    }
    
    //Função para leitura de valores com validação de entrada positiva
    private static double lerValor(Scanner scanner, String mensagem){
        double valor = -1;
        while (valor < 0){
            System.out.print(mensagem);
            try {
                valor = scanner.nextDouble();
                if(valor < 0){
                    System.out.println("Erro: 0 valor deve ser positivo. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada invalida. Por favor, insira um numero valido.");
                scanner.next(); //Limpa a entrada inválida
            }
        }
        return valor;
    }
    
    //Cálculo do imposto sobre salário
    private static double calcularImpostoSalario(double rendaAnualSalario) {
        double salarioMensal = rendaAnualSalario / 12;
        if (salarioMensal >= 5000){
            return rendaAnualSalario * 0.20;
        } else if (salarioMensal >= 3000) {
            return rendaAnualSalario * 0.10;
        } else {
            return 0;
        }
    }
    
    //Cálculo do imposto sobre serviços
    private static double calcularImpostoServico(double rendaAnualServico) {
        return rendaAnualServico * 0.15;
    }
    
    // Cálculo de imposto sobree ganho de capital
    private static double calcularImpostoCapital(double rendaAnualCapital) {
        return rendaAnualCapital * 0.20;
    }
    
    //Cálculo do máximo dedutivel
    private static double calcularMaximoDedutivel(double impostoBrutoTotal) {
        return impostoBrutoTotal * 0.30;
    }
    
    //Cálculo de deduçoes
    private static double calcularDeducoes(double gastosMedicos, double gastosEducacionais, double maximoDedutivel) {
        return Math.min(gastosMedicos + gastosEducacionais, maximoDedutivel);
    }
    
    //Cálculo de imposto devido
    private static double calcularImpostoDevido(double impostoBrutoTotal, double gastosDedutiveis) {
        return impostoBrutoTotal - gastosDedutiveis;
    }
    
    // Exibição de relatório
    private static void exibirRelatorio(double impostoSalario, double impostoServico, double impostoCapital,
                                        double impostoBrutoTotal, double maximoDedutivel, double gastosDedutiveis, double impostoDevido) {
        System.out.println("==== RELATORIO DE IMPOSTO DE RENDA ====");
        System.out.println("* CONSOLIDADO DE RENDA:");
        System.out.printf("Imposto sobre salario: %.2f%n", impostoSalario);
        System.out.printf("Imposto sobre servicos: %.2f%n", impostoServico);
        System.out.printf("Imposto sobre ganho de capital: %.2f%n", impostoCapital);
        System.out.println("* DEDUCOES:");
        System.out.printf("Maximo dedutivel: %.2f%n", maximoDedutivel);
        System.out.printf("Gastos dedutiveis: %.2f%n", gastosDedutiveis);
        System.out.println("* RESUMO:");
        System.out.printf("Imposto bruto total: %.2f%n", impostoBrutoTotal);
        System.out.printf("Abatimento: %.2f%n", gastosDedutiveis);
        System.out.printf("Imposto devido: %.2f%n",impostoDevido);
    }
}
