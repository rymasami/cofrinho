/** Moeda brasileira. Já está em Real, então a conversão é 1 para 1. */
public class Real extends Moeda {

    public Real(double valor) {
        super(valor);
    }

    @Override
    public String info() {
        return String.format("Real: R$ %.2f", valor);
    }

    @Override
    public double converter() {
        return valor;
    }
}
