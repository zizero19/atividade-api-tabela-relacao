package ads.lojaonline.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ads.lojaonline.Entities.Pedido;
import ads.lojaonline.Repository.PedidoRepository;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {

    @Autowired
    PedidoRepository pRepository;

    @PostMapping("/cadastro")
    public String cadastroPedido(Pedido pedido) {
        pRepository.save(pedido);
        return "";
    }

    @GetMapping("/lista")
    public List<Pedido> listaPedidos() {
        List<Pedido> pedidos = pRepository.findAll();
        return pedidos;
    }

    @GetMapping("/busca/{id}")
    public Pedido buscaPedido(@PathVariable("id") int id) {
        Pedido pedido = pRepository.findById(id).get();
        return pedido;
    }

    @GetMapping("/excluir/{id}")
    public String deletaPedido(@PathVariable("id") int id) {
        pRepository.deleteById(id);
        return "";
    }
}
