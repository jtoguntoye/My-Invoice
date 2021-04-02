package com.app.framework.persistence.local_cache

import com.app.business.model.Client

interface ClientDaoService {

    suspend fun insertNewClient(client: Client): Long

    suspend fun deleteClient(primaryKey: Int): Int

    suspend fun deleteMultipleClients(clients: List<Client>): Int

    suspend fun updateClient(primaryKey: Int, client: Client): Long
}