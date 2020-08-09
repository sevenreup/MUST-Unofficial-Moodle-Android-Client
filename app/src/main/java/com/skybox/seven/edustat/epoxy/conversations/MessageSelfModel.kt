package com.skybox.seven.edustat.epoxy.conversations

import android.text.Html
import android.widget.TextView
import androidx.constraintlayout.solver.state.State
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.google.android.material.card.MaterialCardView
import com.skybox.seven.edustat.R
import com.skybox.seven.edustat.epoxy.BaseEpoxyHolder

@EpoxyModelClass(layout = R.layout.model_message_self)
abstract class MessageSelfModel: EpoxyModelWithHolder<MessageSelfModel.MessageSelfHolder>(){
    @EpoxyAttribute lateinit var text: String
    @EpoxyAttribute lateinit var time: String
    @EpoxyAttribute var self: Boolean = false

    class MessageSelfHolder: BaseEpoxyHolder() {
        val message by bind<TextView>(R.id.message)
        val time by bind<TextView>(R.id.time)
        val holder by bind<ConstraintLayout>(R.id.model_holder)
        val card by bind<MaterialCardView>(R.id.message_holder)
    }

    override fun bind(holder: MessageSelfHolder) {
        super.bind(holder)
        holder.message.text = Html.fromHtml(text)
        holder.time.text = time
        if (self) {
            val constraintSet = ConstraintSet()
            constraintSet.clone(holder.holder)
            constraintSet.connect(R.id.message_holder, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
            constraintSet.clear(R.id.message_holder, ConstraintSet.START)
            constraintSet.applyTo(holder.holder)
        }
    }

    override fun getDefaultLayout(): Int = R.layout.model_message_self

    override fun createNewHolder(): MessageSelfHolder = MessageSelfHolder()
}