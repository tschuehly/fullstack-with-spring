package de.tschuehly.fullstackdemo.web.aspect

import de.tschuehly.fullstackdemo.core.analytics.AnalyticsService
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import kotlin.system.measureNanoTime

@Aspect
@Component
class WebAnalyticAspect(
    val analyticsService: AnalyticsService
) {
    val componentRenderCountMap: MutableMap<String, Int> = mutableMapOf()
//
//    @Around(
//        "execution(* service(..)) &&"+
//                "target(org.springframework.web.servlet.DispatcherServlet)"
//    )
//    fun aroundViewRender(joinPoint: ProceedingJoinPoint): Any? {
//        var returnValue: Any? = null
//        val elapsed = measureNanoTime {
//            returnValue = joinPoint.proceed()
//        }
//        println("Component : ${joinPoint.`this`.javaClass.simpleName.substringBefore("$$")} took $elapsed ns to render ")
//        return returnValue
//
//    }

@Around(
    "execution(de.tschuehly.spring.viewcomponent.core.IViewContext+ *(..)) && " +
            "@within(de.tschuehly.spring.viewcomponent.core.component.ViewComponent)"
)
fun aroundComponent(joinPoint: ProceedingJoinPoint): Any? {
    var returnValue: Any?
    val elapsedTime = measureNanoTime {
        returnValue = joinPoint.proceed()
    }
    val componentName = joinPoint.`this`.javaClass.simpleName.substringBefore("$$")
    val dataPointList = analyticsService.getAnalyticsDataFor(componentName)
    val requestCount: Long
    if (dataPointList.isEmpty()) {
        requestCount = 1
    } else {
        requestCount = dataPointList.last().requestCount + 1
    }
    dataPointList.add(
        AnalyticsService.AnalyticDataPoint(
            LocalDateTime.now(),
            requestCount,
            elapsedTime
        )
    )
    analyticsService.saveAnalyticsDataFor(componentName, dataPointList)
    return returnValue
}

}
