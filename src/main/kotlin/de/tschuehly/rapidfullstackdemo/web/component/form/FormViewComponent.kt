package de.tschuehly.rapidfullstackdemo.web.component.form

import de.tschuehly.rapidfullstackdemo.web.component.layout.sidebar.SidebarViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewContext
import de.tschuehly.thymeleafviewcomponent.toProperty

@ViewComponent
class FormViewComponent {
    fun render() = ViewContext(
        "sidebarActiveTab" toProperty SidebarViewComponent.ActiveTab.Forms,
    )
}