package com.jayz.application.transaction.model

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer
import java.math.BigDecimal
import java.time.ZonedDateTime

data class TransactionRequest(
    @JsonSerialize(using = ZonedDateTimeSerializer::class)
    val datetime: ZonedDateTime,
    val amount: BigDecimal
)
