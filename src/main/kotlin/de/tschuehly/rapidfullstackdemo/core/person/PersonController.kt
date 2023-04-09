package de.tschuehly.rapidfullstackdemo.core.person

import de.tschuehly.rapidfullstackdemo.web.component.form.person.PersonFormViewComponent
import de.tschuehly.rapidfullstackdemo.web.component.toast.ToastViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewContext
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/api/person")
class PersonController(
    private val personService: PersonService,
    private val toastViewComponent: ToastViewComponent
) {
    @PutMapping
    fun createPerson(
        personFormDTO: PersonFormViewComponent.PersonFormDTO,
        response: HttpServletResponse
    ): ViewContext {
        personService.addPerson(personFormDTO.convertToPerson())
        response.addHeader("HX-Retarget", "#toast")
        return toastViewComponent.render(
            "Successfully saved Person",
            2000
        )
    }
}