package com.kevinrsebastian.androidex.ui

import android.content.Context
import androidx.annotation.ColorRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.google.android.material.divider.MaterialDividerItemDecoration
import com.kevinrsebastian.androidex.R

/**
 * CustomDividerItemDecoration is based on [MaterialDividerItemDecoration] that can be used as divider between items of
 * a [LinearLayoutManager]. The difference being the simplicity of instantiation and less boilerplate code.
 * CustomDividerItemDecoration can be instantiated with just the context as a parameter.
 *
 * The constructor still accepts both [HORIZONTAL] and [VERTICAL] orientations, but is default to [VERTICAL].
 *
 * The divider color can also be set in the constructor, but is default to the Outline variant color in accordance to
 * [Material 3](https://m3.material.io/components/divider/specs).
 */
class CustomDividerItemDecoration(
    context: Context,
    orientation: Int = LinearLayoutManager.VERTICAL,
    @ColorRes colorRes: Int = R.color.md_theme_outlineVariant
) : MaterialDividerItemDecoration(context, orientation) {
    init {
        this.setDividerColorResource(context, colorRes)
    }
}
