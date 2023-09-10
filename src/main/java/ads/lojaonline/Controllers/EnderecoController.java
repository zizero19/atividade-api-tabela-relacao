package ads.lojaonline.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ads.lojaonline.Entities.Endereco;
import ads.lojaonline.Repository.EnderecoRepository;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {

    @Autowired
    EnderecoRepository eRepository;

    @PostMapping("/cadastro")
    public String cadastroEndereco(Endereco endereco) {
        eRepository.save(endereco);
        return "";
    }

    @GetMapping("/lista")
    public List<Endereco> listaEnderecos() {
        List<Endereco> enderecos = eRepository.findAll();
        return enderecos;
    }

    @GetMapping("/busca/{id}")
    public Endereco buscaEndereco(@PathVariable("id") int id) {
        Endereco endereco = eRepository.findById(id).get();
        return endereco;
    }

    @GetMapping("/excluir/{id}")
    public String deletaEndereco(@PathVariable("id") int id) {
        eRepository.deleteById(id);
        return "";
    }

}
