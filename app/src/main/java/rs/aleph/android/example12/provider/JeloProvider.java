package rs.aleph.android.example12.provider;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import rs.aleph.android.example12.model.Jelo;
import rs.aleph.android.example12.model.Kategorija;
import rs.aleph.android.example12.model.Sastojak;

/**
 * Created by androiddevelopment on 1.2.17..
 */

public class JeloProvider {

    public static List<String> getJelaNazivi() {

        List<String> nazivi = new ArrayList<>();
        nazivi.add("Broccoli");
        nazivi.add("Apple");
        nazivi.add("Strawberies");
        nazivi.add("Carrots");
        nazivi.add("Bananas");
        return nazivi;
    }

    public static Jelo getJeloById(int id){
        Kategorija k1 = new Kategorija(0,"Vegetables");
        Kategorija k2 = new Kategorija(1,"Fruits");
        Jelo rezultat;
        switch (id) {
            case 0: {
                rezultat = new Jelo(0, "two-heads-of-broccolii.jpg", "Broccoli", "Vegetable good for kids", k1, 100, BigDecimal.valueOf(1000));
                rezultat.getSastojci().add(new Sastojak(0, "Sastojak 1 za Broccoli", rezultat));
                rezultat.getSastojci().add(new Sastojak(1, "Sastojak 2 za Broccoli", rezultat));
                break;
            }
            case 1: {
                rezultat = new Jelo(1, "apple.jpg", "Apple", "Most popular fruit", k2, 200, BigDecimal.valueOf(2000));

                rezultat.getSastojci().add(new Sastojak(0, "Sastojak 1 za Apple", rezultat));
                rezultat.getSastojci().add(new Sastojak(1, "Sastojak 2 za Apple", rezultat));

                break;
            }
            case 2: {
                rezultat = new Jelo(2, "strawberies.jpg", "Strawberies", "Goes good with whipped cream", k2, 300.30, BigDecimal.valueOf(3000));
                break;
            }
            case 3: {
                rezultat = new Jelo(3, "orange-carrots-against-white.jpg", "Carrots", "Best meal for rabbits", k1, 400, BigDecimal.valueOf(4000));
                break;
            }
            case 4: {
                rezultat = new Jelo(4, "bananas.jpg", "Bananas", "Best meal for monkeys", k2, 500.50, BigDecimal.valueOf(5000));
                break;
            }
            default:
                rezultat = null;
        }
        return rezultat;
    }
}
