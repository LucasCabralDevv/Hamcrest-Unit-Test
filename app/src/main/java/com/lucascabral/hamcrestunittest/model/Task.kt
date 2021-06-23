package com.lucascabral.hamcrestunittest.model

data class Task(
    var title: String = "",
    var description: String = "",
    var isCompleted: Boolean = false
) {
    val titleForList: String
    get() = if (title.isNotEmpty()) title else description

    val isActive
    get() = !isCompleted

    val isEmpty
    get() = title.isEmpty() || description.isEmpty()
}
