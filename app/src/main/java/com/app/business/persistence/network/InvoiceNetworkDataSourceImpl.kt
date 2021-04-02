package com.app.business.persistence.network

import com.app.business.model.Invoice
import com.app.framework.persistence.network.InvoiceFireStoreService

class InvoiceNetworkDataSourceImpl
    constructor(
        private val invoiceFireStoreService: InvoiceFireStoreService
    ): InvoiceNetworkDataSource {
    override suspend fun insertNewInvoice(invoice: Invoice)
            = invoiceFireStoreService.insertNewInvoice(invoice)

    override suspend fun deleteInvoice(primaryKey: Int)
            = invoiceFireStoreService.deleteInvoice(primaryKey)

    override suspend fun deleteMultipleInvoices(invoices: List<Invoice>)
            =invoiceFireStoreService.deleteMultipleInvoices(invoices)

    override suspend fun updateInvoice(primaryKey: Int, invoice: Invoice)
             = invoiceFireStoreService.updateInvoice(primaryKey, invoice)
}