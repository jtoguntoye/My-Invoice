package com.app.business.persistence.network

import com.app.business.model.Client
import com.app.framework.persistence.network.ClientFireStoreService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ClientNetworkDataSourceImpl
    @Inject
constructor(private val clientFireStoreService: ClientFireStoreService
    ) : ClientNetworkDataSource {

    override suspend fun insertOrUpdateClient(client: Client)
     = clientFireStoreService.insertNewClient(client)

    override suspend fun deleteClient(primaryKey: String)
     = clientFireStoreService.deleteClient(primaryKey)

    override suspend fun deleteMultipleClients(clients: List<Client>)
     = clientFireStoreService.deleteMultipleClients(clients)

    override suspend fun updateClient(id: String, client: Client)
     = clientFireStoreService.updateClient(id, client)
}