package rs.aleph.android.example12.provider;

import java.util.ArrayList;
import java.util.List;

import rs.aleph.android.example12.model.Kategorija;

/**
 * Created by androiddevelopment on 1.2.17..
 */

public class KategorijaProvider {
    public static List<String> getKategorijaNazivi() {

        List<String> nazivi = new ArrayList<>();
        nazivi.add("Vegetables");
        nazivi.add("Fruits");
        return nazivi;
    }
    public static Kategorija getKategorijaById(int id){
        switch (id) {
            case 0:
                return new Kategorija(0,"Vegetables");
            case 1:
                return new Kategorija(1,"Fruits");
            default:
                return null;
        }
    }
}
