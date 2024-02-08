package de.tschuehly.fullstackdemo.web.form

import de.tschuehly.fullstackdemo.web.form.content.button.Button
import de.tschuehly.fullstackdemo.web.form.content.text.Text
import de.tschuehly.fullstackdemo.web.form.layout.box.BoxLayoutDefinition
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class FormController(val formResolver: FormResolver) {
    @GetMapping("/form")
    fun form(): ViewContext {
        return formResolver.renderLayout(
            BoxLayoutDefinition.of(
                Text("Hello World"),
                Button("Hello World"),
                BoxLayoutDefinition.of(
                    Text("Hello JUGS"),
                    Button("Hello JUGS")
                )
            )
        )
    }
}
