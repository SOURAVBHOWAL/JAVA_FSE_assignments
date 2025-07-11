package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:country-config.xml")
public class XmlConfigImporter {
    // This class imports the XML configuration
}