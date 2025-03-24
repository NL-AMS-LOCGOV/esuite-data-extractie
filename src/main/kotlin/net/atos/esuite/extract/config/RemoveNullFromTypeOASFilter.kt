package net.atos.esuite.extract.config

import io.quarkus.smallrye.openapi.OpenApiFilter
import org.eclipse.microprofile.openapi.OASFilter
import org.eclipse.microprofile.openapi.models.media.Schema

private const val TYPE_NULL_NAME = "NULL"

@OpenApiFilter
class RemoveNullFromTypeOASFilter : OASFilter {

    override fun filterSchema(schema: Schema?): Schema? {
        schema?.type = schema?.type?.filter { it.name != TYPE_NULL_NAME }?.toList()
        return schema
    }
}
