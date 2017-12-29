/**
 * 
 */
package com.preschool.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySource;

/**
 * @author francisphiri
 *
 */
@Configuration
@EncryptablePropertySource(name = "qaEncryptedProperties", value="classpath:qa.ecrypted.properties")
@Profile("qa")
public class EcryptedConfig {
	
}
