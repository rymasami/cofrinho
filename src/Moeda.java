import java.util.Objects;

/** Define o contrato geral para moedas. Cada classe concreta herda essa abstração e aplica polimorfismo ao implementar info() e converter().
 */
public abstract class Moeda {

    protected double valor; // quantia da moeda, na própria moeda

    public Moeda(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    // Cada subclasse decide como se apresenta
    public abstract String info();

    // Cada subclasse converte o valor para Real usando sua própria cotação
    public abstract double converter();

    // Duas moedas são "iguais" se forem da mesma classe e tiverem o mesmo valor.
    // Isso permite que remover(Moeda) do ArrayList encontre a moeda certa.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Moeda outra = (Moeda) obj;
        return Double.compare(valor, outra.valor) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass(), valor);
    }
}
