package com.isa.jokevault.model

data class Endpoint(var id: Number?) {
    var name: String? = null
    var description: String? = null
    var usage: Usage? = null
}

class Usage{
    var method: String? = null
    var url: String? = null
    var supportedParams: Array<String>? = null
}