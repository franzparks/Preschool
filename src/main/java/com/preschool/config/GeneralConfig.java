/**
 * 
 */
package com.preschool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.preschool.search.CustomSearch;
import com.preschool.search.CustomSearchImp;

/**
 * @author francis
 *
 */
@Configuration
public class GeneralConfig {
	
	private final String cx = "014723624719242706501:ky6zn2teax4";
    private final String apiKey = "AIzaSyBFnKBQPESdi2sP1twKp59-3mBscTVw99k";
	
    @Bean
	public CustomSearch makeCustomSearch(){
    	
    	return new CustomSearchImp(cx, apiKey, 15);
	}

}
