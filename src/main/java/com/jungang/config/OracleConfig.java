package com.jungang.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jungang.annotation.OracleMapper;

@Configuration
@EnableTransactionManagement
@MapperScan(value=MyBatisConfig.BASE_PACKAGE, sqlSessionFactoryRef="oracleSqlSessionFactory", annotationClass=OracleMapper.class)
public class OracleConfig extends MyBatisConfig {

	@Bean(name="oracleDataSource")
	@ConfigurationProperties(prefix="spring.oracle.datasource")
	@Primary
	public DataSource oracleDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="oracleSqlSessionFactory")
	@Primary
	public SqlSessionFactory oracleSqlSessionFactory(@Qualifier("oracleDataSource") DataSource oracleDataSource, ApplicationContext ctx ) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		configureSqlSessionFactory(sqlSessionFactoryBean, oracleDataSource);
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean(name="oracleSqlSessionTemplate")
	@Primary
	public SqlSessionTemplate oracleSqlSessionTemplate(SqlSessionFactory oracleSqlSessionFactory) {
		return new SqlSessionTemplate(oracleSqlSessionFactory);
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(@Qualifier("oracleDataSource") DataSource ds) {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(ds);
		transactionManager.setGlobalRollbackOnParticipationFailure(false);
		return transactionManager;
	}
}
