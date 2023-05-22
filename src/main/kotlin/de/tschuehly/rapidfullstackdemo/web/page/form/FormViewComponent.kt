package de.tschuehly.rapidfullstackdemo.web.page.form

import de.tschuehly.rapidfullstackdemo.web.page.layout.sidebar.SidebarViewComponent
import de.tschuehly.spring.viewcomponent.core.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import de.tschuehly.spring.viewcomponent.core.toProperty

@ViewComponent
class FormViewComponent {
    fun render() = ViewContext(
        "sidebarActiveTab" toProperty SidebarViewComponent.ActiveTab.Forms,
    )
}