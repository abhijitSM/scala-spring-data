package com.example.data

import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource
import org.springframework.jdbc.datasource.embedded.{EmbeddedDatabaseType, EmbeddedDatabaseBuilder}
import org.springframework.orm.jpa.{JpaTransactionManager, LocalContainerEntityManagerFactoryBean}
import org.springframework.orm.jpa.vendor.{Database, HibernateJpaVendorAdapter}
import org.springframework.transaction.PlatformTransactionManager

/**
 * Created by abhisingh on 08/06/14.
 */

@Configuration
@EnableTransactionManagement
class InfrastructureConfig {

  @Bean
  def dataSource: DataSource = {
    val builder: EmbeddedDatabaseBuilder = new EmbeddedDatabaseBuilder
    builder.setType(EmbeddedDatabaseType.HSQL).build
  }

  @Bean
  def entityManagerFactory: LocalContainerEntityManagerFactoryBean = {
    val vendorAdapter = new HibernateJpaVendorAdapter
    vendorAdapter.setDatabase(Database.HSQL)
    vendorAdapter.setGenerateDdl(true)

    val factory = new LocalContainerEntityManagerFactoryBean
    factory.setJpaVendorAdapter(vendorAdapter)
    factory.setPackagesToScan(getClass.getPackage.getName)
    factory.setDataSource(dataSource)
    factory
  }

  @Bean
  def transactionManager: PlatformTransactionManager = {
    val txManager = new JpaTransactionManager
    txManager.setEntityManagerFactory(entityManagerFactory.getObject)
    txManager
  }
}
