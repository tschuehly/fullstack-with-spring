package de.tschuehly.fullstackdemo.web.form.layout

import de.tschuehly.fullstackdemo.web.form.content.Content

interface LayoutDefinition<T : Content> : Content {
    fun slots(): List<T>
}
