package com.jayz.domain.transaction.port.outgoing

import com.jayz.domain.transaction.model.Transaction
import com.jayz.domain.transaction.port.incoming.GetTransactionsUseCase.GetTransactionCommand
import java.math.BigDecimal
import java.time.ZonedDateTime

interface GetTransactionsPort {
    fun getBeforeTransactions(startDateTime: ZonedDateTime): BigDecimal?
    fun getTransactions(getTransactionCommand: GetTransactionCommand): MutableList<Transaction>
}