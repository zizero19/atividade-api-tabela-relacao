package ads.lojaonline.Entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date data;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.REFRESH)
    Usuario usuario;

    @OneToOne(cascade = CascadeType.REFRESH)
    Endereco endereco;

    @OneToOne(cascade = CascadeType.REFRESH)
    Pagamento pagamento;

    public Pedido() {

    }

    public Pedido(int id, Date data, Usuario usuario, Endereco endereco, Pagamento pagamento) {
        this.id = id;
        this.data = data;
        this.usuario = usuario;
        this.endereco = endereco;
        this.pagamento = pagamento;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
