package com.revature;

import java.io.File;

import com.revature.controller.AuthenticateController;
import com.revature.controller.Prometheus;
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
		
				
		
		Javalin app = Javalin.create(config->{
			config.registerPlugin(new MicrometerPlugin(Prometheus.registry));
		}	).start(7000);
		
		
		app.get("/metrics",ctx->{
			ctx.result(Prometheus.registry.scrape());	
		});
       
		RequestMapper requestMapper = new RequestMapper();
		
		requestMapper.configureRoutes(app);	
		

	}



}