package com.isa.jokevault.model

data class Joke(var id: Number?) {
    var category: String? = null
    var type: String? = null
    var setup: String? = null
    var delivery: String? = null
    var flags: Flags? = null
    var error: Boolean? = null
    var joke: String? = null
}

class Flags{
    var nsfw: String? = null
    var religious: String? = null
    var political: String? = null
    var racist: String? = null
    var sexist: String? = null
}