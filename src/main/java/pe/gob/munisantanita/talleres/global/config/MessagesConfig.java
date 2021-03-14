package pe.gob.munisantanita.talleres.global.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MessagesConfig {
    @Bean
    public MessageSource messageSource()
    {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames(
                "classpath:messages",
                "classpath:messages/exceptions",
                "classpath:messages/validations",
                "classpath:messages/codes"
        );
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
