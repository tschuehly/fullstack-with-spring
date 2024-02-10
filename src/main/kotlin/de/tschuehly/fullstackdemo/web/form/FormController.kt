package de.tschuehly.fullstackdemo.web.form

import de.tschuehly.fullstackdemo.web.form.field.button.Button
import de.tschuehly.fullstackdemo.web.form.layout.box.Box
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class FormController(val formResolver: FormResolver) {

    @GetMapping("/form")
    fun form(): ViewContext {
        return formResolver.render(
            Box(
                Button("Hello JUG Stuttgart")
            )
        )
    }
}
