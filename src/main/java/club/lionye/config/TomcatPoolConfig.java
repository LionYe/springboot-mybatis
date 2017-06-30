package club.lionye.config;

import javax.annotation.PreDestroy;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class )
@EnableConfigurationProperties(TomcatPoolDataSourceProperties.class)
public class TomcatPoolConfig {

	@Autowired
	private TomcatPoolDataSourceProperties tomcatPoolDataSourceProperties;

	private org.apache.tomcat.jdbc.pool.DataSource pool;
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		
		TomcatPoolDataSourceProperties config = tomcatPoolDataSourceProperties;
		
		this.pool = new org.apache.tomcat.jdbc.pool.DataSource();
		
		this.pool.setDriverClassName(config.getDriverClassName());
		this.pool.setUrl(config.getUrl());
		if (config.getUsername() != null) {
			this.pool.setUsername(config.getUsername());
		}
		if (config.getPassword() != null) {
			this.pool.setPassword(config.getPassword());
		}
		this.pool.setInitialSize(config.getInitialSize());
		this.pool.setMaxActive(config.getMaxActive());
		this.pool.setMaxIdle(config.getMaxIdle());
		this.pool.setMinIdle(config.getMinIdle());
		this.pool.setTestOnBorrow(config.isTestOnBorrow());
		this.pool.setTestOnReturn(config.isTestOnReturn());
		this.pool.setValidationQuery(config.getValidationQuery());
		
		return this.pool;
	}

	@PreDestroy
	public void close() {
		if (this.pool != null) {
			this.pool.close();
		}
	}
	
}
