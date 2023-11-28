package com.ocnyang.compose_preview_annotation

@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.VALUE_PARAMETER,
)
@Repeatable
annotation class PreviewArgument(
    val value: String
)