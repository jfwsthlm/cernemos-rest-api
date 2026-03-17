package se.sthlm.jfw.cernemos.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import se.sthlm.jfw.cernemos.api.data.Rot13CipherRequest;
import se.sthlm.jfw.cernemos.api.data.Rot13CipherResponse;
import se.sthlm.jfwsthlm.cernemos.cipher.Rot13;

@RestController
public class RestApiController
{
    @PostMapping("/rot13")
    public Rot13CipherResponse rot13(@RequestBody Rot13CipherRequest rot13CipherRequest) {
        String plaintext = rot13CipherRequest.getText();
        Rot13 rot13 = new Rot13();
        return new Rot13CipherResponse(rot13.cipher(plaintext));
    }
}