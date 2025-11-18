package filmbase.app;

import filmbase.data.Film;

import java.util.ArrayList;
import java.util.Collection;

public class FilmBase {
    public void TomConstruct (){

    }
    public void start(){
        System.out.println("FilmBasen er startet");
        initFilms();
        printList(allFilms);
    }

    private Collection<Film> allFilms = new ArrayList<>();

    private void initFilms(){
        allFilms.add(new Film("The Lorax", 2012));
        allFilms.add(new Film("Barbie", 2024));
        allFilms.add(new Film("John Wick", 2024));
        allFilms.add(new Film("John Wick 2", 2024));
        allFilms.add(new Film("John Wick 3", 2024));
        allFilms.add(new Film("John Wick 4", 2025));
        allFilms.add(new Film("Dexter", 2023));
        allFilms.add(new Film("The Downer", 2022));
    }

    public static void printList(Collection<Film> films) {
        int counter = 1;
        for (Film film : films) {
            System.out.println(counter + ": " + film.getTitle() + ", (" + film.getYear() + ")");
            counter++;
        }
    }
}
