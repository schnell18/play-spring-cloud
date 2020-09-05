package tk.tinkerit.cloudplay.greet.controller.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient("greeting-service")
public interface GreetingClient {
    @RequestMapping(method = RequestMethod.GET, value = "/hi/{name}")
    Map<String, String> greet(@PathVariable("name") String name);
}
