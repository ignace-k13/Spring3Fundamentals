package be.abis.exercise;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
@ActiveProfiles("prod")
public class TestDataSource {

	@Autowired
	DataSource dataSource;

	@Test
	public void testConnectionViaDataSource() {
		try (Connection c = dataSource.getConnection()) {

			System.out.println("connection succeeded via "
					+ c.getMetaData().getDatabaseProductName() + ". ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
