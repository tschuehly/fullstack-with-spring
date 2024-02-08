package de.tschuehly.fullstackdemo.web.form.layout.box

import de.tschuehly.fullstackdemo.web.form.content.Content
import de.tschuehly.fullstackdemo.web.form.layout.LayoutDefinition
import java.util.*

class BoxLayoutDefinition(
    private val boxContents: List<Content>
) : LayoutDefinition<Content> {
    override fun slots(): List<Content> {
        return boxContents
    }

    companion object {
        fun of(vararg slots: Content): BoxLayoutDefinition {
            return BoxLayoutDefinition(Arrays.stream(slots).toList())
        }
    }
}