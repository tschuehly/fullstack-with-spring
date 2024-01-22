package de.tschuehly.fullstackdemo.web.page.tabbed

import de.tschuehly.fullstackdemo.web.component.util.alpineTab.AlpineTabViewComponent
import de.tschuehly.fullstackdemo.web.component.util.preactTab.PreactTabViewComponent
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class TabbedViewComponent(
    private val alpineTabViewComponent: AlpineTabViewComponent,
    private val preactTabViewComponent: PreactTabViewComponent
) {
    fun render() = TabbedCtx(
        alpineTabViewComponent.render(
            listOf(
                AlpineTabViewComponent.Tab(
                    "AlpineTab1",
                    "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor " +
                            "invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua."
                ),
                AlpineTabViewComponent.Tab(
                    "AlpineTab2",
                    "At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. "
                ),
            )

        ),
        preactTabViewComponent.render()
    )
    data class TabbedCtx(
        val alpineTabViewComponent: ViewContext,
        val preactTabViewComponent: ViewContext
    ) : ViewContext
}