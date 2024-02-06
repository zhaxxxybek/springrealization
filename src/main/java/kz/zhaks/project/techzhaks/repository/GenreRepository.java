package kz.zhaks.project.techzhaks.repository;

import kz.zhaks.project.techzhaks.model.GenreModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<GenreModel,Long> {

}
