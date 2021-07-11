package com.urlshortner.springbootapp.repository;


import com.urlshortner.springbootapp.model.ShortnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortnerRepository  extends JpaRepository<ShortnerEntity, Long> {
    ShortnerEntity findByshortid(String shortid);
    ShortnerEntity findBylongid(String longid);

}
