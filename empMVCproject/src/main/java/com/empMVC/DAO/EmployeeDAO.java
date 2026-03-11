package com.empMVC.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.empMVC.Entity.Employee;

public class EmployeeDAO {
		JdbcTemplate temp;

		public void setTemp(JdbcTemplate temp) {
			this.temp = temp;
		}
		
		//Inserting data
		public int save(Employee e) {
			String sql="insert into emp values(?,?,?,?)";
			return temp.update(sql,e.getEid(),e.getEname(),e.getEsalary(),e.getGender());
		}
		
		// update employee
		public int update(Employee e) {
		    String sql = "update emp set ename=?, esalary=?, gender=? where eid=?";
		    return temp.update(sql, e.getEname(), e.getEsalary(), e.getGender(), e.getEid());
		}
		
		//delete employee
		public int delete(int id) {
			String sql="delete from emp where eid=?";
			return temp.update(sql,id);
		}
		
		//Select All employee
		public List<Employee> getAllEmp() {
			String query="select * from emp";
			List<Employee>e=this.temp.query(query, new RowMapperImpl());
			return e;
		}
		
		
		//select all Employee
	/*
		public List<Employee> getAllEmp() {
		    return temp.query("select * from emp", new RowMapper<Employee>() {
		        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		            Employee e = new Employee();
		            e.setEid(rs.getInt("eid"));
		            e.setEname(rs.getString("ename"));
		            e.setEsalary(rs.getInt("esalary"));
		            e.setGender(rs.getString("gender"));
		            return e;
		        }
		    });
		}
	*/
		// Select single employee
		public Employee getEmpById(int id) {
			 String sql = "select * from emp where eid=?";
			RowMapper<Employee>rowmapper=new RowMapperImpl();
			Employee e1=this.temp.queryForObject(sql, rowmapper,id);
			return e1;
		}
			
		// Select single employee
	/*
	 	public Employee getEmpById(int id) {
		    String sql = "select * from emp where eid=?";
		    return temp.queryForObject(sql, new RowMapper<Employee>() {
		        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		            Employee e = new Employee();
		            e.setEid(rs.getInt("eid"));
		            e.setEname(rs.getString("ename"));
		            e.setEsalary(rs.getInt("esalary"));
		            e.setGender(rs.getString("gender"));
		            return e;
		        }
		    }, id);
		} 
	*/
		
		//employee exist or not
		public boolean existsById(int id) {
		    String sql = "select count(*) from emp where eid=?";
		    Integer count = temp.queryForObject(sql, Integer.class, id);
		    return count != null && count > 0;
		}
				
}
