package com.jayz.infrastructure.repository.h2.entity

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(schema = "public", name = "transactions")
open class TransactionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long = 0

    @Column(nullable = false, name = "amount")
    open var amount: BigDecimal = BigDecimal.ZERO

    @Column(nullable = false, name = "created_at")
    open var createdAt: LocalDateTime? = null
}
