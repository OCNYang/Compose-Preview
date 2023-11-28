package com.ocnyang.compose_preview_processor

import com.google.auto.service.AutoService
import com.ocnyang.compose_preview_annotation.ComposePreview
import com.ocnyang.compose_preview_annotation.PreviewArgument
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import java.io.IOException
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.Filer
import javax.annotation.processing.Messager
import javax.annotation.processing.ProcessingEnvironment
import javax.annotation.processing.Processor
import javax.annotation.processing.RoundEnvironment
import javax.annotation.processing.SupportedSourceVersion
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement
import javax.lang.model.util.Elements
import javax.lang.model.util.Types
import javax.tools.Diagnostic

@AutoService(Processor::class)
@SupportedSourceVersion(SourceVersion.RELEASE_17)
class ComposePreviewProcessor : AbstractProcessor() {

    private lateinit var elementUtils: Elements
    private lateinit var filer: Filer
    private lateinit var typeUtils: Types
    private lateinit var messager: Messager

    override fun init(p: ProcessingEnvironment) {
        super.init(p)
        elementUtils = p.elementUtils
        filer = p.filer
        messager = p.messager
        typeUtils = p.typeUtils
    }


    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return mutableSetOf(ComposePreview::class.java.canonicalName, PreviewArgument::class.java.canonicalName)
    }


    override fun process(set: MutableSet<out TypeElement>, roundEnvironment: RoundEnvironment): Boolean {
        roundEnvironment.getElementsAnnotatedWith(ComposePreview::class.java).forEach {
            // 获取包信息
            val packageName = elementUtils.getPackageOf(it).qualifiedName.toString()
            val className = it.simpleName.toString()
            messager.printMessage(Diagnostic.Kind.NOTE, "ComposePreviewProcessor: $packageName.$className")

            // 获取包装类型
            val enclosingElement = it.enclosingElement as TypeElement
            val enclosingName = enclosingElement.qualifiedName.toString()
            messager.printMessage(Diagnostic.Kind.NOTE, "ComposePreviewProcessor: enclosingElement: $enclosingName")

            // 获取注解的成员变量类型
            val tagFieldClassType = it.asType().toString()


            val finalClassName = className + "ComposePreview"


            // 获取注解值
            val composePreview = it.getAnnotation(ComposePreview::class.java)
            val path = composePreview.path
            val category = composePreview.category
            val theme = composePreview.theme
            val name = composePreview.name
            val group = composePreview.group
            val apiLevel = composePreview.apiLevel
            val widthDp = composePreview.widthDp
            val heightDp = composePreview.heightDp

            // 生成代码
            val pkName = elementUtils.getPackageOf(enclosingElement).qualifiedName.toString()
            try {

                // 构建方法体
//                val method = MethodSpec.methodBuilder("$finalClassName")
//                    .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
//                    .returns(Class::class.java)
//                    .addStatement("return new $finalClassName()")
//                    .build()
//
//                // 构建类
//                val type = TypeSpec.classBuilder(finalClassName)
//                    .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
//                    .addMethod(method)
//                    .build()

                // 构建函数
                val funSpec= FunSpec.builder("${className}ComposePreview")
                    .addStatement(
                        """
                            ${theme}{
                                $className
                            }
                        """.trimIndent()
                    )
                    .build()

                // 生成文件
                FileSpec.builder("com.ocnyang.compose_preview_demo.preview", finalClassName)
                   .addFunction(funSpec)
                   .build()
                   .writeTo(filer)

            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
        return true
    }
}
