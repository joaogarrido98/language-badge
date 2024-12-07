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
        "2.json" to "CT",
        "3.json" to "ES",
        "4.json" to "FR",
        "5.json" to "DE",
        "6.json" to "IT",
        "7.json" to "DA",
        "8.json" to "SV",
        "9.json" to "NO",
        "10.json" to "CS",
        "19.json" to "BG",
        "20.json" to "GR",
        "21.json" to "PL",
        "22.json" to "PT",
        "23.json" to "RO",
        "24.json" to "CZ",
        "25.json" to "HU",
        "26.json" to "SK",
        "28.json" to "NL",
        "29.json" to "ET",
        "30.json" to "AU",
        "31.json" to "RU",
        "32.json" to "US",
        "33.json" to "BR",
        "34.json" to "JP",
        "36.json" to "ES",
        "37.json" to "SR",
        "38.json" to "TK",
    )

    override fun decorate(node: ProjectViewNode<*>, data: PresentationData) {
        val file: VirtualFile = node.virtualFile ?: return

        if (file.parent?.name == "language" && file.extension == "go") {
            val paddedFileName = file.name.padEnd(20)
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
