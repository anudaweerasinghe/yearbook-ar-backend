package anuda.me.yearbook.repositories;

import anuda.me.yearbook.entities.Videos;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface VideosRepository extends CrudRepository<Videos, Long> {

    Videos findByQrText(String qrText);

}
