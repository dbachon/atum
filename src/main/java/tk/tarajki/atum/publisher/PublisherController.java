package tk.tarajki.atum.publisher;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    private PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping
    public PublisherDto add(@RequestBody PublisherAddRequest publisherAddRequest) {
        return publisherService.add(publisherAddRequest);
    }

    @GetMapping
    public List<PublisherDto> findPublishers(@ModelAttribute PublisherFilter publisherFilter){
        return publisherService.findPublishers(publisherFilter);
    }

    @PatchMapping
    public void changePublisherSettings(@RequestBody PublisherSettingsRequest publisherSettingsRequest) {
        publisherService.changePublisherSettings(publisherSettingsRequest);
    }


}
