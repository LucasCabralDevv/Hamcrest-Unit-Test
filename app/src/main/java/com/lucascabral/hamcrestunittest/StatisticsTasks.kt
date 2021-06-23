package com.lucascabral.hamcrestunittest

import com.lucascabral.hamcrestunittest.model.Task

internal fun getActiveAndCompletedStats(tasks: List<Task>?) : StatsResult{
    return if (tasks == null || tasks.isEmpty()) {
        StatsResult(0f, 0f)
    } else {
        val totalTasks = tasks.size
        val numberOfActiveTasks = tasks.count { it.isActive }
        StatsResult(
            activeTasksPercent = 100f * numberOfActiveTasks / totalTasks,
            completedTasksPercent = 100f * (totalTasks - numberOfActiveTasks) / totalTasks
        )
    }
}

data class StatsResult(
    val activeTasksPercent: Float,
    val completedTasksPercent: Float
)