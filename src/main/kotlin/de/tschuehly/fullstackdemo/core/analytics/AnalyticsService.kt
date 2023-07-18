package de.tschuehly.fullstackdemo.core.analytics

import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class AnalyticsService {
    private val analyticsData = mutableMapOf<String,MutableList<AnalyticDataPoint>>()
    fun saveAnalyticsDataFor(name: String, dataPointList: MutableList<AnalyticDataPoint>){
        analyticsData[name] = dataPointList
    }

    fun getAnalyticsData() = analyticsData
    fun getAnalyticsDataFor(name: String) = analyticsData[name]?: mutableListOf()


    fun getLabelList() = analyticsData.map {
            it.key
        }
    fun getRequestCountList() = analyticsData.map {
        if(it.value.isEmpty()) 0 else it.value.last().requestCount
    }
    fun getTimeStampsFor(name: String) = analyticsData[name]?.map {
        it.time.format(DateTimeFormatter.ofPattern("MM-dd HH:mm:ss"))
    } ?: listOf()
    fun getComputeTimesFor(name: String) = analyticsData[name]?.map {
        it.computeTime
    } ?: listOf()

    class AnalyticDataPoint(
        val time: LocalDateTime,
        val requestCount: Long,
        val computeTime: Long
    )
}