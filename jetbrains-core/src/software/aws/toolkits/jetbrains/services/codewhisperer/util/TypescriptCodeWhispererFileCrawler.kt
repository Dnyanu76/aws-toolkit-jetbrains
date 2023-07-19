// Copyright 2023 Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package software.aws.toolkits.jetbrains.services.codewhisperer.util

import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiFile

object TypescriptCodeWhispererFileCrawler : CodeWhispererFileCrawler() {
    override val fileExtension: String = "ts"
    override val dialects: Set<String> = setOf("ts", "tsx")

    override val testFilenamePattern: Regex = """^.*\.test\.(ts|tsx)${'$'}""".toRegex()

    // TODO: Add implementation when UTG is enabled
    override fun guessSourceFileName(tstFileName: String): String = ""

    override suspend fun listFilesImported(psiFile: PsiFile): List<VirtualFile> = emptyList()

    override fun listFilesWithinSamePackage(psiFile: PsiFile): List<VirtualFile> = emptyList()

    override fun findFocalFileForTest(psiFile: PsiFile): VirtualFile? = null
}
