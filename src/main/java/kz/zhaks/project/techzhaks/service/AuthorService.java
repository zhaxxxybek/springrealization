package kz.zhaks.project.techzhaks.service;

import kz.zhaks.project.techzhaks.model.AuthorModal;
import kz.zhaks.project.techzhaks.repository.AuthorModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorModelRepository authorModelRepository;
    public List<AuthorModal> getAuthorslist(){
       return authorModelRepository.findAll();
    }
}
