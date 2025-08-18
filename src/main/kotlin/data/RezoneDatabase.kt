package com.yousefh.data

import com.yousefh.data.model.Property
import org.bson.types.ObjectId
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.eq
import org.litote.kmongo.reactivestreams.KMongo


private val client = KMongo.createClient().coroutine
private val database = client.getDatabase("ReZoAppDB")

private val properties = database.getCollection<Property>()

suspend fun getPropertyForId(id: String): Property? {
    return properties.findOneById(id)
}

suspend fun createOrUpdatePropertyForId(property: Property): Boolean {
    val propertyExists = properties.findOneById(property.id) != null
    return if (propertyExists) {
        properties.updateOneById(property.id, property).wasAcknowledged()
    } else {
        property.id = ObjectId().toHexString()
        properties.insertOne(property).wasAcknowledged()
    }
}

suspend fun deletePropertyForId(propertyId: String): Boolean {
    val property = properties.findOne(Property::id eq propertyId)
    property?.let { property ->
        return properties.deleteOneById(property.id).wasAcknowledged()
    } ?: return false
}