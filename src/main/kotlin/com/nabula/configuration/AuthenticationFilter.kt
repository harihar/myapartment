package com.nabula.configuration

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import javax.servlet.*

/**
 * Created by harihar on 25/07/16.
 */
class AuthenticationFilter : Filter {
    override fun init(filterConfig: FilterConfig?) {
        //
    }

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val username = request?.getParameter("username")
        var password = request?.getParameter("password")

        val authentication = UsernamePasswordAuthenticationToken(username, password)
        SecurityContextHolder.getContext().authentication = authentication

        chain?.doFilter(request, response)
    }

    override fun destroy() {
        //
    }
}