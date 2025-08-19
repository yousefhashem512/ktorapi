package com.yousefh.database

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo
import org.litote.kmongo.coroutine.CoroutineDatabase

object MongoConnection {

    private const val CONNECTION_STRING =
        "mongodb+srv://yousefhashem128:QeZnUMyTI5m3xcCC@rezoapp.yszijb3.mongodb.net/?retryWrites=true&w=majority&appName=ReZoApp"

    private val client = KMongo.createClient(
        MongoClientSettings.builder()
            .applyConnectionString(ConnectionString(CONNECTION_STRING))
            .retryWrites(true)
            .build()
    ).coroutine

    fun getDatabase(): CoroutineDatabase {
        return client.getDatabase("ReZoAppDB")
    }
}

/*
* val client = MongoClients.create("mongodb+srv://yousefhashem128:QeZnUMyTI5m3xcCC@rezoapp.yszijb3.mongodb.net/?retryWrites=true&w=majority&appName=ReZoApp")
    val database = client.getDatabase("ReZoAppDB")
    val collection = database.getCollection("users")

    // إدخال تجريبي
    collection.insertOne(Document("name", "testUseranayousd"))
    * */