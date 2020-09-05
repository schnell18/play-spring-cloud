package tk.tinkerit.cloudplay.greet.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@RestController
public class GreetingController {
    @GetMapping("/hi/{name}")
    public Map<String, String> hi(
        @PathVariable String name,
        @RequestHeader(value = "X-CNJ-Name", required = false) Optional<String> cn
    ) {
        String resolvedName = cn.orElse(name);
        System.out.printf("Hi %s\n", resolvedName);
        return Collections.singletonMap("greeting", "Hello, " + resolvedName);
    }
}
