package de.tschuehly.rapidfullstackdemo.web.advice

import de.tschuehly.rapidfullstackdemo.web.component.util.toast.ToastViewComponent
import de.tschuehly.supabasesecurityspringbootstarter.exception.*
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import org.slf4j.Logger
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionController(
    private val toastViewComponent: ToastViewComponent
) {
    @ExceptionHandler(InvalidLoginCredentialsException::class)
    fun handleInvalidLoginCredentialsException(exception: InvalidLoginCredentialsException): ViewContext {
        return toastViewComponent.render(
            "Your credentials are invalid",
            10000
        )
    }

    @ExceptionHandler(UserNeedsToConfirmEmailBeforeLoginException::class)
    fun handleUserNeedsToConfirmEmail(): ViewContext {
        return toastViewComponent.render(
            "You need to confirm your email before you can login",
            10000
        )
    }

    @ExceptionHandler(SuccessfulRegistrationConfirmationEmailSentException::class)
    fun handleSuccessfulRegistration(exception: SuccessfulRegistrationConfirmationEmailSentException): ViewContext {
        return toastViewComponent.render(
            "You registered successfully, we sent you a confirmation email",
            10000
        )
    }

    @ExceptionHandler(PasswordRecoveryEmailSent::class)
    fun handlePasswordRecoveryEmailSent(exception: Exception): ViewContext {
        return toastViewComponent.render(
            "We sent you an email to reset your password",
            10000
        )
    }

    @ExceptionHandler(SuccessfulPasswordUpdate::class)
    fun handleSuccessfulPasswordUpdate(exception: Exception): ViewContext {
        return toastViewComponent.render(
            "You successfully updated your password",
            10000
        )
    }
}
