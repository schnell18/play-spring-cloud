package tk.tinkerit.cloudplay.greet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.tinkerit.cloudplay.greet.controller.feign.GreetingClient;

import java.util.Map;

@Profile({"default", "insecure"})
@RestController
@RequestMapping("/api")
public class GreetingGateway {
    private final GreetingClient greetingClient;

    @Autowired
    public GreetingGateway(GreetingClient greetingClient) {
        this.greetingClient = greetingClient;
    }

    @GetMapping("/greet/{name}")
    public Map<String, String> gateway(@PathVariable String name) {
        return this.greetingClient.greet(name);
    }
}
