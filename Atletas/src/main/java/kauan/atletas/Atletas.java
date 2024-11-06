/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package kauan.atletas;

/**
 *
 * @author Kauan
 */
import java.util.ArrayList;
import java.util.Scanner;

class Atleta {
    private String nome;
    private char sexo;
    private double altura;
    private double peso;

    // Construtor
    public Atleta(String nome, char sexo, double altura, double peso) {
        this.nome = nome;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
    }

    // Getters
    public String getNome() { return nome; }
    public char getSexo() { return sexo; }
    public double getAltura() { return altura; }
    public double getPeso() { return peso; }
}

public class Atletas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Atleta> atletas = new ArrayList<>();

        // Lê a quantidade de atletas
        System.out.print("Qual a quantidade de atletas? ");
        int n = scanner.nextInt();

        // Leitura e validação de dados de cada atleta
        for (int i = 0; i < n; i++) {
            System.out.println("Digite os dados do atleta numero " + (i + 1) + ":");
            
            System.out.print("Nome: ");
            scanner.nextLine(); // Limpar buffer
            String nome = scanner.nextLine();

            // Validação do sexo
            char sexo;
            do {
                System.out.print("Sexo (M/F): ");
                sexo = scanner.next().toUpperCase().charAt(0);
                if (sexo != 'M' && sexo != 'F') {
                    System.out.println("Valor invalido! Favor digitar F ou M.");
                }
            } while (sexo != 'M' && sexo != 'F');

            // Validação da altura
            double altura;
            do {
                System.out.print("Altura: ");
                altura = scanner.nextDouble();
                if (altura <= 0) {
                    System.out.println("Valor invalido! Favor digitar um valor positivo.");
                }
            } while (altura <= 0);

            // Validação do peso
            double peso;
            do {
                System.out.print("Peso: ");
                peso = scanner.nextDouble();
                if (peso <= 0) {
                    System.out.println("Valor invalido! Favor digitar um valor positivo.");
                }
            } while (peso <= 0);

            // Adiciona o atleta à lista após as validações
            atletas.add(new Atleta(nome, sexo, altura, peso));
        }

        // Gera o relatório final com os dados processados
        gerarRelatorio(atletas);
        scanner.close();
    }

    // Gera e exibe o relatório com cálculos baseados nos dados dos atletas
    private static void gerarRelatorio(ArrayList<Atleta> atletas) {
        double pesoTotal = 0;
        double alturaTotalMulheres = 0;
        int homens = 0;
        int mulheres = 0;
        Atleta atletaMaisAlto = null;

        // Processa dados para calcular métricas do relatório
        for (Atleta atleta : atletas) {
            pesoTotal += atleta.getPeso();

            // Identifica o atleta mais alto
            if (atletaMaisAlto == null || atleta.getAltura() > atletaMaisAlto.getAltura()) {
                atletaMaisAlto = atleta;
            }

            // Conta homens e calcula altura total das mulheres
            if (atleta.getSexo() == 'M') {
                homens++;
            } else {
                mulheres++;
                alturaTotalMulheres += atleta.getAltura();
            }
        }

        // Cálculo de métricas
        double pesoMedio = pesoTotal / atletas.size();
        double porcentagemHomens = (double) homens / atletas.size() * 100;

        // Exibe o relatório formatado
        System.out.println("====== RELATORIO ======");
        System.out.printf("Peso medio dos atletas: %.2f%n", pesoMedio);
        System.out.println("Atleta mais alto: " + atletaMaisAlto.getNome());
        System.out.printf("Porcentagem de homens: %.1f %% %n", porcentagemHomens);

        // Verifica se há mulheres antes de calcular a altura média
        if (mulheres > 0) {
            double alturaMediaMulheres = alturaTotalMulheres / mulheres;
            System.out.printf("Altura media das mulheres: %.2f%n", alturaMediaMulheres);
        } else {
            System.out.println("Nao ha mulheres cadastradas");
        }
    }
}

