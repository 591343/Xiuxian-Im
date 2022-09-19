package com.xiuxian.gateway.config;

import com.xiuxian.gateway.filter.CorsResponseHeaderFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.DefaultCorsProcessor;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.pattern.PathPatternParser;



/**
 *
 * @Author Chen Xiao
 * @Description 网关跨域配置
 * @Create Created in 2022/9/15
 */
@Configuration
public class CorsConfig {
	@Bean
	public CorsResponseHeaderFilter corsResponseHeaderFilter() {
		return new CorsResponseHeaderFilter();
	}
	
	@Bean
	public CorsWebFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
		source.registerCorsConfiguration("/**", buildCorsConfiguration());
		
		CorsWebFilter corsWebFilter = new CorsWebFilter(source, new DefaultCorsProcessor() {
			@Override
			protected boolean handleInternal(ServerWebExchange exchange, CorsConfiguration config, 
				boolean preFlightRequest) 
			{
				// 预留扩展点
				// if (exchange.getRequest().getMethod() == HttpMethod.OPTIONS) {
					return super.handleInternal(exchange, config, preFlightRequest);
				// }

				// return true;
			}
		});
		
		return corsWebFilter;
	}
	
	private CorsConfiguration buildCorsConfiguration() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin("*");
		
		corsConfiguration.addAllowedMethod(HttpMethod.OPTIONS);
		corsConfiguration.addAllowedMethod(HttpMethod.POST);
		corsConfiguration.addAllowedMethod(HttpMethod.GET);
		corsConfiguration.addAllowedMethod(HttpMethod.PUT);
		corsConfiguration.addAllowedMethod(HttpMethod.DELETE);
		corsConfiguration.addAllowedMethod(HttpMethod.PATCH);
		// corsConfiguration.addAllowedMethod("*");

		corsConfiguration.addAllowedHeader("*");
		
		corsConfiguration.setMaxAge(7200L);
		corsConfiguration.setAllowCredentials(true);
		return corsConfiguration;
	}
}

