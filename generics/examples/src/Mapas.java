import java.util.ArrayList;
import java.util.List;

public class Mapas<K, V> {
    List<Pora<K, V>> sarasasPoru = new ArrayList<>();

    public void ideti(K raktas, V reiksme) {
        V senaReiksme = gauti(raktas);

        if(senaReiksme != null) {
            sarasasPoru.remove(new Pora<>(raktas, senaReiksme));
        }
        sarasasPoru.add(new Pora<>(raktas, reiksme));

    }

    public V gauti(K raktas) {
        for (Pora<K, V> pora : sarasasPoru) {
            if (raktas.equals(pora.getRaktas())) {
                return pora.getReiksme();
            }
        }
        return null;
    }

}
