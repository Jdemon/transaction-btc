package com.jayz.domain.transaction.service

import com.jayz.domain.transaction.model.Transaction
import com.jayz.domain.transaction.port.incoming.GetTransactionsUseCase
import com.jayz.domain.transaction.port.incoming.SaveTransactionUseCase
import com.jayz.domain.transaction.port.incoming.SaveTransactionUseCase.SaveTransactionCommand
import com.jayz.domain.transaction.port.outgoing.GetTransactionsPort
import com.jayz.domain.transaction.port.outgoing.SaveTransactionPort
import com.jayz.infrastructure.repository.h2.entity.TransactionsEntity
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class TransactionService(
    private val saveTransactionPort: SaveTransactionPort,
    private val getTransactionsPort: GetTransactionsPort
) : SaveTransactionUseCase, GetTransactionsUseCase {
    override fun saveTransaction(transaction: SaveTransactionCommand) {
        saveTransactionPort.saveTransaction(transaction)
    }

    override fun getTransactions(getTransactionCommand: GetTransactionsUseCase.GetTransactionCommand): MutableList<Transaction> {
        var sum: BigDecimal =
            getTransactionsPort.getBeforeTransactions(getTransactionCommand.startDatetime) ?: BigDecimal.ZERO
        var results = getTransactionsPort.getTransactions(getTransactionCommand)

        return results.map {
            sum = sum.add(it.amount)
            Transaction(
                it.datetime,
                sum
            )
        }.toMutableList()

    }
}