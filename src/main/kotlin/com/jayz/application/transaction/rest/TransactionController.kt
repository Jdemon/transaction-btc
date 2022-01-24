package com.jayz.application.transaction.rest

import com.jayz.application.base.model.BaseResponse
import com.jayz.application.transaction.model.GetTransactionRequest
import com.jayz.application.transaction.model.TransactionRequest
import com.jayz.domain.transaction.model.Transaction
import com.jayz.domain.transaction.port.incoming.GetTransactionsUseCase
import com.jayz.domain.transaction.port.incoming.SaveTransactionUseCase
import com.jayz.domain.transaction.port.incoming.SaveTransactionUseCase.SaveTransactionCommand
import com.jayz.infrastructure.repository.h2.entity.TransactionsEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TransactionController {

    @Autowired
    lateinit var saveTransactionUseCase: SaveTransactionUseCase

    @Autowired
    lateinit var getTransactionsUseCase: GetTransactionsUseCase

    @PostMapping(
        value = ["transaction"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun transaction(
        @RequestBody request: TransactionRequest
    ): BaseResponse<Transaction> {
        saveTransactionUseCase.saveTransaction(
            SaveTransactionCommand(
                request.datetime,
                request.amount
            )
        )
        return BaseResponse.ok(
            Transaction(
                request.datetime,
                request.amount
            )
        )
    }


    @PostMapping(
        value = ["get-transactions"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun transactions(
        @RequestBody request: GetTransactionRequest
    ): MutableList<Transaction> {
        return getTransactionsUseCase.getTransactions(
            GetTransactionsUseCase.GetTransactionCommand(
                request.startDatetime,
                request.endDatetime
            )
        )
    }
}