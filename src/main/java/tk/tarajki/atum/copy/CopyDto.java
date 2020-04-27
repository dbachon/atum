package tk.tarajki.atum.copy;

import tk.tarajki.atum.book.BookCopyDto;
import tk.tarajki.atum.utils.enums.Availability;

public class CopyDto {
    private Long id;
    private String code;
    private Availability availability;
    private BookCopyDto book;

    public CopyDto() {
    }


    public CopyDto(Copy copy) {
        this.id = copy.getId();
        this.code = copy.getCode();
        this.availability = copy.getAvailability();
        this.book = new BookCopyDto(copy.getBook());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BookCopyDto getBook() {
        return book;
    }

    public void setBook(BookCopyDto book) {
        this.book = book;
    }
}
