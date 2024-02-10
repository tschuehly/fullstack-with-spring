package de.tschuehly.fullstackdemo.web.form

import de.tschuehly.fullstackdemo.web.form.field.button.Button
import de.tschuehly.fullstackdemo.web.form.field.text.Text
import de.tschuehly.fullstackdemo.web.form.layout.box.BoxDefinition
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class FormController(val formResolver: FormResolver) {
    @GetMapping("/form")
    fun form(): ViewContext {
        return formResolver.render(
            BoxDefinition.of(
                Text("Hello World"),
                Button("Hello World"),
                BoxDefinition.of(
                    Text("Hello JUGS"),
                    Button("Hello JUGS")
                )
            )
        )
    }
}
