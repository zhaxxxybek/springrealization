package kz.zhaks.project.techzhaks.dbconnect;

import kz.zhaks.project.techzhaks.db.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Component
public class MusicManager {
    @Autowired
    private DBconnector dBconnector;
    public ArrayList<Music> getMusicList(){
        ArrayList<Music> musics=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=
                    dBconnector.getConnection().prepareStatement("SELECT*FROM musics ORDER BY ASC ");
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Music music=new Music();
                music.setId(resultSet.getLong("id"));
                music.setAuthor(resultSet.getString("author"));
                music.setDuration(resultSet.getInt("duration"));
                music.setName(resultSet.getString("name"));
                musics.add(music);
            }
            preparedStatement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return musics;
    }
    public void addMusic(Music music){
        try {
            PreparedStatement preparedStatement=
                    dBconnector.getConnection().
                            prepareStatement(" "+"INSERT INTO musics(name,duration,author)VALUES (?,?,?)");
            preparedStatement.setString(1,music.getName());
            preparedStatement.setInt(2,music.getDuration());
            preparedStatement.setString(3,music.getAuthor());
            preparedStatement.executeUpdate();

            preparedStatement.close();

        }catch (Exception e){
            e.printStackTrace();
        }



    }
}

