package com.revature.controller;
	import java.io.File;
	import io.javalin.Javalin;
	import io.javalin.plugin.metrics.MicrometerPlugin;
	import io.micrometer.core.instrument.Counter;
	import io.micrometer.core.instrument.binder.jvm.ClassLoaderMetrics;
	import io.micrometer.core.instrument.binder.jvm.JvmGcMetrics;
	import io.micrometer.core.instrument.binder.jvm.JvmMemoryMetrics;
	import io.micrometer.core.instrument.binder.jvm.JvmThreadMetrics;
	import io.micrometer.core.instrument.binder.system.DiskSpaceMetrics;
	import io.micrometer.core.instrument.binder.system.ProcessorMetrics;
	import io.micrometer.core.instrument.binder.system.UptimeMetrics;
	import io.micrometer.prometheus.PrometheusConfig;
	import io.micrometer.prometheus.PrometheusMeterRegistry;
	import com.revature.controller.RequestMapper;




public class Prometheus {
	public static PrometheusMeterRegistry registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
	public static Counter count = Counter.builder("path_request_to_count")
			.description("to keep track of the number of login requests")
			.tag("purpose", "demo")
			.register(registry);

	public void monitor() {
	    registry.config().commonTags("app","monitored-app");;
	    new ClassLoaderMetrics().bindTo(registry);
	    new JvmMemoryMetrics().bindTo(registry);
	    new JvmGcMetrics().bindTo(registry);
	    new JvmThreadMetrics().bindTo(registry);
	    new UptimeMetrics().bindTo(registry);
	    new ProcessorMetrics().bindTo(registry);
	    new DiskSpaceMetrics(new File(System.getProperty("user.dir"))).bindTo(registry);
		
         
	}

	public static void count() {
		count.increment(1);
		
	}
	         
}