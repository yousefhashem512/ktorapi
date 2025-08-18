package com.yousefh.data.model

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class Property(
    @BsonId
    var id: String = ObjectId().toHexString(),
    val images: List<String> = emptyList(),
    val video: String? = null,
    val title: String,
    val description: String,
    val typeName: String,
    val typeId: String,
    val propertyTypeName: String,
    val propertyTypeId: String,
    val specifications: List<Specification> = emptyList(),
    val area: Short,
    val rooms: Byte,
    val baths: Byte,
    val price: Int,
    val location: String,
    val latitude: Double,
    val longitude: Double,
    val uploadTime: Long,
    val expireTime: Long,
    val ownerId: String,
    val countryId: String,
    val featured: Boolean = false,
    val pinned: Boolean = false,
    val status: Status = Status.ACTIVE
)

@Serializable
data class Specification(
    val id: String,
    val imageUrl: String,
    val name: String
)

@Serializable
enum class Status {
    ACTIVE,
    INACTIVE
}
