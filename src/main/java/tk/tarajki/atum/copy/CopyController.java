package tk.tarajki.atum.copy;


import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/title")
    public List<CopyDto> findCopiesByTitle(@ModelAttribute CopyFilter copyFilter) {
        return copyService.findCopiesByTitle(copyFilter);
    }

    @GetMapping("/all")
    public List<CopyDto> findAllCopies(@ModelAttribute CopyFilter copyFilter) {
        return copyService.findAllCopies(copyFilter);
    }

    @PatchMapping
    public void changeCopySettings(@RequestBody CopySettingsRequest copySettingsRequest) {
        copyService.changeCopySettings(copySettingsRequest);
    }


    @PostMapping
    public void addCopy(@RequestBody CopyAddRequest copyAddRequest) {
        copyService.addCopy(copyAddRequest);
    }




}
