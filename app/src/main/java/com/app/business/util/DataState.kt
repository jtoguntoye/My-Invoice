package com.app.business.util

data class DataState<T>
    (var data : T?= null,
     var message: String? = null ) {

    companion object {


        fun <T> data(
            data: T? = null,
            message: String? = null
        ): DataState<T> {
            return DataState(
                data = data,
                message = message
            )
        }

        fun <T> error(
            message: String? = null
        ): DataState<T> {
            return DataState(
                data = null,
                message =  message
            )
        }
    }

}