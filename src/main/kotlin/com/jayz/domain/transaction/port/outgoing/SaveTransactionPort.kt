package com.jayz.domain.transaction.port.outgoing

import com.jayz.domain.transaction.port.incoming.SaveTransactionUseCase.SaveTransactionCommand

interface SaveTransactionPort {
    fun saveTransaction(saveTransactionCommand: SaveTransactionCommand)
}