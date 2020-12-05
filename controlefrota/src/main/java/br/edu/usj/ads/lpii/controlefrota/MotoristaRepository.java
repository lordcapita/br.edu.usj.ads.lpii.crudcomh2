package br.edu.usj.ads.lpii.controlefrota;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoristaRepository extends CrudRepository <Motorista, Long> {
   
    List<Motorista> findAll();
  
    
}