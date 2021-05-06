package com.app.business.persistence.network

import com.app.business.model.Client

interface ClientNetworkDataSource {

    suspend fun insertOrUpdateClient(client: Client)

    suspend fun deleteClient(primaryKey: String)

    suspend fun deleteMultipleClients(clients: List<Client>)

}