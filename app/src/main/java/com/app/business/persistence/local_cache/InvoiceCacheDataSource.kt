package com.app.business.persistence.local_cache

import com.app.business.model.Invoice

interface InvoiceCacheDataSource {

    suspend fun insertNewInvoice(invoice: Invoice): Long

    suspend fun deleteInvoice(primaryKey: Int): Int

    suspend fun deleteMultipleInvoices(invoices: List<Invoice>): Int

    suspend fun updateInvoice(primaryKey: Int, invoice: Invoice): Long

}