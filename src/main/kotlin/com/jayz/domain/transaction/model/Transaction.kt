package com.jayz.domain.transaction.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer
import java.math.BigDecimal
import java.time.ZonedDateTime

data class Transaction(
    @JsonSerialize(using = ZonedDateTimeSerializer::class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    val datetime: ZonedDateTime,
    val amount: BigDecimal
)
