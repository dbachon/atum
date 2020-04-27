package tk.tarajki.atum.copy;


import org.springframework.web.bind.annotation.*;
import tk.tarajki.atum.book.*;

import java.util.List;

@RestController
@RequestMapping("/copies")
public class CopyController {

    private CopyService copyService;


    public CopyController(CopyService copyService) {
        this.copyService = copyService;
    }

    @GetMapping
    public List<CopyDto> findCopies(@ModelAttribute CopyFilter copyFilter){
        return copyService.findCopies(copyFilter);
    }


    @PostMapping
    public void addCopy(@RequestBody CopyAddRequest copyAddRequest) {
        copyService.addCopy(copyAddRequest);
    }




}
