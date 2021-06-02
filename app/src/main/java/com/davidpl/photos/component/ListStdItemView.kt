package com.davidpl.photos.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.davidpl.photos.R
import com.davidpl.photos.databinding.ListStandardItemBinding

class ListStdItemView: ConstraintLayout {

    var binding: ListStandardItemBinding

    constructor(context: Context): this(context, null)

    constructor(context: Context, attributeSet: AttributeSet?): super(context, attributeSet) {
        val layoutInflater = LayoutInflater.from(context)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_standard_item, this, true)

        if (attributeSet == null) return

        val typedArrayList =  context.obtainStyledAttributes(attributeSet, R.styleable.ListStdItemView)

        val title = typedArrayList.getString(R.styleable.ListStdItemView_title)
        val subtitle = typedArrayList.getString(R.styleable.ListStdItemView_subtitle)
        val image = typedArrayList.getInteger(R.styleable.ListStdItemView_image, 0)
        val endicon = typedArrayList.getResourceId(R.styleable.ListStdItemView_endicon, 0)
        val showStroke = typedArrayList.getBoolean(R.styleable.ListStdItemView_stroke_show, true);

        configUI(title, subtitle, image, endicon, showStroke)
        typedArrayList.recycle()
    }

    fun configUI(title: String?, subtitle: String?, @DrawableRes image: Int, @DrawableRes endicon: Int, showStroke: Boolean) {
        configTitle(title)
        configSubtitle(subtitle)
        configImage(image)
        configEndIcon(endicon)
        configStroke(showStroke)
    }

    fun configTitle(title: String?) {
        binding.title.text = title ?: ""
    }

    fun title(title: Int) {
        binding.title.text = context.getString(title)
    }

    fun configSubtitle(subtitle: String?) {
        subtitle?.let {
            binding.subtitle.visibility = View.VISIBLE
            binding.subtitle.text = subtitle
        }
    }

    fun configImage(@DrawableRes image: Int) {
        if (image != 0) {
            binding.image.visibility = View.VISIBLE
            binding.image.setImageResource(image)
        }
    }

    fun configEndIcon(@DrawableRes icon: Int) {
        if (icon != 0) {
            binding.endIcon.visibility = View.VISIBLE
            binding.endIcon.setImageResource(icon)
        }
    }

    fun configStroke(showStroke: Boolean) {
        binding.stroke.visibility = if (showStroke) View.VISIBLE else View.GONE
    }

}