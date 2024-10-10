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
            double rendaAnualSalario = lerValor(scanner, "Renda anual com salário: ");
            double rendaAnualServico = lerValor(scanner, "Renda anual com prestação de serviços: ");
            double rendaAnualCapital = lerValor(scanner, "Renda anual com ganho de capital: ");
            double gastosMedicos = lerValor(scanner, "Gastos médicos: ");
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
            System.out.println("Erro: Entrada inválida. Por favor, insira números válidos.");
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
                System.out.println("Erro: Entrada inválida. Por favor, insira um número válido.");
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
}
