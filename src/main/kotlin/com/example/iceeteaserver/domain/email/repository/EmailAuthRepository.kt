package com.example.iceeteaserver.domain.email.repository

import com.example.iceeteaserver.domain.email.entity.EmailAuth
import org.springframework.data.repository.CrudRepository

interface EmailAuthRepository : CrudRepository<EmailAuth, String>