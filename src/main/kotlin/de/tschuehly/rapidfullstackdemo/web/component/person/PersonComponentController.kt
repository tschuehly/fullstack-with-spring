package de.tschuehly.rapidfullstackdemo.web.component.person

import de.tschuehly.rapidfullstackdemo.web.component.person.form.PersonFormViewComponent
import de.tschuehly.rapidfullstackdemo.web.component.person.table.PersonTableViewComponent
import de.tschuehly.rapidfullstackdemo.web.component.util.modal.ModalViewComponent
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/component/person")
class PersonComponentController(
    private val modalViewComponent: ModalViewComponent,
    private val personFormViewComponent: PersonFormViewComponent,
    private val personTableViewComponent: PersonTableViewComponent
) {
    @GetMapping("/modal/{personId}")
    fun personModal(@PathVariable personId: String) =
        modalViewComponent.render(::personFormViewComponent.name + ".render($personId)")

    @GetMapping("/table")
    fun personTable() = personTableViewComponent.render()
}