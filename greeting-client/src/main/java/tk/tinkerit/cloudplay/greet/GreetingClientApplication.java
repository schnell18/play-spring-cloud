package tk.tinkerit.cloudplay.greet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GreetingClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingClientApplication.class, args);
	}
}
