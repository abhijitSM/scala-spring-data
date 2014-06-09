package com.example.data

import org.springframework.context.annotation.{AnnotationConfigApplicationContext, Bean, Import, Configuration}
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import javax.sql.DataSource
import org.springframework.jdbc.datasource.embedded.{EmbeddedDatabaseType, EmbeddedDatabaseBuilder}
import org.springframework.orm.jpa.{JpaTransactionManager, LocalContainerEntityManagerFactoryBean}
import org.springframework.orm.jpa.vendor.{Database, HibernateJpaVendorAdapter}
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement

/**
 * Created by abhisingh on 08/06/14.
 */

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
@Import(Array(classOf[InfrastructureConfig]))
class AppConfig {
}
