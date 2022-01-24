package com.jayz.domain.transaction.port.incoming

import com.jayz.domain.transaction.model.Transaction
import com.jayz.infrastructure.repository.h2.entity.TransactionsEntity
import org.valiktor.functions.isGreaterThanOrEqualTo
import org.valiktor.functions.isNotNull
import org.valiktor.validate
import java.time.ZonedDateTime

interface GetTransactionsUseCase {

    data class GetTransactionCommand(
        val startDatetime: ZonedDateTime,
        val endDatetime: ZonedDateTime
    ) {
        init {
            validate(this) {
                validate(GetTransactionCommand::startDatetime).isNotNull()
                validate(GetTransactionCommand::endDatetime)
                    .isNotNull()
                    .isGreaterThanOrEqualTo(startDatetime)
            }
        }
    }

    fun getTransactions(getTransactionCommand: GetTransactionCommand): MutableList<Transaction>
}