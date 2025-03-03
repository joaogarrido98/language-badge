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
        "1.go" to "EN",
        "2.go" to "CT",
        "3.go" to "ES",
        "4.go" to "FR",
        "5.go" to "DE",
        "6.go" to "IT",
        "7.go" to "DA",
        "8.go" to "SV",
        "9.go" to "NO",
        "10.go" to "CS",
        "19.go" to "BG",
        "20.go" to "GR",
        "21.go" to "PL",
        "22.go" to "PT",
        "23.go" to "RO",
        "24.go" to "CZ",
        "25.go" to "HU",
        "26.go" to "SK",
        "28.go" to "NL",
        "29.go" to "ET",
        "30.go" to "AU",
        "31.go" to "RU",
        "32.go" to "US",
        "33.go" to "BR",
        "34.go" to "JP",
        "36.go" to "ES",
        "37.go" to "SR",
        "38.go" to "TK",
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
