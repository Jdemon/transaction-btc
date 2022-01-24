package com.jayz.domain.transaction.port.incoming

import org.valiktor.functions.isNotNull
import org.valiktor.functions.isNotZero
import org.valiktor.validate
import java.math.BigDecimal
import java.time.ZonedDateTime

interface SaveTransactionUseCase {
    data class SaveTransactionCommand(
        val datetime: ZonedDateTime,
        val amount: BigDecimal
    ) {
        init {
            validate(this) {
                validate(SaveTransactionCommand::datetime).isNotNull()
                validate(SaveTransactionCommand::amount).isNotZero()
            }
        }
    }

    fun saveTransaction(saveTransaction: SaveTransactionCommand)
}