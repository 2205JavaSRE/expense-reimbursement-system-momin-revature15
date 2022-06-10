package com.revature;

import java.io.File;

import com.revature.controller.RequestMapper;

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


public class MainDriver {

	
	public static void main(String[] args) {
		
		
		PrometheusMeterRegistry registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
		registry.config().commonTags("app","My-first-monitored-App");
		new ClassLoaderMetrics().bindTo(registry);
		new JvmMemoryMetrics().bindTo(registry);
		new JvmGcMetrics().bindTo(registry);
		new JvmThreadMetrics().bindTo(registry);
		new UptimeMetrics().bindTo(registry);
		new ProcessorMetrics().bindTo(registry);
		new DiskSpaceMetrics(new File(System.getProperty("user.dir"))).bindTo(registry);
		
		Counter counter = Counter	
				.builder("path_request_to_count")
				.description("to keep track of the number of drnk requests")
				.tags("purpose","demo")
				.register(registry);
			
				
		
		Javalin app = Javalin.create(config->{
			config.registerPlugin(new MicrometerPlugin(registry));
		}
		
				).start(7000);
		
		
		app.get("/metrics",ctx->{
			ctx.result(registry.scrape());	
		});
       
		RequestMapper requestMapper = new RequestMapper();
		
		requestMapper.configureRoutes(app);	
		

	}



}