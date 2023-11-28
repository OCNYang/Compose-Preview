package com.ocnyang.compose_preview_demo

data class AccountDataBean(
    var id: Int,
    var name: String,
    var sex: Boolean,
    var age: Float,
    var url: String,
    var tags: List<String> = ArrayList(),
)

fun AccountDataBean.OBES() = AccountDataBean(
    id = 1,
    name = "OBES",
    sex = true,
    age=20.0f,
    url = "https://www.baidu.com"
)