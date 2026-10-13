import java.util.Scanner;

/* Classe principal: mostra o menu e conversa com o usuário. */
public class Principal {

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        Cofrinho cofrinho = new Cofrinho();
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== COFRE DE MOEDAS R.M:5218086 =====");
            System.out.println("1 - Adicionar moeda");
            System.out.println("2 - Remover moeda");
            System.out.println("3 - Listar moedas");
            System.out.println("4 - Total convertido para Real");
            System.out.println("0 - Fechar cofre");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(teclado.nextLine().trim());
            } catch (NumberFormatException e) {
                opcao = -1; // entrada inválida cai no default
            }

            switch (opcao) {
                case 1:
                    Moeda nova = lerMoeda();
                    if (nova != null) {
                        cofrinho.adicionar(nova);
                        System.out.println("Moeda adicionada!");
                    }
                    break;
                case 2:
                    Moeda alvo = lerMoeda();
                    if (alvo != null) {
                        if (cofrinho.remover(alvo)) {
                            System.out.println("Moeda removida!");
                        } else {
                            System.out.println("Essa moeda não está não existe.");
                        }
                    }
                    break;
                case 3:
                    cofrinho.listagemMoedas();
                    break;
                case 4:
                    System.out.printf("Total no cofrinho: R$ %.2f%n", cofrinho.totalConvertido());
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        teclado.close();
    }

    // Pergunta o tipo e o valor e devolve o objeto correto (ou null se algo for
    // inválido)
    private static Moeda lerMoeda() {
        System.out.println("Tipo: 1-Dólar  2-Euro  3-Real  4-Iene");
        System.out.print("Escolha: ");
        int tipo;
        double valor;
        try {
            tipo = Integer.parseInt(teclado.nextLine().trim());
            System.out.print("Valor: ");
            // aceita vírgula ou ponto como separador decimal
            valor = Double.parseDouble(teclado.nextLine().trim().replace(',', '.'));
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
            return null;
        }
        if (valor <= 0) {
            System.out.println("O valor deve ser maior que zero.");
            return null;
        }
        switch (tipo) {
            case 1:
                return new Dolar(valor);
            case 2:
                return new Euro(valor);
            case 3:
                return new Real(valor);
            case 4:
                return new Iene(valor);
            default:
                System.out.println("Tipo inválido.");
                return null;
        }
    }
}
