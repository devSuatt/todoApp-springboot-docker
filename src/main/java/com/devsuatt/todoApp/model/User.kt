package com.devsuatt.todoApp.model

import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class User(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String?,
    val username: String?,
    val password: String?,

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    val tasks: Set<Task>? = emptySet(),

    ) {

    constructor(username: String, password: String) : this("", username, password, HashSet())

}
