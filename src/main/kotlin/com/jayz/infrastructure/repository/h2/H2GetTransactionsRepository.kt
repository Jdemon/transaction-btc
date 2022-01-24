package com.jayz.infrastructure.repository.h2

import com.jayz.domain.transaction.model.Transaction
import com.jayz.domain.transaction.port.incoming.GetTransactionsUseCase.GetTransactionCommand
import com.jayz.domain.transaction.port.outgoing.GetTransactionsPort
import com.jayz.infrastructure.repository.h2.entity.TransactionsEntity
import com.jayz.infrastructure.repository.h2.repository.TransactionsRepository
import org.springframework.stereotype.Repository
import java.math.BigDecimal
import java.time.ZoneId
import java.time.ZonedDateTime

@Repository
class H2GetTransactionsRepository(
    private val transactionsRepository: TransactionsRepository
) : GetTransactionsPort {
    override fun getBeforeTransactions(startDateTime: ZonedDateTime): BigDecimal? =
        transactionsRepository.sumBefore(startDateTime.toLocalDateTime())

    override fun getTransactions(getTransactionCommand: GetTransactionCommand): MutableList<Transaction> {
        return transactionsRepository.getTransactionsPerHour(
            getTransactionCommand.startDatetime.toLocalDateTime(),
            getTransactionCommand.endDatetime.toLocalDateTime()
        ).map {
            Transaction(
                it.createdAt!!.atZone(ZoneId.of("UTC")),
                it.amount
            )
        }.toMutableList()
    }

}