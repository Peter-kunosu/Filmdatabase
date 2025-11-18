package filmbase.data;

import filmbase.app.FilmBase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import static filmbase.app.FilmBase.printList;

public class Playlist {

    private List<Film> newFilms = new ArrayList<>();

    public void addToList(Film film) {
        newFilms.add(film);
    }

    public Collection<Film> getFilms (){
        return newFilms;
    }

    public void playFilm() {

        if (newFilms.isEmpty()) {
            System.out.println("Listen er tom!");
            return;
        }

        // Print listen
        printList(newFilms);

        Scanner scan = new Scanner(System.in);
        System.out.println("Vælg en film (nummer):");
        int index = scan.nextInt();
        index--;

        if (index < 0 || index >= newFilms.size()) {
            System.out.println("Ugyldigt valg!");
            return;
        }

        Film chosen = newFilms.remove(index);

        System.out.println("Du spiller nu: " + chosen.getTitle() + " (" + chosen.getYear() + ")");
        System.out.println("Næste film er: ");
    }

}
