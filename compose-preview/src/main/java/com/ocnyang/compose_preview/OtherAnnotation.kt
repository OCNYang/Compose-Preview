package androidx.compose.ui.tooling.preview

import androidx.annotation.IntDef
import androidx.annotation.StringDef


/** Constant for [.uiMode]: bits that encode the mode type.  */
const val UI_MODE_TYPE_MASK = 0x0f

/** Constant for [.uiMode]: a [.UI_MODE_TYPE_MASK]
 * value indicating that no mode type has been set.  */
const val UI_MODE_TYPE_UNDEFINED = 0x00

/** Constant for [.uiMode]: a [.UI_MODE_TYPE_MASK]
 * value that corresponds to
 * [no
 * UI mode]({@docRoot}guide/topics/resources/providing-resources.html#UiModeQualifier) resource qualifier specified.  */
const val UI_MODE_TYPE_NORMAL = 0x01

/** Constant for [.uiMode]: a [.UI_MODE_TYPE_MASK]
 * value that corresponds to the
 * [desk]({@docRoot}guide/topics/resources/providing-resources.html#UiModeQualifier)
 * resource qualifier.  */
const val UI_MODE_TYPE_DESK = 0x02

/** Constant for [.uiMode]: a [.UI_MODE_TYPE_MASK]
 * value that corresponds to the
 * [car]({@docRoot}guide/topics/resources/providing-resources.html#UiModeQualifier)
 * resource qualifier.  */
const val UI_MODE_TYPE_CAR = 0x03

/** Constant for [.uiMode]: a [.UI_MODE_TYPE_MASK]
 * value that corresponds to the
 * [television]({@docRoot}guide/topics/resources/providing-resources.html#UiModeQualifier)
 * resource qualifier.  */
const val UI_MODE_TYPE_TELEVISION = 0x04

/** Constant for [.uiMode]: a [.UI_MODE_TYPE_MASK]
 * value that corresponds to the
 * [appliance]({@docRoot}guide/topics/resources/providing-resources.html#UiModeQualifier)
 * resource qualifier.  */
const val UI_MODE_TYPE_APPLIANCE = 0x05

/** Constant for [.uiMode]: a [.UI_MODE_TYPE_MASK]
 * value that corresponds to the
 * [watch]({@docRoot}guide/topics/resources/providing-resources.html#UiModeQualifier)
 * resource qualifier.  */
const val UI_MODE_TYPE_WATCH = 0x06

/** Constant for [.uiMode]: a [.UI_MODE_TYPE_MASK]
 * value that corresponds to the
 * [vrheadset]({@docRoot}guide/topics/resources/providing-resources.html#UiModeQualifier)
 * resource qualifier.  */
const val UI_MODE_TYPE_VR_HEADSET = 0x07

/** Constant for [.uiMode]: bits that encode the night mode.  */
const val UI_MODE_NIGHT_MASK = 0x30

/** Constant for [.uiMode]: a [.UI_MODE_NIGHT_MASK]
 * value indicating that no mode type has been set.  */
const val UI_MODE_NIGHT_UNDEFINED = 0x00

/** Constant for [.uiMode]: a [.UI_MODE_NIGHT_MASK]
 * value that corresponds to the
 * [notnight]({@docRoot}guide/topics/resources/providing-resources.html#NightQualifier)
 * resource qualifier.  */
const val UI_MODE_NIGHT_NO = 0x10

/** Constant for [.uiMode]: a [.UI_MODE_NIGHT_MASK]
 * value that corresponds to the
 * [night]({@docRoot}guide/topics/resources/providing-resources.html#NightQualifier)
 * resource qualifier.  */
const val UI_MODE_NIGHT_YES = 0x20

/**
 * Annotation of setting uiMode in [Preview].
 * @hide
 */
@Suppress("UniqueConstants")
@Retention(AnnotationRetention.SOURCE)
@IntDef(
    value = [
        UI_MODE_TYPE_MASK,
        UI_MODE_TYPE_UNDEFINED,
        UI_MODE_TYPE_APPLIANCE,
        UI_MODE_TYPE_CAR,
        UI_MODE_TYPE_DESK,
        UI_MODE_TYPE_NORMAL,
        UI_MODE_TYPE_TELEVISION,
        UI_MODE_TYPE_VR_HEADSET,
        UI_MODE_TYPE_WATCH,
        UI_MODE_NIGHT_MASK,
        UI_MODE_NIGHT_UNDEFINED,
        UI_MODE_NIGHT_NO,
        UI_MODE_NIGHT_YES
    ]
)
annotation class UiMode


/**
 * List with the pre-defined devices available to be used in the preview.
 */
object Devices {
    const val DEFAULT = ""

