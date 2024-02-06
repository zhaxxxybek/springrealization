package kz.zhaks.project.techzhaks.service;

import kz.zhaks.project.techzhaks.model.GenreModel;
import kz.zhaks.project.techzhaks.model.MusicModel;
import kz.zhaks.project.techzhaks.repository.AuthorModelRepository;
import kz.zhaks.project.techzhaks.repository.GenreRepository;
import kz.zhaks.project.techzhaks.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicService {
    private final MusicRepository musicRepository;
    private final GenreService genreService;

    public List<MusicModel> searchMusic(String key){
        List<MusicModel> musicModelList=musicRepository.searchMusic("%"+key+"%");
        return musicModelList;
    }
    public MusicModel addMusic(MusicModel music){
        return musicRepository.save(music);
    }
    public MusicModel getMusic(Long id){
        return musicRepository.findById(id).orElse(null);

    }
    public MusicModel saveMusic(MusicModel music){
        return  musicRepository.save(music);
    }
    public void assignGenre(Long musicId,Long genreId){
        MusicModel musicModel=getMusic(musicId);
        GenreModel genreModel=genreService.getGenre(genreId);

        if (musicModel.getGenres()!=null&&musicModel.getGenres().size()>0){
            if (!musicModel.getGenres().contains(genreModel))
                musicModel.getGenres().add(genreModel);
        }else {
            List<GenreModel> genreModelList=new ArrayList<>();
            genreModelList.add(genreModel);
            musicModel.setGenres(genreModelList);
        }
        musicRepository.save(musicModel);
    }
    public void unassignGenre(Long musicId,Long genreId){
        MusicModel musicModel=musicRepository.findById(musicId).orElseThrow();
        GenreModel genreModel=genreService.getGenre(genreId);

        if (musicModel.getGenres()!=null&&musicModel.getGenres().size()>0){
            musicModel.getGenres().remove(genreModel);
        }
        musicRepository.save(musicModel);
    }
    public void deleteMusic(Long id){
        musicRepository.deleteById(id);
    }



}
