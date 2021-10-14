package cc.leonardson.uc.sistemas_distribuidos.repositories;

import cc.leonardson.uc.sistemas_distribuidos.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}
