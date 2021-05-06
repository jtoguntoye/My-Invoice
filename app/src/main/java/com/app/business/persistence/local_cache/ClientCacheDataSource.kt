package com.app.business.persistence.local_cache

import com.app.business.model.Client

interface ClientCacheDataSource {

    suspend fun insertOrUpdateClient(client: Client): Long

    suspend fun deleteClient(primaryKey: String): Int

    suspend fun deleteMultipleClients(clients: List<Client>): Int



}