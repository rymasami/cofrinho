import java.util.ArrayList;

/** Armazena moedas manipulando apenas a classe genérica, sem se preocupar com a moeda específica (Dólar, Euro, Real ou Iene).
 */
public class Cofrinho {

    private ArrayList<Moeda> listaMoedas = new ArrayList<>();

    public void adicionar(Moeda moeda) {
        listaMoedas.add(moeda);
    }

    // Retorna true se achou e removeu (usa o equals de Moeda)
    public boolean remover(Moeda moeda) {
        return listaMoedas.remove(moeda);
    }

    public void listagemMoedas() {
        if (listaMoedas.isEmpty()) {
            System.out.println("O cofrinho está vazio.");
            return;
        }
        for (int i = 0; i < listaMoedas.size(); i++) {
            // info() é chamado em cada objeto e responde de acordo com sua classe real
            System.out.println((i + 1) + " - " + listaMoedas.get(i).info());
        }
    }

    public double totalConvertido() {
        double total = 0;
        for (Moeda m : listaMoedas) {
            total += m.converter(); // cada moeda converte do seu jeito
        }
        return total;
    }
}
