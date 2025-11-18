package filmbase.data;

import java.util.ArrayList;
import java.util.Collection;

public class Film {
    String title;
    int year;
    private Genre genre;
    private Collection<Genre> genres = new ArrayList<>();


    public Film(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public Film(String title, int year, Genre genre) {
        this.title = title;
        this.year = year;
        this.genres.add(genre);
    }

    public boolean hasGenre(Genre genre) {
        if (this.genre == genre) {
            return true;
        } else {
            return false;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Collection<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Collection<Genre> genres) {
        this.genres = genres;
    }

    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }

}
