package net.atos.esuite.extract.config

import io.quarkus.smallrye.openapi.OpenApiFilter
import org.eclipse.microprofile.openapi.OASFilter
import org.eclipse.microprofile.openapi.models.media.Schema

@OpenApiFilter
class OASFilter : OASFilter {

    override fun filterSchema(schema: Schema): Schema? {
        schema.type = schema.type?.let { it.filter { it.name != "NULL" } }
        handleSchemaAnyOf(schema)
        return schema
    }

    private fun handleSchemaAnyOf(schema: Schema) {
        schema.anyOf = schema.anyOf?.filter { it.type == null }
        if (schema.anyOf?.size == 1) {
            schema.ref = schema.anyOf!![0].ref
            schema.anyOf = null
        }
    }
}

