package tk.tarajki.atum.borrowing;

import tk.tarajki.atum.utils.enums.Genre;

import java.util.List;

public class BorrowingAddRequest{
    private List<Long> copiesId;


    public List<Long> getCopiesId() {
        return copiesId;
    }

    public void setCopiesId(List<Long> copiesId) {
        this.copiesId = copiesId;
    }
}
