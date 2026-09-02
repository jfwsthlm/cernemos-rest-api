package se.sthlm.jfw.cernemos.api;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import se.sthlm.jfw.cernemos.api.data.Rot13CipherRequest;
import se.sthlm.jfw.cernemos.api.data.Rot13CipherResponse;
import se.sthlm.jfw.cernemos.api.data.SubstitutionCipherRequest;
import se.sthlm.jfw.cernemos.api.data.SubstitutionCipherResponse;
import se.sthlm.jfwsthlm.cernemos.cipher.Rot13;
import se.sthlm.jfwsthlm.cernemos.cipher.SubstitutionCipher;

@RestController
public class RestApiController
{
    @PostMapping("/rot13")
    public Rot13CipherResponse rot13(@RequestBody Rot13CipherRequest rot13CipherRequest) {
        String plaintext = rot13CipherRequest.getText();
        Rot13 rot13 = new Rot13();
        return new Rot13CipherResponse(rot13.cipher(plaintext));
    }

    @PostMapping("/substitution")
    public SubstitutionCipherResponse substitution(@RequestBody SubstitutionCipherRequest substitutionCipherRequest) {
        String originalText = substitutionCipherRequest.getOriginalText();
        Map<Character, Character> substitutionMap = substitutionCipherRequest.getSubstitutionMap();
        SubstitutionCipher substitutionCipher = new SubstitutionCipher();
        return new SubstitutionCipherResponse(substitutionCipher.substitute(originalText, substitutionMap));
    }
}