package com.empMVC.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.empMVC.Entity.Employee;

public class RowMapperImpl implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee e1=new Employee();
		e1.setEid(rs.getInt(1));
		e1.setEname(rs.getString(2));
		e1.setEsalary(rs.getInt(3));
		e1.setGender(rs.getString(4));
		return e1;
	}

}
