package com.app.framework.persistence.local_cache

import com.app.business.model.Invoice

interface InvoiceDaoService {
    fun insertNewInvoice(invoice: Invoice): Long

    fun deleteInvoice(primaryKey: Int):Int

    fun deleteMultipleInvoices(invoices: List<Invoice>):Int

    fun updateInvoice(invoice: Invoice):Long
}
