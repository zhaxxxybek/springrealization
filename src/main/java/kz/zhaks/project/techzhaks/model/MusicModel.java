package kz.zhaks.project.techzhaks.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="z_musics")
@Getter
@Setter
public class MusicModel{
    @Id // примари кей
    @GeneratedValue(strategy = GenerationType.IDENTITY) //тоже самое что и авто инкремент
    @Column(name = "id") //колумн нейм
    private long id;
    @Column(name = "music_name")
    private String name;

    @Column(name = "music_duration")
    private int duration;
    @ManyToOne
    private AuthorModal authorModal;
    @ManyToMany
    private List<GenreModel> genres;
    @PrePersist //настаивание
    public void checkForNegativeDuration(){
        if (this.duration<=0){
            this.duration=180;
        }
    }

}
