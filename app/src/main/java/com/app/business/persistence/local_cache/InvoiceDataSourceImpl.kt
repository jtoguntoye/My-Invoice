package com.app.business.persistence.local_cache

import com.app.business.model.Invoice
import com.app.framework.persistence.local_cache.InvoiceDaoService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InvoiceDataSourceImpl
@Inject
constructor (private val invoiceDaoService: InvoiceDaoService):
    InvoiceCacheDataSource {
    override suspend fun insertNewInvoice(invoice: Invoice)
            = invoiceDaoService.insertNewInvoice(invoice)

    override suspend fun deleteInvoice(primaryKey: Int)
            = invoiceDaoService.deleteInvoice(primaryKey)

    override suspend fun deleteMultipleInvoices(invoices: List<Invoice>)
            = invoiceDaoService.deleteMultipleInvoices(invoices)

    override suspend fun updateInvoice(primary: Int, invoice: Invoice)
            = invoiceDaoService.updateInvoice(invoice)


}