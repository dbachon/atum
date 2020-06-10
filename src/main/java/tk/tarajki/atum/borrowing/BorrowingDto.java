package tk.tarajki.atum.borrowing;

import tk.tarajki.atum.copy.CopyDto;
import tk.tarajki.atum.utils.enums.Status;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BorrowingDto {
    private String email;
    private Long id;
    private Date date;
    private Date returnedDate;
    private Status status;
    private List<CopyDto> copies;

    public BorrowingDto() {
    }

    public BorrowingDto(Borrowing borrowing) {
        this.email = borrowing.getUser().getEmail();
        this.id = borrowing.getId();
        this.date = borrowing.getDate();
        this.returnedDate = borrowing.getReturnedDate();
        this.status = borrowing.getStatus();
        this.copies = borrowing.getCopies().stream().map(CopyDto::new).collect(Collectors.toList());
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<CopyDto> getCopies() {
        return copies;
    }

    public void setCopies(List<CopyDto> copies) {
        this.copies = copies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
