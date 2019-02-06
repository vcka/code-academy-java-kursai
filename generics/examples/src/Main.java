import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Pora<String, Integer> pora = new Pora<>("String", 10);

        Mapas<DnsProvider, DnsServer> dnsMapas = new Mapas<>();
        Mapas<String, String> stringMapas = new Mapas<>();

        stringMapas.ideti("vienas", "du");
        System.out.println(stringMapas.gauti("vienas"));
        System.out.println(stringMapas.gauti("asasda"));

        dnsMapas.ideti(DnsProvider.GOOGLE, new DnsServer("8.8.8.8", "8.8.4.4"));
        dnsMapas.ideti(DnsProvider.GOOGLE, new DnsServer("6.8.6.8", "8.8.4.4"));
        dnsMapas.ideti(DnsProvider.CLOUDFLARE, new DnsServer("1.1.1.1", "1.0.0.1"));
        System.out.println(dnsMapas.gauti(DnsProvider.GOOGLE));
    }
}
