package filmbase.data;

import java.util.Comparator;

public class YearComparator implements Comparator<Film> {
    @Override
    public int compare (Film f1, Film f2){ // brug YearComparator().reversed() for at få det omvendt.
        return Integer.compare(f1.getYear(), f2.getYear());
    }
}
