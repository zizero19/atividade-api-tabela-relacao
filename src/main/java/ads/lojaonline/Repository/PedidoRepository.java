package ads.lojaonline.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ads.lojaonline.Entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
