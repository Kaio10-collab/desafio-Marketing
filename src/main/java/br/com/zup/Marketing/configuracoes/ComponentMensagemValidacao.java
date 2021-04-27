package br.com.zup.Marketing.configuracoes;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Component // vai transformar a classe em um objeto e vai instaciar com os métodos do Bean.
// INSTANCIA UM OBJETO Da classe marcada que o spring boot vai gerenciar (bean).
public class ComponentMensagemValidacao {

    /**
     * Os dois no final fazem o mesmo. Só que o Component é para a Classe toda,
     * e o Bean é para apenas o retorno do Metodo
     */
    @Bean// pega o objeto retorno de um metodo e entrega para o spring instanciar (bean)
    public MessageSource ferramentaDeMensagens() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:mensagens");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(ferramentaDeMensagens());
        return bean;
    }
}