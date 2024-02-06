package kz.zhaks.project.techzhaks.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "author_modal")
@Getter
@Setter
public class AuthorModal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="full_name")
    private String fullname;
    @Column(name="nickname")
    private String nickname;
}
