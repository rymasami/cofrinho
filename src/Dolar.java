/** Moeda dos EUA. Herda de Moeda. */
public class Dolar extends Moeda {

    private static final double COTACAO = 5.40; // 1 USD em reais (ajuste se quiser)

    public Dolar(double valor) {
        super(valor);
    }

    @Override
    public String info() {
        return String.format("Dólar: US$ %.2f", valor);
    }

    @Override
    public double converter() {
        return valor * COTACAO;
    }
}
