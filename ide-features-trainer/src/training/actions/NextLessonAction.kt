// Copyright 2000-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package training.actions

import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import training.learn.CourseManager
import training.learn.lesson.LessonManager
import training.ui.LearningUiManager

class NextLessonAction : AnAction(AllIcons.Actions.Forward) {
  override fun actionPerformed(e: AnActionEvent) {
    val activeToolWindow = LearningUiManager.activeToolWindow ?: return
    val lesson = LessonManager.instance.currentLesson ?: return
    val lessonsForModules = CourseManager.instance.lessonsForModules
    val index = lessonsForModules.indexOf(lesson)
    if (index < 0 || index >= lessonsForModules.size) return
    CourseManager.instance.openLesson(activeToolWindow.project, lessonsForModules[index + 1])
  }

  override fun update(e: AnActionEvent) {
    val activeToolWindow = LearningUiManager.activeToolWindow
    val lesson = LessonManager.instance.currentLesson
    e.presentation.isEnabled = activeToolWindow != null
                               && activeToolWindow.project == e.project
                               && lesson != null
                               && CourseManager.instance.lessonsForModules.lastOrNull() != lesson
  }
}
