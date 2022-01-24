package com.jayz.infrastructure.configuration

import com.jayz.TransactionBtcApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@ComponentScan(basePackageClasses = [TransactionBtcApplication::class])
@Import(
    H2BeanConfiguration::class
)
class BeanConfiguration