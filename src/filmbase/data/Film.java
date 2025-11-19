package filmbase.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Film {
    String title;
    int year;
    private Genre genre;
    private Collection<Genre> genres = new ArrayList<>();


    public Film(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public Film(String title, int year, Genre... genres) {
        this.title = title;
        this.year = year;
        for (Genre genre : genres) {
            this.genres.add(genre);
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return year == film.year &&
                title.equalsIgnoreCase(film.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title.toLowerCase(), year);
    }
}
