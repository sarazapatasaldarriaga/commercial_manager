package com.commercial_manager.service;



import software.amazon.awssdk.services.cloudwatch.CloudWatchClient;
import software.amazon.awssdk.services.cloudwatch.model.MetricDatum;
import software.amazon.awssdk.services.cloudwatch.model.PutMetricDataRequest;
import software.amazon.awssdk.services.cloudwatch.model.StandardUnit;

import java.time.Instant;

public class CloudWatchMetricsServiceImpl implements ICloudWatchMetricsService {

    private final CloudWatchClient cloudWatchClient = CloudWatchClient.builder().build();

    @Override
    public void sendMetric(String metricName, double value, String nameSpace) {
        MetricDatum datum = MetricDatum.builder()
                .metricName(metricName)
                .unit(StandardUnit.COUNT)
                .value(value)
                .timestamp(Instant.now())
                .build();

        PutMetricDataRequest request = PutMetricDataRequest.builder()
                .namespace(nameSpace)
                .metricData(datum)
                .build();

        cloudWatchClient.putMetricData(request);
    }

}
