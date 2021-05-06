package com.app.business.persistence.local_cache

import android.text.format.DateUtils
import com.app.business.model.Client

const val FORCE_DELETE_CLIENT_EXCEPTION = "FORCE_DELETE_CLIENT_EXCEPTION"
const val FORCE_DELETES_CLIENT_EXCEPTION = "FORCE_DELETES_CLIENT_EXCEPTION"
const val FORCE_UPDATE_CLIENT_EXCEPTION = "FORCE_UPDATE_CLIENT_EXCEPTION"
const val FORCE_NEW_CLIENT_EXCEPTION = "FORCE_NEW_CLIENT_EXCEPTION"
const val FORCE_SEARCH_CLIENTS_EXCEPTION = "FORCE_SEARCH_CLIENTS_EXCEPTION"
const val FORCE_GENERAL_FAILURE = "FORCE_GENERAL_FAILURE"

class FakeClientCacheDataSourceImpl
constructor(
    private val clientsData: HashMap<String, Client>
): ClientCacheDataSource {

    override suspend fun deleteClient(primaryKey: String): Int {
        if(primaryKey.equals(FORCE_NEW_CLIENT_EXCEPTION)) {
            throw Exception("Something went wrong")
        }
        if(primaryKey.equals(FORCE_GENERAL_FAILURE)){
            return -1
        }
        return clientsData.remove(primaryKey)?.let{
            1 //return 1 for success
        }?: -1 //-1 for failure
    }

    override suspend fun deleteMultipleClients(clients: List<Client>): Int {
        var failOrSuccess = 1
        for(client in clients){
            if(clientsData.remove(client.id) == null){
                failOrSuccess = -1 // mark for failure
            }
        }
        return failOrSuccess
    }

    override suspend fun insertOrUpdateClient(client: Client): Long {
        if(client.id.equals(FORCE_NEW_CLIENT_EXCEPTION)) {
            throw Exception("Something went wrong")
        }
        if(client.id.equals(FORCE_GENERAL_FAILURE)){
            return -1
        }
        clientsData.put(client.id, client)
        return 1; //SUCCESS
    }
}