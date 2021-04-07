package com.app.business.persistence.local_cache

import com.app.business.model.Client
import com.app.framework.persistence.local_cache.ClientDaoService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ClientDataSourceImpl
@Inject
constructor(private val clientDaoService: ClientDaoService): ClientDataSource {

        override suspend fun insertClient(
                client: Client
        )
            =clientDaoService.insertClient(client)

        override suspend fun deleteClient(primaryKey: Int)
            =  clientDaoService.deleteClient(primaryKey)

        override suspend fun deleteMultipleClients(clients: List<Client>)
         = clientDaoService.deleteMultipleClients(clients)

        override suspend fun updateClient(id: String, client: Client)
                =clientDaoService.updateClient(id, client)

}