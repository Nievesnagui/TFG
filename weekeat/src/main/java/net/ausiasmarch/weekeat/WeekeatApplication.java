package net.ausiasmarch.weekeat;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WeekeatApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeekeatApplication.class, args);
	}
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
