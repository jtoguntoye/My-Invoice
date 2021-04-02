package com.app.business.persistence.network

import com.app.business.model.Invoice

interface InvoiceNetworkDataSource {

    suspend fun insertNewInvoice(invoice: Invoice)

    suspend fun deleteInvoice(primaryKey: Int)

    suspend fun deleteMultipleInvoices(invoices: List<Invoice>)

    suspend fun updateInvoice(primaryKey: Int, invoice: Invoice)
}