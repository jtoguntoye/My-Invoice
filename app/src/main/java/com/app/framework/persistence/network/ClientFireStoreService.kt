package com.app.framework.persistence.network

import com.app.business.model.Client

interface ClientFireStoreService {

    suspend fun insertNewClient(client: Client)

    suspend fun deleteClient(primaryKey: Int)

    suspend fun deleteMultipleClients(clients: List<Client>)

    suspend fun updateClient(primaryKey: Int, client: Client)
}