package filmbase.data;
import filmbase.app.*;

import filmbase.app.FilmBase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import static filmbase.app.FilmBase.printList;

public class Playlist {

    private List<Film> newFilms = new ArrayList<>();

    public boolean addFilm(Film film) {
        if (!allFilms.contains(film)) {
            allFilms.add(film);
            return true;
        } else {
            return false;
        }
    }

    public boolean addNewFilm(Film film) {
        if (!newFilms.contains(film)) {
            newFilms.add(film);
            return true;
        } else {
            return false;
        }
    }

    public Film nextFilm (){
        if(newFilms.size() < 2)
            return null;
        return newFilms.get(1);
    }

    public void clearList(){
        newFilms.clear();
    }

    public List<Film> listOfFilms() {
        return newFilms;
    }

    public Collection<Film> ListFilms (){
        return newFilms;
    }

    public void playFilm() {

        if (newFilms.isEmpty()) {
            System.out.println("Listen er tom!");
            return;
        }

        printList(newFilms);

        Scanner scan = new Scanner(System.in);
        System.out.println("Vælg en film: ");
        int index = scan.nextInt() - 1;

        if (index < 0 || index >= newFilms.size()) {
            System.out.println("Ugyldigt valg!");
            return;
        }


        Film chosen = newFilms.get(index);


        Film nextFilm = null;
        if (index + 1 < newFilms.size()) {
            nextFilm = newFilms.get(index + 1);
        }


        newFilms.remove(index);


        System.out.println("Du spiller nu: " + chosen.getTitle() + " (" + chosen.getYear() + ")");


        if (nextFilm != null) {
            System.out.println("Næste film er: " + nextFilm.getTitle() + " (" + nextFilm.getYear() + ")");
            System.out.println("--- Ny Liste ---");
            printList(newFilms);
        } else {
            System.out.println("Der er ingen næste film.");
        }
    }

    public void removeList(Film film) {
        newFilms.remove(film);
    }

    public void removeGenre(Genre genre) {
        newFilms.removeIf(film -> film.hasGenre(genre));
    }

    public void sortByYear (){
        newFilms.sort(new YearComparator());
    }

    public void sortByAlphabet (){
        newFilms.sort(new TitleComparator());
    }

    public void reversedYearSort (){
        newFilms.sort(new YearComparator().reversed());
    }

    public void reversedTitleSort (){
        newFilms.sort(new TitleComparator().reversed());
    }
}
