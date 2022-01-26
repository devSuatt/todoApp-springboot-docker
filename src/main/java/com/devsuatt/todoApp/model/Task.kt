package com.devsuatt.todoApp.model

import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Task(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    var id: String?,
    val header: String? = null,
    val description: String? = null,
    val creationDate: LocalDateTime? = LocalDateTime.now(),
    val taskType: TaskType? = TaskType.TODO,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "user_id", nullable = false)
    val user: User? = null,

//    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
//    @JoinColumn(name = "category_id", nullable = false)
//    val category: Category? = null,

    ) {

    constructor(header: String?, description: String?, user: User) : this(
        id = "",
        header,
        description,
        LocalDateTime.now(),
        TaskType.TODO,
        user
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Task

        if (id != other.id) return false
        if (header != other.header) return false
        if (description != other.description) return false
        if (creationDate != other.creationDate) return false
        if (taskType != other.taskType) return false
        if (user != other.user) return false
//        if (category != other.category) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (header?.hashCode() ?: 0)
        result = 31 * result + (description?.hashCode() ?: 0)
        result = 31 * result + (creationDate?.hashCode() ?: 0)
        result = 31 * result + (taskType?.hashCode() ?: 0)
        result = 31 * result + (user?.hashCode() ?: 0)
//        result = 31 * result + (category?.hashCode() ?: 0)
        return result
    }


}

enum class TaskType {
    DONE, TODO
}
