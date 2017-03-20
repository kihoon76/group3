package com.jungang.config;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OracleConnectionTest {

	@Resource(name = "oracleDataSource")
	DataSource oracleDataSource;
	
	@Test
	public void testA_DataSourceObject() {
		assertThat(oracleDataSource, is(notNullValue()));
	}
	
	@Test
	public void testB_Connection() throws SQLException {
		Connection conn = null;
		try {
			conn = oracleDataSource.getConnection();
			Assert.assertTrue(true);
		} 
		catch (SQLException e) {
			
			Assert.assertTrue(e.getMessage(), false);
		} 
		finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
}
