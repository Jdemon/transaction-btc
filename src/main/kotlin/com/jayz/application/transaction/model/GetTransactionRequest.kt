package com.jayz.application.transaction.model

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer
import java.time.ZonedDateTime

data class GetTransactionRequest(
    @JsonSerialize(using = ZonedDateTimeSerializer::class)
    val startDatetime: ZonedDateTime,
    @JsonSerialize(using = ZonedDateTimeSerializer::class)
    val endDatetime: ZonedDateTime
)