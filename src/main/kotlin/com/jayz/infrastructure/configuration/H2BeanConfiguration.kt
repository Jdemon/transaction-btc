package com.jayz.infrastructure.configuration

import com.jayz.infrastructure.BasePackage
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.Profile
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Import(H2BeanConfiguration.WithDB::class)
class H2BeanConfiguration {

    @EnableJpaRepositories(basePackageClasses = [BasePackage::class])
    class WithDB
}