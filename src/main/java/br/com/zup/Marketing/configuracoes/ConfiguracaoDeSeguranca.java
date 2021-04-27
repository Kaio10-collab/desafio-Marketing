package br.com.zup.Marketing.configuracoes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration // vai criar um objeto de configuração
@EnableWebSecurity // habilita os recursos de segurança em nossa aplicação.
public class ConfiguracaoDeSeguranca extends WebSecurityConfigurerAdapter {

    private static final String[] PUBLIC_MATCHERS_GET = {
            "/categorias/**",
            "/contatos/**",
            "/produtos/**"
    };

    private static final String[] PUBLIC_MATCHERS_POST = {
            "/categorias/**",
            "/contatos/**",
            "/produtos/**"
    };

    //Método com mais de um endpoint: http.authorizeRequests().antMatchers(HttpMethod.GET, "/bandas/**").permitAll()
    //                .antMatchers(HttpMethod.POST).permitAll().antMatchers(HttpMethod.PUT, "/bandas/").permitAll()
    //                .anyRequest().authenticated();

    @Override // digite conf que irá aparecer as opções prontas; HttpSecurity http é um obj de segurança.
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors();

        http.authorizeRequests().antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
                .antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
                .anyRequest().authenticated();
    }

    @Bean
    CorsConfigurationSource configuracaoDeCors(){
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}