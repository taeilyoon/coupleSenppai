package com.tqeil.couplesenppai.Model

class ChatModel {
    var sender : String = ""
    var content : String = ""
    var time : String = ""

    init {

    }
    constructor(){

    }
    fun setSender(str : String) : ChatModel {
        sender = str
        return this
    }
    fun setContent(str : String) : ChatModel {
        content = str
        return this
    }
    fun settime(str : String) : ChatModel {
        time = str
        return this
    }
}