    const val NEXUS_7 = "id:Nexus 7"
    const val NEXUS_7_2013 = "id:Nexus 7 2013"
    const val NEXUS_5 = "id:Nexus 5"
    const val NEXUS_6 = "id:Nexus 6"
    const val NEXUS_9 = "id:Nexus 9"
    const val NEXUS_10 = "name:Nexus 10"
    const val NEXUS_5X = "id:Nexus 5X"
    const val NEXUS_6P = "id:Nexus 6P"
    const val PIXEL_C = "id:pixel_c"
    const val PIXEL = "id:pixel"
    const val PIXEL_XL = "id:pixel_xl"
    const val PIXEL_2 = "id:pixel_2"
    const val PIXEL_2_XL = "id:pixel_2_xl"
    const val PIXEL_3 = "id:pixel_3"
    const val PIXEL_3_XL = "id:pixel_3_xl"
    const val PIXEL_3A = "id:pixel_3a"
    const val PIXEL_3A_XL = "id:pixel_3a_xl"
    const val PIXEL_4 = "id:pixel_4"
    const val PIXEL_4_XL = "id:pixel_4_xl"

    const val AUTOMOTIVE_1024p = "id:automotive_1024p_landscape"

    const val WEAR_OS_LARGE_ROUND = "id:wearos_large_round"
    const val WEAR_OS_SMALL_ROUND = "id:wearos_small_round"
    const val WEAR_OS_SQUARE = "id:wearos_square"
    const val WEAR_OS_RECT = "id:wearos_rect"

    // Reference devices
    const val PHONE = "spec:id=reference_phone,shape=Normal,width=411,height=891,unit=dp,dpi=420"
    const val FOLDABLE = "spec:shape=Normal,width=673,height=841,unit=dp,dpi=480"
    const val TABLET = "spec:shape=Normal,width=1280,height=800,unit=dp,dpi=420"
    const val DESKTOP = "spec:shape=Normal,width=1920,height=1080,unit=dp,dpi=420"

    // TV devices (not adding 4K since it will be very heavy for preview)
    const val TV_720p = "spec:shape=Normal,width=1280,height=720,unit=dp,dpi=420"
    const val TV_1080p = "spec:shape=Normal,width=1920,height=1080,unit=dp,dpi=420"
}

/**
 * Annotation for defining the [Preview] device to use.
 * @suppress
 */
@Retention(AnnotationRetention.SOURCE)
@StringDef(
    open = true,
    value = [
        Devices.DEFAULT,

        Devices.NEXUS_7,
        Devices.NEXUS_7_2013,
        Devices.NEXUS_5,
        Devices.NEXUS_6,
        Devices.NEXUS_9,
        Devices.NEXUS_10,
        Devices.NEXUS_5X,
        Devices.NEXUS_6P,
        Devices.PIXEL_C,
        Devices.PIXEL,
        Devices.PIXEL_XL,
        Devices.PIXEL_2,
        Devices.PIXEL_2_XL,
        Devices.PIXEL_3,
        Devices.PIXEL_3_XL,
        Devices.PIXEL_3A,
        Devices.PIXEL_3A_XL,
        Devices.PIXEL_4,
        Devices.PIXEL_4_XL,

        Devices.AUTOMOTIVE_1024p,

        Devices.WEAR_OS_LARGE_ROUND,
        Devices.WEAR_OS_SMALL_ROUND,
        Devices.WEAR_OS_SQUARE,
        Devices.WEAR_OS_RECT,

        Devices.PHONE,
        Devices.FOLDABLE,
        Devices.TABLET,
        Devices.DESKTOP,

        Devices.TV_720p,
        Devices.TV_1080p,
    ]
)
annotation class Device


object Wallpapers {
    /** Default value, representing dynamic theming not enabled. */
    const val NONE = -1
    /** Example wallpaper whose dominant colour is red. */
    const val RED_DOMINATED_EXAMPLE = 0
    /** Example wallpaper whose dominant colour is green. */
    const val GREEN_DOMINATED_EXAMPLE = 1
    /** Example wallpaper whose dominant colour is blue. */
    const val BLUE_DOMINATED_EXAMPLE = 2
    /** Example wallpaper whose dominant colour is yellow. */
    const val YELLOW_DOMINATED_EXAMPLE = 3
}

/**
 * Annotation for defining the wallpaper to use for dynamic theming in the [Preview].
 * @suppress
 */
@Retention(AnnotationRetention.SOURCE)
@IntDef(Wallpapers.NONE, Wallpapers.RED_DOMINATED_EXAMPLE, Wallpapers.GREEN_DOMINATED_EXAMPLE,
    Wallpapers.BLUE_DOMINATED_EXAMPLE, Wallpapers.YELLOW_DOMINATED_EXAMPLE)
annotation class Wallpaper
