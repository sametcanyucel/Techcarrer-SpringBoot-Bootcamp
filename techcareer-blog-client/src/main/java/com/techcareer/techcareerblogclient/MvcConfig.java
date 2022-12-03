package com.techcareer.techcareerblogclient;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		OriginalDirectory("src/main/resources/static/img",registry);
	}

	private void OriginalDirectory(String PathName, ResourceHandlerRegistry registry)
	{
		Path uploadPath = Paths.get(PathName); // Bu isimde bir klasör olduğunu belirtiyoruz.		
		String ProjectPath = uploadPath.toFile().getAbsolutePath();		
		registry.addResourceHandler("/"+ PathName+"/**").addResourceLocations("file:/"+ProjectPath +"/");		
	}
	
}
