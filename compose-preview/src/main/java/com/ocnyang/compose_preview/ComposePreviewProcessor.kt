package com.ocnyang.compose_preview

import androidx.compose.ui.tooling.preview.Wallpapers
import com.google.devtools.ksp.KspExperimental
import com.google.devtools.ksp.getAnnotationsByType
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSFile
import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import com.google.devtools.ksp.validate
import kotlin.reflect.KClass

internal class ComposePreviewProcessor(
    private val environment: SymbolProcessorEnvironment,
) : SymbolProcessor {

    companion object {
        const val GENERATED_PACKAGE = "com.ocnyang.compose_preview_demo"
        const val GENERATED_FILE_NAME = "ComposePreview"
    }

    @OptIn(KspExperimental::class)
    override fun process(resolver: Resolver): List<KSAnnotated> {
        val previewFunctions = resolver.findAnnotations(ComposePreview::class)
        if (!previewFunctions.iterator().hasNext()) return emptyList()

        val sourceFiles = previewFunctions.mapNotNull { it.containingFile }

        println("${previewFunctions.count()}----${sourceFiles.count()}")

        val importStringBuilder = StringBuilder()
        val codeStringBuilder = StringBuilder()

        // Base imports
        importStringBuilder.apply {
            append("package $GENERATED_PACKAGE")
            newLine(2)
            append("import androidx.compose.ui.tooling.preview.Preview")
            newLine()
            append("import androidx.compose.runtime.Composable")
            newLine()
        }

        previewFunctions.forEach {
            it.qualifiedName?.asString()?.let {
                importStringBuilder.append("import $it\n")
            }

            it.getAnnotationsByType(ComposePreview::class).forEach {
                codeStringBuilder.apply {
                    newLine()
                    append("@Preview(${it.argumentToString()})")
                }
            }

            codeStringBuilder.apply {

                newLine()
                append("@Composable")
                newLine()
                append("fun ${it.qualifiedName?.getShortName()}ComposePreview() {")
                newLine()
                append("\t${it.qualifiedName?.getShortName()}(")
                newLine()
                it.parameters.forEach { ksValueParameter ->
                    ksValueParameter.getAnnotationsByType(PreviewArgument::class).forEach { previewArgument ->
                        append("\t\t${ksValueParameter.name?.asString()} = ")
                        val argumentVal = previewArgument.value
                        when (ksValueParameter.type.toString()) {
                            "String" -> append("\"$argumentVal\"")
                            "Int", "Float", "Double", "Boolean" -> append(argumentVal)
                            "Char" -> append("'$argumentVal'")
                            else -> {
                                append(argumentVal)
                                importStringBuilder
                                    .append("import ")
                                    .append(ksValueParameter.type.resolve().declaration.qualifiedName?.asString())
                                    .append("\n")
                            }
                        }
                        append(",")

                        newLine()
                    }
                }
                append("\t)")
                newLine()
                append("}")
                newLine(2)
            }
        }

        createFileWithText(sourceFiles, fileText = importStringBuilder.append(codeStringBuilder).toString())

        return (previewFunctions).filterNot { it.validate() }.toList()
    }

    private fun createFileWithText(
        sourceFiles: Sequence<KSFile>,
        fileText: String,
    ) {
        val file = environment.codeGenerator.createNewFile(
            Dependencies(
                false,
                *sourceFiles.toList().toTypedArray(),
            ),
            GENERATED_PACKAGE,
            GENERATED_FILE_NAME
        )

        file.write(fileText.toByteArray())
    }


    private fun Resolver.findAnnotations(kClass: KClass<*>) =
        getSymbolsWithAnnotation(kClass.qualifiedName.toString()).filterIsInstance<KSFunctionDeclaration>()


    private fun StringBuilder.newLine(count: Int = 1) {
        repeat(count) {
            append("\n")
        }
    }

    private fun ComposePreview.argumentToString() =
        buildString {
            if (name.isNotEmpty()) {
                append("name = \"$name\", ")
            }

            if (group.isNotEmpty()) {
                append("group = \"$group\", ")
            }

            if (apiLevel != -1) {
                append("apiLevel = $apiLevel, ")
            }
            if (widthDp != -1) {
                append("widthDp = $widthDp, ")
            }
            if (heightDp != -1) {
                append("heightDp = $heightDp, ")
            }
            if (locale.isNotEmpty()) {
                append("locale = \"$locale\", ")
            }
            if (fontScale != 1f) {
                append("fontScale = $fontScale, ")
            }

            if (showSystemUi) {
                append("showSystemUi = true, ")
            }
            if (showBackground) {
                append("showBackground = true, ")
            }
            if (backgroundColor != 0L) {
                append("backgroundColor = $backgroundColor, ")
            }
            if (uiMode != 0) {
                append("uiMode = $uiMode, ")
            }
            if (device.isNotEmpty()) {
                append("device = \"$device\", ")
            }
            if (wallpaper != Wallpapers.NONE) {
                append("wallpaper = $wallpaper, ")
            }

        }
}