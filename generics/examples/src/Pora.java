import java.util.Objects;

public class Pora <K, V> {
    private K raktas;
    private V reiksme;

    public Pora(K raktas, V reiksme) {
        this.raktas = raktas;
        this.reiksme = reiksme;
    }

    public K getRaktas() {
        return raktas;
    }

    public V getReiksme() {
        return reiksme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pora<?, ?> pora = (Pora<?, ?>) o;
        return Objects.equals(raktas, pora.raktas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raktas);
    }
}
