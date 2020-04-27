package tk.tarajki.atum.book;

import tk.tarajki.atum.utils.enums.Genre;

public class BookInfoDto {
    private String title;
    private Genre genre;

    public BookInfoDto(Book book) {
        this.title = book.getTitle();
        this.genre = book.getGenre();
    }

    public BookInfoDto() {
    }

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
