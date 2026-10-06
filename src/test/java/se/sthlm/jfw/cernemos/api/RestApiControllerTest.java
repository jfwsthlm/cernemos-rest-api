package se.sthlm.jfw.cernemos.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RestApiController.class)
class RestApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void rot13_withValidRequest_returnsOkAndCiphertext() throws Exception {
        String jsonPayload = """
                {
                    "text": "HELLO"
                }
                """;

        mockMvc.perform(post("/rot13")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.text").value("URYYB"));
    }

    @Test
    void rot13_withEmptyText_returnsOkAndEmptyString() throws Exception {
        String jsonPayload = """
                {
                    "text": ""
                }
                """;

        mockMvc.perform(post("/rot13")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.text").value(""));
    }

    @Test
    void rot13_withInvalidJson_returnsBadRequest() throws Exception {
        String invalidJson = "{ \"text\": ";

        mockMvc.perform(post("/rot13")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    void rot13_withGetMethod_returnsMethodNotAllowed() throws Exception {
        mockMvc.perform(get("/rot13"))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    void substitution_withValidRequest_returnsOkAndSubstitutedText() throws Exception {
        String jsonPayload = """
                {
                    "originalText": "HELLO",
                    "substitutionMap": {
                        "H": "X",
                        "E": "Y",
                        "L": "Z",
                        "O": "W"
                    }
                }
                """;

        mockMvc.perform(post("/substitution")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.substitutedText").value("XYZZW"));
    }

    @Test
    void substitution_withEmptyMap_returnsOkAndOriginalTextReplacedWithDefaultChar()
        throws Exception {
        String jsonPayload = """
                {
                    "originalText": "HELLO",
                    "substitutionMap": {}
                }
                """;

        mockMvc.perform(post("/substitution")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.substitutedText").value("-----"));
    }

    @Test
    void substitution_withMissingContentType_returnsUnsupportedMediaType() throws Exception {
        String jsonPayload = """
                {
                    "originalText": "HELLO",
                    "substitutionMap": {}
                }
                """;

        mockMvc.perform(post("/substitution")
                        .content(jsonPayload))
                .andExpect(status().isUnsupportedMediaType());
    }
}