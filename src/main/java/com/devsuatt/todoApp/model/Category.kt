package com.devsuatt.todoApp.model

import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Category(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String?,
    val name: String?,

//    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
//    val tasks: Set<Task>? = emptySet(),

) {

}
