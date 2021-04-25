package com.example.users.configuration;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;

@Configuration
public class JacksonConfiguration {

    @Bean
    public MappingJackson2XmlHttpMessageConverter jacksonMessageConverter(Jackson2ObjectMapperBuilder builder) {
        return new MappingJackson2XmlHttpMessageConverter(
            builder.createXmlMapper(true)
                .modules(new JaxbAnnotationModule())
                .<XmlMapper>build()
                .enable(ToXmlGenerator.Feature.WRITE_XML_DECLARATION)
        );
    }
}
