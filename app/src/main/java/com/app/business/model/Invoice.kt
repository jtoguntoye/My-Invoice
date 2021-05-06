package com.app.business.model

data class Invoice(
         var primaryKey: Int,
         var clientName : String,
         var clientEmail: String,
         var dueDate: String,
         var totalAmountDue: String,
         var items: MutableList<Items>,
         var paymentStatus: Boolean)