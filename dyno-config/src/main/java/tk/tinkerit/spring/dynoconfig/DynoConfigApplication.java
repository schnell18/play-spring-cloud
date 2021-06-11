package tk.tinkerit.spring.dynoconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@SpringBootApplication
public class DynoConfigApplication {
	@Resource
	private DynamicAppConfig dynamicAppConfig;

	@Bean
	@ConfigurationProperties(prefix = "dyno")
	public DynamicAppConfig dynamicAppConfig(){
		return new DynamicAppConfig();
	}

	@RequestMapping("/message")
	String getMessage() {
		return this.dynamicAppConfig.toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(DynoConfigApplication.class, args);
	}

}
