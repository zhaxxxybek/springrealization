package kz.zhaks.project.techzhaks.repository;

import kz.zhaks.project.techzhaks.model.MusicModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //вид бинов
    public interface MusicRepository  extends JpaRepository<MusicModel,Long> {
    List<MusicModel> findAllByDurationGreaterThanOrderByDurationDesc(int duration);
    @Query(value =
            "SELECT mm " +
            "FROM MusicModel mm " +
            "WHERE mm.duration>0 and LOWER (mm.name) LIKE LOWER(:searchName)"+
            "ORDER BY mm.duration DESC "
    )

    List<MusicModel> searchMusic(@Param("searchName")String musicName);

}
