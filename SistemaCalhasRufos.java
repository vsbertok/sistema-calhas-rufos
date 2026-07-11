import java.util.Locale;
import java.util.Scanner;

public class SistemaCalhasRufos {

    
    private static final Locale LOCALE_BR = new Locale("pt", "BR");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(LOCALE_BR); 

        int opcaoPrincipal;

        System.out.println("========================================");
        System.out.println("   SISTEMA DE CORTES - CALHAS E RUFOS   ");
        System.out.println("========================================");

        do {
            System.out.println("\nO que você deseja calcular?");
            System.out.println("1. Calha");
            System.out.println("2. Rufo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcaoPrincipal = scanner.nextInt();

            switch (opcaoPrincipal) {
                case 1:
                    calcularCalha(scanner);
                    break;
                case 2:
                    calcularRufo(scanner);
                    break;
                case 0:
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcaoPrincipal != 0);

        scanner.close();
    }

    private static void calcularCalha(Scanner scanner) {
        System.out.println("\n--- OPÇÕES DE MATERIAL ---");
        System.out.println("1. Galvanizado");
        System.out.println("2. Preto");
        System.out.println("3. Branco");
        System.out.print("Escolha o material: ");
        int opMaterial = scanner.nextInt();
        String material = obterMaterial(opMaterial);

        System.out.println("\n--- TIPOS DE CALHA ---");
        System.out.println("1. Quadrada (4 medidas)");
        System.out.println("2. Beiral (8 medidas)");
        System.out.println("3. Escadinha (Até 12 medidas)");
        System.out.print("Escolha o tipo de calha: ");
        int opTipo = scanner.nextInt();

        int qtdMedidas = 0;
        String tipoCalha = "";

        if (opTipo == 1) {
            qtdMedidas = 4;
            tipoCalha = "Quadrada";
        } else if (opTipo == 2) {
            qtdMedidas = 8;
            tipoCalha = "Beiral";
        } else if (opTipo == 3) {
            System.out.print("Quantas medidas a calha escadinha terá? (Máximo 12): ");
            qtdMedidas = scanner.nextInt();
            if (qtdMedidas > 12) {
                System.out.println("Número máximo excedido. Reduzindo para 12.");
                qtdMedidas = 12;
            }
            tipoCalha = "Escadinha";
        } else {
            System.out.println("Tipo inválido. Operação cancelada.");
            return;
        }

        double somaCorte = coletarMedidas(scanner, qtdMedidas);
        
        System.out.print("\nInsira o comprimento total da calha em metros (use vírgula, ex: 8,5): ");
        double comprimentoTotal = scanner.nextDouble();

        exibirResumo(material, tipoCalha, somaCorte, comprimentoTotal);
    }

    private static void calcularRufo(Scanner scanner) {
        System.out.println("\n--- TIPOS DE RUFO ---");
        System.out.println("1. Rufo L (2 medidas)");
        System.out.println("2. Rufo Padrão (4 medidas)");
        System.out.print("Escolha o tipo de rufo: ");
        int opTipo = scanner.nextInt();

        int qtdMedidas = 0;
        String tipoRufo = "";

        if (opTipo == 1) {
            qtdMedidas = 2;
            tipoRufo = "Rufo L";
        } else if (opTipo == 2) {
            qtdMedidas = 4;
            tipoRufo = "Rufo Padrão";
        } else {
            System.out.println("Tipo inválido. Operação cancelada.");
            return;
        }

        double somaCorte = coletarMedidas(scanner, qtdMedidas);

        System.out.print("\nInsira o comprimento total do rufo em metros (use vírgula, ex: 6,2): ");
        double comprimentoTotal = scanner.nextDouble();

        exibirResumo("Não se aplica (Apenas Rufo)", tipoRufo, somaCorte, comprimentoTotal);
    }

    private static double coletarMedidas(Scanner scanner, int quantidade) {
        double soma = 0;
        System.out.println("\nInsira as medidas em centímetros (cm) - Use VÍRGULA para decimais (ex: 15,5):");
        for (int i = 1; i <= quantidade; i++) {
            System.out.print("Medida " + i + ": ");
            soma += scanner.nextDouble();
        }
        return soma;
    }

    private static void exibirResumo(String material, String tipo, double corte, double comprimentoTotal) {
        System.out.println("\n========================================");
        System.out.println("           RESUMO DO PEDIDO             ");
        System.out.println("========================================");
        if (!material.equals("Não se aplica (Apenas Rufo)")) {
            System.out.println("Material: " + material);
        }
        System.out.println("Tipo: " + tipo);
        System.out.println("Corte da chapa (Desenvolvimento): " + formatar(corte) + " cm");
        System.out.println("Comprimento Total Solicitado: " + formatar(comprimentoTotal) + " metros");
        System.out.println("----------------------------------------");
        
        if (comprimentoTotal <= 7.0) {
            System.out.println("Logística: A peça irá INTEIRA.");
            System.out.println("Resultado: 1 peça de " + formatar(comprimentoTotal) + " metros.");
        } else {
            int qtdPecas = (int) Math.ceil(comprimentoTotal / 5.0);
            double tamanhoPeca = comprimentoTotal / qtdPecas;
            
            System.out.println("Logística: O comprimento excede 7m. A peça será DIVIDIDA.");
            System.out.println("Resultado: " + qtdPecas + " peças iguais de " + formatar(tamanhoPeca) + " metros.");
        }
        System.out.println("========================================");
    }

    private static String obterMaterial(int opcao) {
        switch (opcao) {
            case 1: return "Galvanizado";
            case 2: return "Preto";
            case 3: return "Branco";
            default: return "Não especificado";
        }
    }

    private static String formatar(double valor) {
        return String.format(LOCALE_BR, "%.2f", valor);
    }
}