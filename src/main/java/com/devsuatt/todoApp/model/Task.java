package com.devsuatt.todoApp.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
public class Task {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String header;
    private String description;
    private LocalDateTime transactionDate;
    private TaskType taskType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Task(String header, String description, LocalDateTime transactionDate, User user) {
        this.id = "";
        this.header = header;
        this.description = description;
        this.transactionDate = transactionDate;
        this.taskType = TaskType.TODO;
        this.user = user;
    }
}
