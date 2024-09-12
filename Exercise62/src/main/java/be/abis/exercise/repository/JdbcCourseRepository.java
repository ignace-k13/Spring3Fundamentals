package be.abis.exercise.repository;

import be.abis.exercise.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
@Profile("prod")
public class JdbcCourseRepository implements CourseRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;


	@Override
	public List<Course> findAllCourses() {
		return jdbcTemplate.query("select * from abiscourses",new CourseMapper());
	}

	@Override
	public Course findCourse(int id) {
	    return jdbcTemplate.queryForObject("select * from abiscourses where cid=?",new CourseMapper(),id+"");
	}

	@Override
	public Course findCourse(String shortTitle) {
		return jdbcTemplate.queryForObject("select * from abiscourses where rtrim(cstitle)=?",new CourseMapper(),shortTitle);
	}

	@Override
	public void addCourse(Course c) {
		jdbcTemplate.update("insert into abiscourses(cid,cstitle,cltitle,cdur,caprice) values(?,?,?,?,?)",c.getCourseId(),c.getShortTitle(),c.getLongTitle(),c.getNumberOfDays(),c.getPricePerDay());
	}

	@Override
	public void updateCourse(Course c) {
        jdbcTemplate.update("update abiscourses set cstitle=?,cltitle=?,cdur=?,caprice=? where cid=?",c.getShortTitle(),c.getLongTitle(),c.getNumberOfDays(),c.getPricePerDay(),c.getCourseId());
	}

	@Override
	public void deleteCourse(int id) {
		jdbcTemplate.update("delete from abiscourses where cid=?",id);
	}


	private static final class CourseMapper implements RowMapper<Course> {
		public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
			Course course = new Course();
			course.setCourseId(rs.getString("cid"));
			course.setShortTitle(rs.getString("cstitle"));
			course.setLongTitle(rs.getString("cltitle"));
			course.setNumberOfDays(rs.getInt("cdur"));
			course.setPricePerDay(rs.getDouble("caprice"));
			return course;
		}
	}


}
