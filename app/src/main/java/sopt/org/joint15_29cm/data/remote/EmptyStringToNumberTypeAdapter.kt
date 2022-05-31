package sopt.org.joint15_29cm.data.remote

import com.google.gson.JsonSyntaxException

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import okio.IOException
import java.lang.NumberFormatException


class EmptyStringToNumberTypeAdapter : TypeAdapter<Number?>() {
    @Throws(IOException::class)
    override fun write(jsonWriter: JsonWriter, number: Number?) {
        if (number == null) {
            jsonWriter.nullValue()
            return
        }
        jsonWriter.value(number)
    }

    @Throws(IOException::class)
    override fun read(jsonReader: JsonReader): Number? {
        if (jsonReader.peek() === JsonToken.NULL) {
            jsonReader.nextNull()
            return null
        }
        return try {
            val value: String = jsonReader.nextString()
            if ("" == value) {
                0
            } else value.toInt()
        } catch (e: NumberFormatException) {
            throw JsonSyntaxException(e)
        }
    }
}