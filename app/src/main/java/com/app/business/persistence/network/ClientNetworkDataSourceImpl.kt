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

    override suspend fun insertNewClient(client: Client)
     = clientFireStoreService.insertNewClient(client)

    override suspend fun deleteClient(primaryKey: Int)
     = clientFireStoreService.deleteClient(primaryKey)

    override suspend fun deleteMultipleClients(clients: List<Client>)
     = clientFireStoreService.deleteMultipleClients(clients)

    override suspend fun updateClient(primaryKey: Int, client: Client)
     = clientFireStoreService.updateClient(primaryKey, client)
}