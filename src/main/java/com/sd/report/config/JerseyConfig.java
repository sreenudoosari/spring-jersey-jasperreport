package com.sd.report.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {
	private static String BASE_PACKAGE = "com.sd.report";
	public JerseyConfig() {
		packages(BASE_PACKAGE);
	}

}