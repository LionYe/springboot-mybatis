package club.lionye.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
public class MyBatisConfig {

	@Autowired
	private TomcatPoolConfig tomcatPoolConfig;
	
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(tomcatPoolConfig.dataSource());
		
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setConfigLocation(resolver.getResource("mybatis-config.xml"));
//		sqlSessionFactoryBean
//			.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));

		 return sqlSessionFactoryBean.getObject();
	}
	
	@Bean(name="sqlSession")
	@Scope("prototype")
	public SqlSessionTemplate openSession() throws Exception{
		
		return new SqlSessionTemplate (sqlSessionFactoryBean());
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(tomcatPoolConfig.dataSource());
	}
	
//	@Value("${ehcache.path}")
//	public void ehcacheConfig(String path){
//		
//		String ehcachePath = MyBatisConfig.class.getClassLoader().getResource("").getPath()+path;
//		
//		EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
//		ehCacheManagerFactoryBean.setConfigLocation(new PathResource(ehcachePath));
//		
//	}
	
}
