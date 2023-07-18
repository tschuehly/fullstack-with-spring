package de.tschuehly.fullstackdemo.core.person

import de.tschuehly.fullstackdemo.common.ApiConfig
import de.tschuehly.fullstackdemo.web.component.person.form.PersonFormViewComponent
import de.tschuehly.fullstackdemo.web.component.util.toast.ToastViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PutMapping

@Controller
class PersonController(
    private val personService: PersonService,
    private val toastViewComponent: ToastViewComponent
) {

    @PutMapping(ApiConfig.Person.put)
    fun savePerson(
        personFormDTO: PersonFormViewComponent.PersonFormDTO,
        response: HttpServletResponse
    ): ViewContext {
        personService.savePerson(personFormDTO.convertToPerson())
        response.addHeader("HX-Retarget", "#toast")
        return toastViewComponent.render(
            "Successfully saved Person",
            2000
        )
    }
}