package app;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BodyInfoRepository extends CrudRepository<BodyInfo, String>  {
    List<BodyInfo> findByName(String name);

}
