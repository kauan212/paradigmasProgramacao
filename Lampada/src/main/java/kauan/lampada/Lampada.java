/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package kauan.lampada;

/**
 *
 * @author Kauan
 */


import java.util.Scanner;

public class Lampada {
    // Atributos privados
    private String marca;
    private String voltagem;
    private String tipo;
    private String modelo;
    private String cor;
    private double preco;
    private int garantia;
    private boolean ligada;

    // Construtor
    public Lampada(String marca, String voltagem, String tipo, String modelo, String cor, double preco, int garantia) {
        setMarca(marca);
        setVoltagem(voltagem);
        setTipo(tipo);
        setModelo(modelo);
        setCor(cor);
        setPreco(preco);
        setGarantia(garantia);
        this.ligada = false; // Inicialmente desligada
    }

    // Getters e Setters com validação
    public String getMarca() { return marca; }
    public void setMarca(String marca) {
        if (marca == null || marca.trim().isEmpty()) {
            throw new IllegalArgumentException("Marca nao pode ser vazia.");
        }
        this.marca = marca;
    }

    public String getVoltagem() { return voltagem; }
    public void setVoltagem(String voltagem) {
        if (voltagem == null || voltagem.trim().isEmpty()) {
            throw new IllegalArgumentException("Voltagem nao pode ser vazia.");
        }
        this.voltagem = voltagem;
    }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) {
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("Tipo nao pode ser vazio.");
        }
        this.tipo = tipo;
    }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) {
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("Modelo nao pode ser vazio.");
        }
        this.modelo = modelo;
    }

    public String getCor() { return cor; }
    public void setCor(String cor) {
        if (cor == null || cor.trim().isEmpty()) {
            throw new IllegalArgumentException("Cor nao pode ser vazia.");
        }
        this.cor = cor;
    }

    public double getPreco() { return preco; }
    public void setPreco(double preco) {
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero.");
        }
        this.preco = preco;
    }

    public int getGarantia() { return garantia; }
    public void setGarantia(int garantia) {
        if (garantia < 0) {
            throw new IllegalArgumentException("Garantia nao pode ser negativa.");
        }
        this.garantia = garantia;
    }

    public boolean isLigada() { return ligada; }

    // Métodos para ligar, desligar e mostrar status
    public void ligar() {
        if (!ligada) {
            ligada = true;
            System.out.println(">>> Lampada Ligada <<<");
        } else {
            System.out.println("A lampada ja esta ligada.");
        }
    }

    public void desligar() {
        if (ligada) {
            ligada = false;
            System.out.println(">>> Lampada Desligada <<<");
        } else {
            System.out.println("A lampada ja esta desligada.");
        }
    }

    public void mostrarStatus() {
        System.out.println("STATUS: " + (ligada ? "Ligada" : "Desligada"));
    }

    public static void main(String[] args) {
        // Leitura das informações da lâmpada
        Scanner scanner = new Scanner(System.in);
        System.out.println(">>> Informe os dados da lampada <<<");

        System.out.print("Marca: ");
        String marca = scanner.nextLine();

        System.out.print("Voltagem: ");
        String voltagem = scanner.nextLine();

        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();

        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();

        System.out.print("Cor: ");
        String cor = scanner.nextLine();

        System.out.print("Preco: R$ ");
        double preco = scanner.nextDouble();

        System.out.print("Garantia (meses): ");
        int garantia = scanner.nextInt();

        // Criação da lâmpada com os dados fornecidos
        Lampada lampada = new Lampada(marca, voltagem, tipo, modelo, cor, preco, garantia);
        System.out.println("Lampada criada com sucesso!");

        // Exibe as informações da lâmpada
        System.out.println("\nInformacoes da Lampada:");
        System.out.println("Marca: " + lampada.getMarca());
        System.out.println("Voltagem: " + lampada.getVoltagem());
        System.out.println("Tipo: " + lampada.getTipo());
        System.out.println("Modelo: " + lampada.getModelo());
        System.out.println("Cor: " + lampada.getCor());
        System.out.println("Preco: R$ " + lampada.getPreco());
        System.out.println("Garantia: " + lampada.getGarantia() + " meses");
        lampada.mostrarStatus();

        // Controle de ligar/desligar a lâmpada
        int opcao;
        do {
            System.out.println("\nEscolha uma opcao:");
            System.out.println("0 = Sair");
            System.out.println("1 = Ligar lampada");
            System.out.println("2 = Desligar lampada");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    lampada.ligar();
                    break;
                case 2:
                    lampada.desligar();
                    break;
                case 0:
                    System.out.println("====== Voce encerrou o software. ======");
                    break;
                default:
                    System.out.println("Opção invalida.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}



