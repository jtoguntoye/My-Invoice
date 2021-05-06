package com.app.business.persistence.network

import com.app.business.model.Client

class FakeClientNetworkDataSource
constructor(
    private val clientsData: HashMap<String, Client>,
 ): ClientNetworkDataSource {
    override suspend fun insertOrUpdateClient(client: Client) {
        clientsData.put(client.id, client)
    }

    override suspend fun deleteClient(primaryKey: String) {
        clientsData.remove(primaryKey)
    }

    override suspend fun deleteMultipleClients(clients: List<Client>) {

        for(client in clients) {
                clientsData.remove(client.id)
        }
    }
}