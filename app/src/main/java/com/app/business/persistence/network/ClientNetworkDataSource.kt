package com.app.business.persistence.network

import com.app.business.model.Client

interface ClientNetworkDataSource {

    suspend fun insertNewClient(client: Client)

    suspend fun deleteClient(primaryKey: Int)

    suspend fun deleteMultipleClients(clients: List<Client>)

    suspend fun updateClient(id: String, client: Client)
}