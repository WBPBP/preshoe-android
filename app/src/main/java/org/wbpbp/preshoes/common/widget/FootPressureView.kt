/**
 * Copyright (C) 2020 WBPBP <potados99@gmail.com>
 *
 * This file is part of Preshoes (https://github.com/WBPBP).
 *
 * Preshoes is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Preshoes is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.wbpbp.preshoes.common.widget

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import org.wbpbp.preshoes.R
import org.wbpbp.preshoes.entity.FootPressure

class FootPressureView(context: Context, private val attrs: AttributeSet)
    : ConstraintLayout(context, attrs) {

    private lateinit var sensors: Array<ImageView>
    private lateinit var foot: ImageView

    init {
        val typedArray = getTypedArray()

        initView(typedArray)

        typedArray.recycle()
    }

    private fun getTypedArray() = context.obtainStyledAttributes(attrs, R.styleable.FootPressureView)

    private fun initView(typedArray: TypedArray) {
        val layout = when (getSide(typedArray))  {
            "left" -> R.layout.foot_pressure_view_left
            "right" -> R.layout.foot_pressure_view_right
            else -> R.layout.foot_pressure_view_left
        }

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(layout, this, false)

        addView(view)
    }

    private fun getSide(typedArray: TypedArray) = typedArray.getString(R.styleable.FootPressureView_side) ?: "left"

    fun setSensorValues(footPressure: FootPressure) {
        // scaleSensorDots(footPressure.pressures)
    }
}