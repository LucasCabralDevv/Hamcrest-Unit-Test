package com.lucascabral.hamcrestunittest.model

data class Task(
    var title: String = "",
    var description: String = "",
    var isCompleted: Boolean = false
) {
    val isActive
    get() = !isCompleted
}
