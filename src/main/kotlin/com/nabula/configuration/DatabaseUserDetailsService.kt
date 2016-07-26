package com.nabula.configuration

import com.nabula.repo.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

/**
 * Created by harihar on 21/07/16.
 */
@Component
class DatabaseUserDetailsService @Autowired constructor(val userRepo: UserRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {

        val user = userRepo.findByUsername(username) ?: throw IllegalArgumentException("Username does not exist")
        val accountNonExpired = true
        val credentialsNonExpired = true
        val accountNonLocked = !user.isLocked
        val authorities = listOf<GrantedAuthority>(SimpleGrantedAuthority("USER"))

        val springUser = org.springframework.security.core.userdetails.User(
                user.username, user.password, user.isEnabled,
                accountNonExpired, credentialsNonExpired, accountNonLocked,
                authorities)
        return springUser
        //return UserDetailsImpl(User())
    }
}