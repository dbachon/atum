package tk.tarajki.atum.borrowing;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import tk.tarajki.atum.auth.UserPrincipal;

import java.util.List;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController {

    private BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @GetMapping
    public List<BorrowingDto> findMyBorrowings(@AuthenticationPrincipal UserPrincipal userPrincipal, @ModelAttribute BorrowingFilter borrowingFilter) {

        return borrowingService.getBorrowingsByUser(userPrincipal.getUser(), borrowingFilter);
    }

    @GetMapping("/all")
    public List<BorrowingDto> findBorrowings(@ModelAttribute BorrowingFilter borrowingFilter) {
        return borrowingService.findBorrowings(borrowingFilter);
    }

    @PostMapping
    public void addBorrowing(@AuthenticationPrincipal UserPrincipal userPrincipal, @RequestBody BorrowingAddRequest borrowingAddRequest){
        borrowingService.addBorrowing(userPrincipal.getUser(), borrowingAddRequest);
    }


    @PatchMapping
    public void returnBorrowing(@RequestBody BorrowingReturnRequest borrowingReturnRequest) {
        borrowingService.returnBorrowing(borrowingReturnRequest);
    }

    @PostMapping("/settings")
    public void acceptReturnBorrowing(@RequestBody BorrowingAcceptRequest borrowingAcceptRequest) {
        borrowingService.acceptReturnBorrowing(borrowingAcceptRequest);
    }




}
