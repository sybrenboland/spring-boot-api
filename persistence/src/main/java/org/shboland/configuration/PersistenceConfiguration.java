package org.shboland.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "org.shboland.db" })
public class PersistenceConfiguration {
}
