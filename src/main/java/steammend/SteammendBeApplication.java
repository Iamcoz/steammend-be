package steammend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import steammend.model.dto.AttachmentsDTO;

@EnableJpaAuditing
//@EnableConfigurationProperties({AttachmentsDTO.class})

@SpringBootApplication
public class SteammendBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SteammendBeApplication.class, args);
	}

}
