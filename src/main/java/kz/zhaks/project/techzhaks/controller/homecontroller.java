package kz.zhaks.project.techzhaks.controller;


import kz.zhaks.project.techzhaks.model.GenreModel;
import kz.zhaks.project.techzhaks.model.MusicModel;
import kz.zhaks.project.techzhaks.service.AuthorService;
import kz.zhaks.project.techzhaks.service.GenreService;
import kz.zhaks.project.techzhaks.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class homecontroller {


    private final MusicService musicService;
    private final AuthorService authorService;
    private final GenreService genreService;
    @GetMapping(value = "/")
    public String indexPage(Model model,
                            @RequestParam(name = "key",required = false,defaultValue = "") String key){
        model.addAttribute("muzikalar", musicService.searchMusic(key));
        return "index";

    }
    @PostMapping(value = "/add-music")
    public String addMusic(MusicModel music){
        musicService.addMusic(music);
        return "redirect:/";

    }

    @GetMapping(value = "/add-music")
    public String addMusicPage(Model model){
        model.addAttribute("authors",authorService.getAuthorslist());
        return "addmusic";

    }
    @GetMapping(value = "/details/{musicId}")
    public String musicDetails(@PathVariable(name = "musicId")long id,Model model){
        MusicModel music =musicService.getMusic(id);
        model.addAttribute("myzyka",music);

        model.addAttribute("authors",authorService.getAuthorslist());
        List<GenreModel> genreModelList= genreService.getGenres();
        genreModelList.removeAll(genreService.getGenres());
        model.addAttribute("genres",genreService.getGenres());
        return "details";

    }
    @PostMapping(value = "/save-music")
    public String saveMusic(MusicModel music){
        musicService.saveMusic(music); //update
        return "redirect:/";
    }
    @PostMapping(value = "/delete-music")
    public String deleteMusic(@RequestParam(name = "id")Long id){
        musicService.deleteMusic(id);
        return "redirect:/";
    }
    @PostMapping(value = "/assign-genre")
    public String assignGenre(@RequestParam(name="music_id")Long musicId,
                              @RequestParam(name="genre_id")Long genreId){
        musicService.assignGenre(musicId,genreId);
        return "redirect:/details/"+musicId;

    }
    @PostMapping(value = "/unassign-genre")
    public String unassignGenre(@RequestParam(name="music_id")Long musicId,
                              @RequestParam(name="genre_id")Long genreId){
        musicService.unassignGenre(musicId,genreId);

        return "redirect:/details/"+musicId;

    }

}
