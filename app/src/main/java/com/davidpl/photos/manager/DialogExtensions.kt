package com.davidpl.photos.manager

import android.app.Dialog
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.davidpl.photos.R
import com.davidpl.photos.component.ListStdItemView
import com.davidpl.photos.model.ButtonModel
import com.example.commons.ui.component.enums.DialogType

class DialogExtensions {

    companion object {

        fun Dialog.setup(
            type: DialogType,
            title: Int = 0,
            desc: Int = 0,
            buttonMdl1: ButtonModel?,
            buttonMdl2: ButtonModel? = null,
            buttonMdl3: ButtonModel? = null
        ): Dialog {
            when (type) {
                DialogType.NONE_BUTTONS -> {
                    return setupForNoneButtonsType(
                            title = title,
                            desc = desc,
                            buttonMdl1 = buttonMdl1,
                            buttonMdl2 = buttonMdl2,
                            buttonMdl3 = buttonMdl3
                    )
                }
                DialogType.EXPANDED_BUTTONS -> {
                    return setupForExpandedButtonsType(
                            title = title,
                            desc = desc,
                            buttonMdl1 = buttonMdl1,
                            buttonMdl2 = buttonMdl2,
                            buttonMdl3 = buttonMdl3
                    )
                }
                DialogType.WRAPPED_BUTTONS -> {
                    return setupForWrappedButtonsType(
                            title = title,
                            desc = desc,
                            buttonMdl1 = buttonMdl1,
                            buttonMdl2 = buttonMdl2
                    )
                }
            }
        }

        fun Dialog.setupForNoneButtonsType(
                title: Int = 0,
                desc: Int = 0,
                buttonMdl1: ButtonModel?,
                buttonMdl2: ButtonModel? = null,
                buttonMdl3: ButtonModel? = null
        ): Dialog {
            return this
        }

        fun Dialog.setupForExpandedButtonsType(
                title: Int = 0,
                desc: Int = 0,
                buttonMdl1: ButtonModel?,
                buttonMdl2: ButtonModel? = null,
                buttonMdl3: ButtonModel? = null
        ): Dialog {
            this.setContentView(R.layout.dialog_expanded_buttons)
            val titleTV = this.findViewById<TextView>(R.id.title)
            val descTV = this.findViewById<TextView>(R.id.desc)
            val btn1Btn = this.findViewById<ListStdItemView>(R.id.button_1)
            val btn2Btn = this.findViewById<ListStdItemView>(R.id.button_2)
            val btn3Btn = this.findViewById<ListStdItemView>(R.id.button_3)
            if (title != 0) {
                titleTV.text = context.getString(title)
            }
            if (desc != 0) {
                descTV.text = context.getString(desc)
            }
            buttonMdl1?.let {
                btn1Btn.visibility = View.VISIBLE
                btn1Btn.title(it.title)
                it.endIcon?.let { icon -> btn1Btn.configEndIcon(icon) }
                btn1Btn.setOnClickListener {
                    _ ->
                    it.onClick()
                }
            }
            buttonMdl2?.let {
                btn2Btn.visibility = View.VISIBLE
                btn2Btn.title(it.title)
                it.endIcon?.let { icon -> btn2Btn.configEndIcon(icon) }
                btn2Btn.setOnClickListener { _ -> it.onClick() }
            }
            buttonMdl3?.let {
                btn3Btn.visibility = View.VISIBLE
                btn3Btn.title(it.title)
                it.endIcon?.let { icon -> btn3Btn.configEndIcon(icon) }
                btn3Btn.setOnClickListener { _ -> it.onClick() }
            }
            return this
        }

        fun Dialog.setupForWrappedButtonsType(
                title: Int = 0,
                desc: Int = 0,
                buttonMdl1: ButtonModel?,
                buttonMdl2: ButtonModel? = null
        ): Dialog {
            this.setContentView(R.layout.dialog_wrapped_buttons)
            val titleTV = this.findViewById<TextView>(R.id.title)
            val descTV = this.findViewById<TextView>(R.id.desc)
            val btn1Btn = this.findViewById<Button>(R.id.button_1)
            val btn2Btn = this.findViewById<Button>(R.id.button_2)
            if (title != 0) {
                titleTV.text = context.getString(title)
            }
            if (desc != 0) {
                descTV.text = context.getString(desc)
            }
            buttonMdl1?.let {
                btn1Btn.visibility = View.VISIBLE
                btn1Btn.text = context.getString(it.title)
                btn1Btn.setOnClickListener { _ -> it.onClick() }
            }
            buttonMdl2?.let {
                btn2Btn.visibility = View.VISIBLE
                btn2Btn.text = context.getString(it.title)
                btn2Btn.setOnClickListener { _ -> it.onClick() }
            }
            return this
        }

    }

}