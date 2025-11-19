package filmbase.app;

import filmbase.data.Film;
import filmbase.data.Genre;
import filmbase.data.Playlist;
import filmbase.data.*;

import java.util.*;


public class FilmBase {

    public void start() {
        //System.out.println("FilmBasen er startet");
        initFilms();
        // printList(allFilms);
        //testFiltering();
        countGenres();
    }

    private ArrayList<Film> allFilms = new ArrayList<>();
    public boolean addFilm(Film film) {
        if (!allFilms.contains(film)) {
            allFilms.add(film);
            return true;
        } else {
            return false;
        }
    }


    private void initFilms() {
        addFilm(new Film("The Lorax", 2012, Genre.ADVENTURE));
        (new Film("Barbie", 2024, Genre.ROMANCE));
        (new Film("John Wick", 2024, Genre.THRILLER));

        allFilms.add(new Film("John Wick 2", 2024, Genre.THRILLER));

        allFilms.add(new Film("John Wick 3", 2024, Genre.THRILLER));
        allFilms.getLast().addGenre(Genre.CRIME);
        allFilms.add(new Film("John Wick 4", 2025, Genre.THRILLER));
        allFilms.getLast().addGenre(Genre.CRIME);
        allFilms.add(new Film("Dexter", 2023, Genre.CRIME));
        allFilms.getLast().addGenre(Genre.THRILLER);
        allFilms.add(new Film("The Downer", 2022, Genre.SPORT));
    }


    public static void printList(Collection<Film> films) {
        int counter = 1;
        for (Film film : films) {
            System.out.println(counter + ": " + film.getTitle() + ", (" + film.getYear() + ") : " + film.getGenres());
            counter++;
        }
    }

    public static void printGenreList(Collection<Genre> genres) {
        int counter = 1;
        for (Genre genre : genres) {
            System.out.println(counter++ + ": " + genre);
        }
    }

    public void testFiltering() {
        Playlist playlist = new Playlist();
        playlist.addFilm(allFilms.get(0));
        playlist.addFilm(allFilms.get(1));
        playlist.addFilm(allFilms.get(2));
        playlist.addFilm(allFilms.get(3));
        playlist.addFilm(allFilms.get(4));

        printList(playlist.listOfFilms());
    }

    public void countGenres() {
        List<Genre> allGenres = new ArrayList<>();
        for (Film film : allFilms) {
            allGenres.addAll(film.getGenres());
        }
        printGenreList(allGenres);
    }

    public void genreFilms() {
        Map<Genre, Collection<Film>> genreFilms = new HashMap<>();
        for (Film film : allFilms) {
            for (Genre genre : film.getGenres()) {
                if (!genreFilms.containsKey(genre)) {
                    Collection<Film> filmsInGenre = new ArrayList<>();
                    filmsInGenre.add(film);
                    genreFilms.put(genre, filmsInGenre);

                } else {
                    Collection<Film> filmsInGenre = genreFilms.get(genre);

                    filmsInGenre.add(film);
                }
            }
        }
    }
}
