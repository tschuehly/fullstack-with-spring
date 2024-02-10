package de.tschuehly.fullstackdemo.web.form.layout.box

import de.tschuehly.fullstackdemo.web.form.Content
import de.tschuehly.fullstackdemo.web.form.layout.LayoutDefinition
import java.util.*

class Box(
    val boxContents: List<Content>
) : LayoutDefinition {

    constructor(vararg slots: Content): this( Arrays.stream(slots).toList())


    companion object {
        fun of(vararg slots: Content): Box {
            return Box(Arrays.stream(slots).toList())
        }
    }
}