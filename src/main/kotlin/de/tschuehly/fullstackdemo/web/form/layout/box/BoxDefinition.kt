package de.tschuehly.fullstackdemo.web.form.layout.box

import de.tschuehly.fullstackdemo.web.form.Content
import de.tschuehly.fullstackdemo.web.form.layout.LayoutDefinition
import java.util.*

class BoxDefinition(
    val boxContents: List<Content>
) : LayoutDefinition {

    companion object {
        fun of(vararg slots: Content): BoxDefinition {
            return BoxDefinition(Arrays.stream(slots).toList())
        }
    }
}