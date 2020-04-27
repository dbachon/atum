package tk.tarajki.atum.auth;

import org.springframework.stereotype.Service;

@Service
public class TokenProvider {
    public String createToken(String subject){
        return subject;
    }

    public String getSubject(String token) {
        return token;
    }

}
