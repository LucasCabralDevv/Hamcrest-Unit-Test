package com.lucascabral.hamcrestunittest

import com.lucascabral.hamcrestunittest.model.Task
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Test

class StatisticsTasksTest {

    @Test
    fun `test when getActiveAndCompletedStats returns no completed tasks`() {
        val tasksList = listOf(
            Task("title1", "desc1", isCompleted = false),
            Task("title2", "desc2", isCompleted = false),
            Task("title3", "desc3", isCompleted = false)
        )

        val result = getActiveAndCompletedStats(tasksList)

        assertThat(result.completedTasksPercent, `is` (0f))
        assertThat(result.activeTasksPercent, `is` (100f))
    }
}