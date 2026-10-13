/** Moeda da zona do Euro. Herda de Moeda. */
public class Euro extends Moeda {

    private static final double COTACAO = 6.30; // 1 EUR em reais (ajuste se quiser)

    public Euro(double valor) {
        super(valor);
    }

    @Override
    public String info() {
        return String.format("Euro: EUR %.2f", valor);
    }

    @Override
    public double converter() {
        return valor * COTACAO;
    }
}
