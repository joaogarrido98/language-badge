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
        "lang1.go" to "EN",
        "lang2.go" to "CT",
        "lang3.go" to "ES",
        "lang4.go" to "FR",
        "lang5.go" to "DE",
        "lang6.go" to "IT",
        "lang7.go" to "DA",
        "lang8.go" to "SV",
        "lang9.go" to "NO",
        "lang10.go" to "CS",
        "lang19.go" to "BG",
        "lang20.go" to "GR",
        "lang21.go" to "PL",
        "lang22.go" to "PT",
        "lang23.go" to "RO",
        "lang24.go" to "CZ",
        "lang25.go" to "HU",
        "lang26.go" to "SK",
        "lang28.go" to "NL",
        "lang29.go" to "ET",
        "lang30.go" to "AU",
        "lang31.go" to "RU",
        "lang32.go" to "US",
        "lang33.go" to "BR",
        "lang34.go" to "JP",
        "lang36.go" to "ES",
        "lang37.go" to "SR",
        "lang38.go" to "TK",
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
