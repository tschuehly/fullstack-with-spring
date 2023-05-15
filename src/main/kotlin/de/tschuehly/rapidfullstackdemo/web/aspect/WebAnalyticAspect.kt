package de.tschuehly.rapidfullstackdemo.web.aspect

import de.tschuehly.rapidfullstackdemo.core.analytics.AnalyticsService
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
        "execution(* render(..)) && " +
                "@within(de.tschuehly.spring.viewcomponent.core.ViewComponent)"
    )
    fun aroundComponent(joinPoint: ProceedingJoinPoint): Any? {
        var returnValue: Any? = null
        val elapsedTime = measureNanoTime {
            returnValue = joinPoint.proceed()
        }
        val componentName = joinPoint.`this`.javaClass.simpleName.substringBefore("$$")
        val dataPointList = analyticsService.getAnalyticsDataFor(componentName)
        val requestCount = if (dataPointList.isEmpty()) 1 else dataPointList.last().requestCount + 1
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
