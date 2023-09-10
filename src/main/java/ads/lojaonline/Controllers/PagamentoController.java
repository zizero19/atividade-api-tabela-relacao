package ads.lojaonline.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ads.lojaonline.Entities.Endereco;
import ads.lojaonline.Entities.Pagamento;
import ads.lojaonline.Repository.PagamentoRepository;

@RestController
@RequestMapping(value = "/pagamento")
public class PagamentoController {

    @Autowired
    PagamentoRepository pRepository;

    @PostMapping("/cadastro")
    public String cadastroPagamento(Pagamento pagamento) {
        pRepository.save(pagamento);
        return "";
    }

    @GetMapping("/lista")
    public List<Pagamento> listaPagamentos() {
        List<Pagamento> pagamentos = pRepository.findAll();
        return pagamentos;
    }

    @GetMapping("/busca/{id}")
    public Pagamento buscaPagamento(@PathVariable("id") int id) {
        Pagamento pagamento = pRepository.findById(id).get();
        return pagamento;
    }

    @GetMapping("/excluir/{id}")
    public String deletaPagamento(@PathVariable("id") int id) {
        pRepository.deleteById(id);
        return "";
    }
}
