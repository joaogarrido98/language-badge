package com.example.languagebadge

import com.intellij.ide.projectView.ProjectViewNode
import com.intellij.ide.projectView.ProjectViewNodeDecorator
import com.intellij.ide.projectView.PresentationData
import com.intellij.openapi.vcs.FileStatusManager
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.ui.JBColor
import com.intellij.ui.SimpleTextAttributes

class LanguageFileDecorator : ProjectViewNodeDecorator {
    private val languageMap = mapOf(
        "1.json" to "EN",
        "2.json" to "CN",
        "3.json" to "ES",
        "4.json" to "FR",
        "5.json" to "DA",
        "6.json" to "IT",
        "7.json" to "DK",
        "8.json" to "SV",
        "9.json" to "NO",
        "10.json" to "ZH",
        "19.json" to "BG",
        "20.json" to "GR",
        "21.json" to "HU",
        "22.json" to "SV",
        "24.json" to "DA",
        "25.json" to "NO",
        "26.json" to "BG",
        "27.json" to "CS",
        "28.json" to "SK",
        "30.json" to "AUS",
        "31.json" to "RU",
        "32.json" to "USA",
        "33.json" to "BR",
        "34.json" to "JP",
        "36.json" to "LATAM",
        "37.json" to "SR",
    )

    override fun decorate(node: ProjectViewNode<*>, data: PresentationData) {
        val file: VirtualFile = node.virtualFile ?: return

        if (file.parent?.name == "language" && file.extension == "json") {
            var targetWidth = 20
            if (file.name.length == 7) {
                targetWidth = 19
            }

            val paddedFileName = file.name.padEnd(targetWidth)
            data.clearText()
            data.addText(paddedFileName, SimpleTextAttributes.REGULAR_ATTRIBUTES)

            val fileStatus = FileStatusManager.getInstance(node.project).getStatus(file)
            val fileStatusColor = fileStatus.color ?: JBColor.GRAY

            val languageCode = languageMap[file.name] ?: ""
            val attributes = SimpleTextAttributes(SimpleTextAttributes.STYLE_BOLD, fileStatusColor)
            data.addText(" $languageCode", attributes)
        }
    }
}
