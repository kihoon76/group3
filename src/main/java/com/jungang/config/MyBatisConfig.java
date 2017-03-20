package com.jungang.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

public abstract class MyBatisConfig {

	public static final String BASE_PACKAGE = "com.jungang.mapper";
	public static final String TYPE_ALIASES_PACKAGE = "com.jungang.domain";
	public static final String CONFIG_LOCATION_PATH = "classpath:/templates/mybatis/mybatis-config.xml";
	public static final String MAPPER_LOCATIONS_PATH = "classpath:/mybatis/mapper/*.xml";
	
	protected void configureSqlSessionFactory(SqlSessionFactoryBean sqlSessionFactoryBean, DataSource dataSource) throws IOException {
		PathMatchingResourcePatternResolver pathResolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setTypeAliasesPackage(TYPE_ALIASES_PACKAGE);
		sqlSessionFactoryBean.setConfigLocation(pathResolver.getResource(CONFIG_LOCATION_PATH));
		sqlSessionFactoryBean.setMapperLocations(pathResolver.getResources(MAPPER_LOCATIONS_PATH));
		
	}
}
