package com.yousefh.database

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoDatabase
import org.litote.kmongo.KMongo
import org.litote.kmongo.util.KMongoUtil

object MongoConnection {

    // ⚠️ خليك متأكد إن الباسورد متشفر أو مستخدم من Environment Variables
    private const val CONNECTION_STRING =
        "mongodb+srv://yousefhashem128:QeZnUMyTI5m3xcCC@rezoapp.yszijb3.mongodb.net/?retryWrites=true&w=majority&appName=ReZoApp"

    // أنشئ الكلاينت من الكونفيج
    private val client = KMongo.createClient(
        MongoClientSettings.builder()
            .applyConnectionString(ConnectionString(CONNECTION_STRING))
            .retryWrites(true)
            .build()
    )

    // حدد اسم الـ DB اللي انت عايزه
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