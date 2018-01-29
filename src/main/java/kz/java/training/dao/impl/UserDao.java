package kz.java.training.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kz.java.training.dao.AbstractDao;
import kz.java.training.entity.User;

@Repository("userDao")
public class UserDao implements AbstractDao<User> {
	
	private SimpleJdbcInsert simpleJdbcInsert;
	private NamedParameterJdbcTemplate jdbcTemplate;
	private DataSource dataSource;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("user").usingColumns("username", "password");
		this.dataSource = dataSource;
	}

	@Override
	public User findEntityById(int id) {
		return null;
	}

	@Override
	public void deleteEntityById(int id) {
		
	}

	@Override
	public void insertEntity(User entity) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", entity.getUsername());
		params.addValue("password", entity.getPassword());
		this.simpleJdbcInsert.execute(params);
	}
	
	public boolean isUserExist(User user) {	
		String username = null;
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", user.getUsername());
		try {
		username = jdbcTemplate.queryForObject("SELECT username FROM user WHERE username = :username", params, String.class);
		} catch(EmptyResultDataAccessException ex) {}
		return username != null;
		
	}

}
