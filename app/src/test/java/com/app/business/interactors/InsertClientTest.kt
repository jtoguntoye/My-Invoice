package com.app.business.interactors

import com.app.business.di.DependencyContainer
import com.app.business.interactors.main.InsertClient
import com.app.business.persistence.local_cache.ClientCacheDataSource
import com.app.business.persistence.network.ClientNetworkDataSource

class InsertClientTest {

    //system in test
    private val insertClient: InsertClient

    //dependencies
    private val dependencyContainer: DependencyContainer
    private val clientCacheDataSource: ClientCacheDataSource
    private val clientNetworkDataSource: ClientNetworkDataSource

    init{
        dependencyContainer = DependencyContainer()
        dependencyContainer.build()
        clientCacheDataSource = dependencyContainer.clientCacheDataSource
        clientNetworkDataSource = dependencyContainer.clientNetworkDataSource
        insertClient = InsertClient(clientNetworkDataSource,clientCacheDataSource)
    }
}