package tk.tarajki.atum.borrowing;

import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.data.auditing.DateTimeProvider;
import tk.tarajki.atum.copy.Copy;
import tk.tarajki.atum.user.User;
import tk.tarajki.atum.utils.BaseEntity;
import tk.tarajki.atum.utils.enums.Status;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Entity
public class Borrowing extends BaseEntity<Long> {

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    private Date date = new Date();
    private Date returnedDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Copy> copies;

    public Borrowing() {
    }

    public Borrowing(User user, Status status, List<Copy> copies) {
        this.user = user;
        this.status = status;
        this.copies = copies;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public List<Copy> getCopies() {
        return copies;
    }

    public void setCopies(List<Copy> copies) {
        this.copies = copies;
    }
}
