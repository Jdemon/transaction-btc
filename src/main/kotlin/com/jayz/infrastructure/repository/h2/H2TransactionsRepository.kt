package com.jayz.infrastructure.repository.h2

import com.jayz.domain.transaction.port.incoming.SaveTransactionUseCase.SaveTransactionCommand
import com.jayz.domain.transaction.port.outgoing.SaveTransactionPort
import com.jayz.infrastructure.repository.h2.entity.TransactionsEntity
import com.jayz.infrastructure.repository.h2.repository.TransactionsRepository
import org.springframework.stereotype.Repository

@Repository
class H2TransactionsRepository(
    private val transactionsRepository: TransactionsRepository
) : SaveTransactionPort {
    override fun saveTransaction(saveTransactionCommand: SaveTransactionCommand) {
        transactionsRepository.save(TransactionsEntity().also {
            it.amount = saveTransactionCommand.amount
            it.createdAt = saveTransactionCommand.datetime.toLocalDateTime()
        })
    }
}