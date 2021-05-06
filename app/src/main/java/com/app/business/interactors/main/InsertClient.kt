package com.app.business.interactors.main

import com.app.business.model.Client
import com.app.business.persistence.local_cache.ClientCacheDataSource
import com.app.business.persistence.network.ClientNetworkDataSource
import com.app.business.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*


class InsertClient
    constructor(
        val clientNetworkDataSource: ClientNetworkDataSource,
        val clientCacheDataSource: ClientCacheDataSource
    ) {



    fun insertOrUpdateClient(
        id: String? = null,
        clientName: String,
        clientEmail: String,
        phoneNumber: String
    ): Flow<DataState<Client>?> = flow {

        val newClient = Client(
            id ?: UUID.randomUUID().toString(),
            clientName, clientEmail, phoneNumber
        )

        val cacheResult = clientCacheDataSource.insertOrUpdateClient(newClient)
        var cacheResponse: DataState<Client>?
        if(cacheResult > 0) {
        cacheResponse = DataState.data(
            newClient,
            INSERT_CLIENT_SUCCESS
        )
        }
        else{
            cacheResponse = DataState.error(INSERT_CLIENT_FAILED)
        }
        emit(cacheResponse)

        updateNetwork(cacheResponse.message, newClient)
    }

//    fun UpdateClient(
//        id: String,
//        clientName: String,
//        clientEmail: String,
//        phoneNumber: String
//    ): Flow<DataState<Client>?> = flow {
//
//        val updatedClient = Client(
//            id,
//            clientName, clientEmail, phoneNumber
//        )
//
//        val cacheResult = clientDataSource.insertOrUpdateClient(id, updatedClient)
//        var cacheResponse: DataState<Client>? = null
//        if(cacheResult > 0) {
//            cacheResponse = DataState.data(
//                updatedClient,
//                UPDATE_CLIENT_SUCCESS
//            )
//        }
//        else{
//            cacheResponse = DataState.error(UPDATE_CLIENT_FAILED)
//        }
//        emit(cacheResponse)
//
//        updateNetwork(cacheResponse.message, updatedClient)
//    }



    private suspend fun updateNetwork(responseMessage: String?, newClient: Client){
        if(responseMessage.equals(INSERT_CLIENT_SUCCESS)) {
            clientNetworkDataSource.insertOrUpdateClient(newClient)
        }
    }







    companion object{
        val INSERT_CLIENT_SUCCESS = "Successfully inserted new client."
        val INSERT_CLIENT_FAILED = "Failed to insert new client."
        val UPDATE_CLIENT_SUCCESS = "Successfully updated client/'s details"
        val UPDATE_CLIENT_FAILED = "Failed to update client/'s details"
     }
}