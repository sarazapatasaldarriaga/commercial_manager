package com.commercial_manager.service;

public interface ICloudWatchMetricsService {

 void sendMetric(String metricName, double value, String nameSpace);

}
