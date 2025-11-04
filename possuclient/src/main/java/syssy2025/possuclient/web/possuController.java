package syssy2025.possuclient.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
public class possuController {

    @Autowired
    private WebClient webClient;


    @GetMapping("/possu")
        public String possu() {
            return "possu";
    }

    @GetMapping("/hae")
    @ResponseBody
    public ResponseEntity<String> getLiput() {
        return webClient.get()
                .uri("/api/tickets")
                .retrieve()
                .toEntity(String.class)
                .block();
    }

    @GetMapping("/hae/{code}")
    @ResponseBody
    public ResponseEntity<String> getLippu(@PathVariable String code) {
        return webClient.get()
                .uri("/api/tickets?code={code}", code)
                .retrieve()
                .toEntity(String.class)
                .block();
    }

    @PatchMapping("/kayta/{id}")
    @ResponseBody
    public ResponseEntity<String> useLippu(@PathVariable String id) {
        String body = "{\"used\":\"2023-11-07T07:03:46\"}";

        return webClient.patch()
                .uri("/api/tickets/{id}", id)
                .header("Content-Type", "application/json")
                .bodyValue(body)
                .retrieve()
                .toEntity(String.class)
                .block();
    }
}