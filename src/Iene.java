/** Moeda do Japão. Herda de Moeda. */
public class Iene extends Moeda {

    private static final double COTACAO = 0.036; // 1 JPY em reais (ajuste se quiser)

    public Iene(double valor) {
        super(valor);
    }

    @Override
    public String info() {
        return String.format("Iene: JPY %.2f", valor);
    }

    @Override
    public double converter() {
        return valor * COTACAO;
    }
}
