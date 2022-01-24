package com.jayz.infrastructure.repository.h2.repository

import com.jayz.infrastructure.repository.h2.entity.TransactionsEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.math.BigDecimal
import java.time.LocalDateTime

@Repository
interface TransactionsRepository : JpaRepository<TransactionsEntity, Long>,
    JpaSpecificationExecutor<TransactionsEntity> {

    @Query(
        value = "SELECT HOUR(created_at) as id, CONCAT(FORMATDATETIME(created_at,'yyyy-MM-dd'),'T',HOUR(created_at),':00:00') as created_at, sum(amount) as amount " +
                "FROM TRANSACTIONS WHERE created_at >= :start and created_at <= :end GROUP BY HOUR(created_at), CONCAT(FORMATDATETIME(created_at,'yyyy-MM-dd'),'T',HOUR(created_at),':00:00')",
        nativeQuery = true
    )
    fun getTransactionsPerHour(start: LocalDateTime, end: LocalDateTime): MutableList<TransactionsEntity>

    @Query(
        value = "SELECT sum(amount) as amount " +
                "FROM TRANSACTIONS WHERE created_at < :start",
        nativeQuery = true
    )
    fun sumBefore(start: LocalDateTime): BigDecimal?
}