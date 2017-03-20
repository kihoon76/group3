package com.jungang.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleServiceTest {
	
	@Autowired
	DataSource ds;
	
	Connection conn;

	@Before
	public void setUp() throws SQLException {
		conn = ds.getConnection();
	}
	
	@Test
	public void test01() {
		System.out.println("test====" + ds);
	}
	
	@After
	public void tearDown() throws SQLException {
		conn.close();
		conn = null;
	}
}
