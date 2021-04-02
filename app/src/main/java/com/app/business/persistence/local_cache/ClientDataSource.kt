package com.app.business.persistence.local_cache

import com.app.business.model.Client
import com.app.business.model.Invoice

interface ClientDataSource {

    suspend fun insertNewClient(client: Client): Long

    suspend fun deleteClient(primaryKey: Int): Int

    suspend fun deleteMultipleClients(clients: List<Client>): Int

    suspend fun updateClient(primaryKey: Int, client: Client): Long
}