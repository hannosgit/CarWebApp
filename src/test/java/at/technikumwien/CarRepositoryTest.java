package at.technikumwien;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

// integration test

@SpringBootTest
@Transactional   // rollbacks transaction after each test method
@ActiveProfiles("test")
@Tag("extended")
public class CarRepositoryTest {
	@Autowired
	private CarRepository carRepository;
		
	@Test
	public void testFindAll() {
		var persons = carRepository.findAll();
		
		assertEquals(2, persons.size());
	}
	

}
