//package com.example.newjiraback.model;
//
//import lombok.*;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//import java.time.OffsetDateTime;
//import java.util.List;
//
//@Builder
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "sprint")
//public class Sprint {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_sprint")
//    @SequenceGenerator(name = "seq_sprint", allocationSize = 1, initialValue = 1000)
//    @Column(name = "id", nullable = false, unique = true)
//    private Long id;
//
//    @NotBlank
//    @Column(name = "title", nullable = false)
//    private String title;
//
//    @Column(name = "goal")
//    private String goal;
//
//    @Column(name = "create_date")
//    private OffsetDateTime createDate;
//
//    @Column(name = "update_date")
//    private OffsetDateTime updateDate;
//
//    @Column(name = "start_date")
//    private OffsetDateTime startDate;
//
//    @Column(name = "end_date")
//    private OffsetDateTime endDate;
//
//    @OneToMany(mappedBy = "cart")
//    private List<Todo> todo;
//}
