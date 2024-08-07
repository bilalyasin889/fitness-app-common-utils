package com.tier2.fitness.common.config

import com.tier2.fitness.common.service.TokenService
import com.tier2.fitness.common.service.UserDetailsServiceImpl
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FilterConfig(
    private val tokenService: TokenService,
    private val userDetailsService: UserDetailsServiceImpl
) {

    @Bean
    fun customHeaderFilterRegistrationBean(): FilterRegistrationBean<AddResponseHeaderFilter> {
        val registrationBean = FilterRegistrationBean<AddResponseHeaderFilter>()
        registrationBean.filter = AddResponseHeaderFilter(tokenService, userDetailsService)
        registrationBean.addUrlPatterns("/*")
        return registrationBean
    }
}