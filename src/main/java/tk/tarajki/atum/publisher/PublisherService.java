package tk.tarajki.atum.publisher;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublisherService {

    private PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Transactional
    public PublisherDto add(PublisherAddRequest publisherAddRequest){
        Publisher publisher = new Publisher(
                publisherAddRequest.getName(),
                publisherAddRequest.getTelephone(),
                publisherAddRequest.getEmail()
        );
        publisherRepository.save(publisher);
        return new PublisherDto(publisher);
    }


    @Transactional
    public void changePublisherSettings(PublisherSettingsRequest publisherSettingsRequest) {
        Publisher publisher = publisherRepository.findByIdRequired(publisherSettingsRequest.getId());
        publisher.setName(publisherSettingsRequest.getName());
        publisher.setEmail(publisherSettingsRequest.getEmail());
        publisher.setTelephone(publisherSettingsRequest.getTelephone());
    }

    public List<PublisherDto>  findPublishers(PublisherFilter publisherFilter){
        if (publisherFilter.getName() != null) {
            return publisherRepository.findPublishersByNameLike("%" + publisherFilter.getName() + "%").stream().map(PublisherDto::new).collect(Collectors.toList());
        }
        return publisherRepository.findAllList().stream().map(PublisherDto::new).collect(Collectors.toList());

    }
}
