package at.technikumwien;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;

@Configuration
@Profile("!test")
public class DBInitializer {
	@Autowired
	private CarRepository carRepository;
	
	@EventListener(ApplicationReadyEvent.class)
	public void handleApplicationEvent() {
		carRepository.saveAll(
			List.of(
				new Car("green", "Mini", 2),
				new Car("blue", "VW", 4)
			)
		);
	}
}
