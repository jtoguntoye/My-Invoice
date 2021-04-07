package com.app.business.persistence.local_cache

import com.app.business.model.Client

interface ClientDataSource {

    suspend fun insertClient(client: Client): Long

    suspend fun deleteClient(primaryKey: Int): Int

    suspend fun deleteMultipleClients(clients: List<Client>): Int

    suspend fun updateClient(id:String, client: Client): Long

}