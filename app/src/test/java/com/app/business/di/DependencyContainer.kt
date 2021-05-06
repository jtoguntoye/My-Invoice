package com.app.business.di

import com.app.business.persistence.local_cache.ClientCacheDataSource
import com.app.business.persistence.local_cache.FakeClientCacheDataSourceImpl
import com.app.business.persistence.network.ClientNetworkDataSource
import com.app.business.persistence.network.FakeClientNetworkDataSource

class DependencyContainer {
    //dependencies that will be needed for the tests

    lateinit var clientNetworkDataSource: ClientNetworkDataSource
    lateinit var clientCacheDataSource: ClientCacheDataSource


    fun build() {
        clientCacheDataSource = FakeClientCacheDataSourceImpl(
            clientsData = HashMap()
        )
        clientNetworkDataSource = FakeClientNetworkDataSource(
            clientsData = HashMap()
        )
    }
}