package com.app.framework.persistence.local_cache

import com.app.business.model.Client

interface ClientDaoService {

    suspend fun deleteClient(primaryKey: String): Int

    suspend fun deleteMultipleClients(clients: List<Client>): Int

    suspend fun insertOrUpdateClient(client: Client): Long
}