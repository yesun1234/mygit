package net.musecom.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyResConfig implements WebMvcConfigurer {
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//res �슂泥��씠 �삤硫� public �뤃�뜑�굹 classpath:/static/ 寃쎈줈 �븘�옒�뿉 �엳�뒗 �뙆�씪�뱾�쓣 李얜뒗�떎.
		registry.addResourceHandler("/res/**").addResourceLocations("/public/","classpath:/static/");
	}
}
