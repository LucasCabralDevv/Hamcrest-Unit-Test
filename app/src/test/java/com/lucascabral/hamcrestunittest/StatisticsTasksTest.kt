package com.lucascabral.hamcrestunittest

import com.lucascabral.hamcrestunittest.model.Task
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Test

class StatisticsTasksTest {

    @Test
    fun `test when getActiveAndCompletedStats returns uncompleted tasks`() {
        val tasksList = listOf(
            Task("title1", "desc1", isCompleted = false),
            Task("title2", "desc2", isCompleted = false),
            Task("title3", "desc3", isCompleted = false)
        )

        val result = getActiveAndCompletedStats(tasksList)

        assertThat(result.completedTasksPercent, `is` (0f))
        assertThat(result.activeTasksPercent, `is` (100f))
    }

    @Test
    fun `test when getActiveAndCompletedStats returns completed tasks`() {
        val tasksList = listOf(
            Task("title1", "desc1", isCompleted = true),
            Task("title2", "desc2", isCompleted = true),
            Task("title3", "desc3", isCompleted = true)
        )

        val result = getActiveAndCompletedStats(tasksList)

        assertThat(result.completedTasksPercent, `is` (100f))
        assertThat(result.activeTasksPercent, `is` (0f))
    }

    @Test
    fun `test when getActiveAndCompletedStats returns forty percent of completed tasks`() {
        val tasksList = listOf(
            Task("title1", "desc1", isCompleted = true),
            Task("title2", "desc2", isCompleted = true),
            Task("title3", "desc3", isCompleted = true),
            Task("title4", "desc4", isCompleted = false),
            Task("title5", "desc5", isCompleted = false)
        )

        val result = getActiveAndCompletedStats(tasksList)

        assertThat(result.completedTasksPercent, `is` (60f))
        assertThat(result.activeTasksPercent, `is` (40f))
    }
}