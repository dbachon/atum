package tk.tarajki.atum.borrowing;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import tk.tarajki.atum.auth.UserPrincipal;
import tk.tarajki.atum.user.UserDto;

import java.util.List;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController {

    private BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @GetMapping
    public List<BorrowingDto> findMyBorrowings(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return  borrowingService.getBorrowingsByUser(userPrincipal.getUser());
    }

    @PostMapping
    public void addBorrowing(@AuthenticationPrincipal UserPrincipal userPrincipal, @RequestBody BorrowingAddRequest borrowingAddRequest){
        borrowingService.addBorrowing(userPrincipal.getUser(), borrowingAddRequest);
    }

    @DeleteMapping
    public void returnBorrowing(@RequestBody BorrowingReturnRequest borrowingReturnRequest){
        borrowingService.returnBorrowing(borrowingReturnRequest);
}




}
