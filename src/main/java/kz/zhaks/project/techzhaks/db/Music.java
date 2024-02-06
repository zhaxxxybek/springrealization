package kz.zhaks.project.techzhaks.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Music {

    private long id;
    private String name;
    private String author;
    private int duration;

}
