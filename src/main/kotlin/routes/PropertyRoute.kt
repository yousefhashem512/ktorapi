package com.yousefh.routes

import com.yousefh.data.createOrUpdatePropertyForId
import com.yousefh.data.deletePropertyForId
import com.yousefh.data.getPropertyForId
import com.yousefh.data.model.Property
import com.yousefh.data.requests.DeletePropertyRequest
import com.yousefh.data.requests.PropertyRequest
import io.ktor.http.HttpStatusCode
import io.ktor.server.request.ContentTransformationException
import io.ktor.server.request.receive
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.route
import io.ktor.server.response.*
import io.ktor.server.routing.delete
import io.ktor.server.routing.post

fun Route.PropertyRoute() {
    route("/get-property") {
        get {
            val propertyId = call.receive<PropertyRequest>().id
            val property = getPropertyForId(propertyId)
            property?.let {
                call.respond(
                    HttpStatusCode.OK,
                    it
                )
            } ?: call.respond(
                HttpStatusCode.OK,
                "There is no property with this ID"
            )
        }
    }

    route("/create-update-property") {
        post {
            val request = try {
                call.receive<Property>()
            } catch (e: ContentTransformationException) {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }
            if (createOrUpdatePropertyForId(request)) {
                call.respond(
                    HttpStatusCode.OK,
                    "Successfully Done"
                )
            } else {
                call.respond(HttpStatusCode.Conflict)
            }
        }
    }

    route("/delete-property") {
        post {
            val request = try {
                call.receive<DeletePropertyRequest>()
            } catch (e: ContentTransformationException) {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }
            if (deletePropertyForId(request.id)) {
                call.respond(
                    HttpStatusCode.OK,
                    "Property Deleted Successfully"
                )
            } else {
                call.respond(
                    HttpStatusCode.OK,
                    "Property not found"
                )
            }
        }
    }
}