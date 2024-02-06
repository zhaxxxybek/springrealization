package kz.zhaks.project.techzhaks.service;

import kz.zhaks.project.techzhaks.model.GenreModel;
import kz.zhaks.project.techzhaks.repository.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;
    public List<GenreModel> getGenres(){
        return genreRepository.findAll();
    }
    public GenreModel getGenre(Long id){
       return genreRepository.findById(id).orElseThrow();
    }

}
