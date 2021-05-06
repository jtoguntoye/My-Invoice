package com.app.business.persistence.local_cache

import com.app.business.model.Client
import com.app.framework.persistence.local_cache.ClientDaoService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ClientCacheDataSourceImpl
@Inject
constructor(private val clientDaoService: ClientDaoService): ClientCacheDataSource {

        override suspend fun deleteClient(primaryKey: String)
            =  clientDaoService.deleteClient(primaryKey)

        override suspend fun deleteMultipleClients(clients: List<Client>)
         = clientDaoService.deleteMultipleClients(clients)

        override suspend fun insertOrUpdateClient(client: Client)
                =clientDaoService.insertOrUpdateClient(client)

}