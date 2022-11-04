package steammend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;

@EnableJpaAuditing
=======
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;

import steammend.model.dto.AttachmentsDTO;

@EnableJpaAuditing
//@EnableConfigurationProperties({AttachmentsDTO.class})

>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
@SpringBootApplication
public class SteammendBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SteammendBeApplication.class, args);
	}

<<<<<<< HEAD
	@Bean
=======
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
	public PageableHandlerMethodArgumentResolverCustomizer customizer() {
		return p -> {
			p.setOneIndexedParameters(true);
			p.setMaxPageSize(10);
		};
	}
}
