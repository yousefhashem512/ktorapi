package com.yousefh.database

import org.litote.kmongo.KMongo
import com.mongodb.client.MongoDatabase

object MongoConnection {
    private const val CONNECTION_STRING = "mongodb+srv://yousefhashem128:QeZnUMyTI5m3xcCC@rezoapp.yszijb3.mongodb.net/?retryWrites=true&w=majority&appName=ReZoApp"

    private val client = KMongo.createClient(CONNECTION_STRING)

    fun getDatabase(): MongoDatabase {
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