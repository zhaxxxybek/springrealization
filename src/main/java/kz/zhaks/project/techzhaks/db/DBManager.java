package kz.zhaks.project.techzhaks.db;

import kz.zhaks.project.techzhaks.db.Music;

import java.util.ArrayList;

public class DBManager {
    private static final ArrayList<Music> musics=new ArrayList<>();
    private static long id=6l;
     static {
        musics.add(new Music(1l,"Music 1","Author 1 ",200));
        musics.add(new Music(2l,"Music 2","Author 2 ",201));
        musics.add(new Music(3l,"Music 3","Author 3 ",202));
        musics.add(new Music(4l,"Music 4","Author 4 ",125));
        musics.add(new Music(5l,"Music 5","Author 5 ",110));
    }
    public static ArrayList<Music> getMusics(){
        return musics;
    }
    public static void addMusic(Music music){
         music.setId(id);
         id++;
         musics.add(music);

    }
    public static Music getMusic(int id){
         return musics.stream().filter(music -> music.getId()==id).findFirst().orElse(null);
    }

}
