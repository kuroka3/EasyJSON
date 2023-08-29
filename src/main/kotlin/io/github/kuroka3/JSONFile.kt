package io.github.kuroka3

import org.json.simple.JSONArray
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import org.json.simple.parser.ParseException
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException
import java.lang.ClassCastException
import java.net.URI

class JSONFile : File {
    constructor(path: String) : super(path)
    constructor(parent: File, child: String) : super(parent, child)
    constructor(parent: String, child: String) : super(parent, child)
    constructor(uri: URI) : super(uri)

    @get:Throws(IOException::class, ParseException::class, ClassCastException::class)
    val jsonObject: JSONObject
        get() {
            return JSONParser().parse(FileReader(this)) as JSONObject
        }
    @get:Throws(IOException::class, ParseException::class, ClassCastException::class)
    val jsonArray: JSONArray
        get() {
            return JSONParser().parse(FileReader(this)) as JSONArray
        }

    fun saveJSON(obj: JSONObject) {
        val writer = FileWriter(this)
        writer.write(obj.toJSONString())
        writer.flush()
        writer.close()
    }

    fun saveJSON(ary: JSONArray) {
        val writer = FileWriter(this)
        writer.write(ary.toJSONString())
        writer.flush()
        writer.close()
    }
}