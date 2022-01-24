package com.jayz.application.base.model

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
class BaseResponse<DataResponse>(
    var status: ResponseStatus? = null,
    var data: DataResponse? = null
) {

    companion object {

        private val successStatus = ResponseStatus(
            code = "200",
            message = "success"
        )

        fun ok(): BaseResponse<Nothing> {
            return BaseResponse(successStatus)
        }

        fun <T> ok(data: T): BaseResponse<T> {
            return BaseResponse(
                successStatus,
                data
            )
        }

        fun <T> instant(status: ResponseStatus, data: T): BaseResponse<T> {
            return BaseResponse(status, data)
        }

        fun instant(status: ResponseStatus): BaseResponse<Nothing> {
            return BaseResponse(status)
        }
    }
}