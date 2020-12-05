package br.edu.usj.ads.lpii.controlefrota;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends CrudRepository<Veiculo, Long> {
    List<Veiculo> findAll();
    List<Veiculo> findByPlaca(String placa);
    List<Veiculo> findByPlacaContainingIgnoreCaseOrderByPlaca(String placa);
  
    
}
