package com.app.model

data class Invoice(var clientName : String,
                   var dueDate: String,
                   var totalAmountDue: String,
                   var items: MutableList<Items>,
                   var paymentStatus: Boolean)