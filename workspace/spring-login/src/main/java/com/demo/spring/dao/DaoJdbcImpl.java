package com.demo.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class DaoJdbcImpl implements Dao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public User getUserById(String email) {
		User u1 = null;
		try {
			u1 = jdbcTemplate.queryForObject("select * from users where userid='" + email + "'", new RowMapper<User>() {

				@Override
				public User mapRow(ResultSet rs, int idx) throws SQLException {
					User user = new User();
					user.setUserName(rs.getString("USERID"));
					user.setPassword(rs.getString("PASSWORD"));

					return user;
				}
			});
		} catch (DataAccessException e) {
			System.out.println("Exception....");
		}
		return u1;
	}

}
