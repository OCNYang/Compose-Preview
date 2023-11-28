package com.ocnyang.compose_preview

import androidx.annotation.FloatRange
import androidx.annotation.IntRange
import androidx.compose.ui.tooling.preview.Device
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.UiMode
import androidx.compose.ui.tooling.preview.Wallpaper
import androidx.compose.ui.tooling.preview.Wallpapers


@MustBeDocumented
@Retention(AnnotationRetention.BINARY)
@Target(
    AnnotationTarget.ANNOTATION_CLASS,
    AnnotationTarget.FUNCTION
)
@Repeatable
annotation class ComposePreview(
//    val path: String = "preview/", // 生成文件存放的路径
//    val category: String = "", // 生成文件的名字，相同名字存放在一起
//    val theme: String = "",

    val name: String = "",
    val group: String = "",
    @IntRange(from = 1) val apiLevel: Int = -1,
    val widthDp: Int = -1,
    val heightDp: Int = -1,
    val locale: String = "",
    @FloatRange(from = 0.01) val fontScale: Float = 1f,
    val showSystemUi: Boolean = false,
    val showBackground: Boolean = false,
    val backgroundColor: Long = 0,
    @UiMode val uiMode: Int = 0,
    @Device val device: String = Devices.DEFAULT,
    @Wallpaper val wallpaper: Int = Wallpapers.NONE,
)


@MustBeDocumented
@Retention(AnnotationRetention.SOURCE)
@Target(
    AnnotationTarget.VALUE_PARAMETER,
)
@Repeatable
annotation class PreviewArgument(
    val value: String
)