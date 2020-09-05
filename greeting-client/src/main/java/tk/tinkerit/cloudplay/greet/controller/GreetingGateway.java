package tk.tinkerit.cloudplay.greet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Profile;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Profile({"default", "insecure"})
@RestController
@RequestMapping("/api")
public class GreetingGateway {
    private final RestTemplate restTemplate;

    @Autowired
    public GreetingGateway(@LoadBalanced RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/greet/{name}")
    public Map<String, String> gateway(@PathVariable String name) {
        ParameterizedTypeReference<Map<String, String>> type =
            new ParameterizedTypeReference<Map<String, String>>() {};
        ResponseEntity<Map<String, String>> responseEntity = this.restTemplate.exchange(
            "http://greeting-service/hi/{name}",
            HttpMethod.GET,
            null,
            type,
            name
        );
        return responseEntity.getBody();
    }
}
