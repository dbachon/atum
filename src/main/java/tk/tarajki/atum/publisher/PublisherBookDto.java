package tk.tarajki.atum.publisher;

public class PublisherBookDto {
    private Long id;
    private String name;
    private String telephone;
    private String email;

    public PublisherBookDto(Publisher publisher) {
        this.id = publisher.getId();
        this.name = publisher.getName();
        this.telephone = publisher.getTelephone();
        this.email = publisher.getEmail();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
