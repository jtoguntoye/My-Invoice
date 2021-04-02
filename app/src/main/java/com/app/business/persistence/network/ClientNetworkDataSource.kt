package com.app.business.persistence.network

import com.app.business.model.Client
import com.app.business.model.Invoice

interface ClientNetworkDataSource {

    suspend fun insertNewClient(client: Client)

    suspend fun deleteClient(primaryKey: Int)

    suspend fun deleteMultipleClients(clients: List<Client>)

    suspend fun updateClient(primaryKey: Int, client: Client)
}