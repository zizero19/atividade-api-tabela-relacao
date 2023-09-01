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
import ads.lojaonline.Entities.Usuario;
import ads.lojaonline.Repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository uRepository;

    @PostMapping("/cadastro")
    public String cadastroUsuario(Usuario usuario) {
        uRepository.save(usuario);

        return "";
    }

    @GetMapping("/lista")
    public List<Usuario> listaUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios = uRepository.findAll();

        return usuarios;
    }

    @GetMapping("/busca/{id}")
    public Usuario buscaUsuario(@PathVariable("id") int id) {
        Usuario usuario = new Usuario();
        usuario = uRepository.findById(id).get();
        return usuario;
    }

    @GetMapping("/excluir/{id}")
    public Usuario deletaUsuario(@PathVariable("id") int id) {
        Usuario usuario = new Usuario();
        usuario = uRepository.findById(id).get();
        uRepository.delete(usuario);
        return usuario;
    }
}
