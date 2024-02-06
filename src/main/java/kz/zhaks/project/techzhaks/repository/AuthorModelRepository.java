package kz.zhaks.project.techzhaks.repository;

import kz.zhaks.project.techzhaks.model.AuthorModal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorModelRepository extends JpaRepository<AuthorModal,Long> {

}
