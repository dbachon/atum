package tk.tarajki.atum.book;

import tk.tarajki.atum.utils.enums.Genre;

public class BookFilter {
    private String title;
    private Genre genre;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
