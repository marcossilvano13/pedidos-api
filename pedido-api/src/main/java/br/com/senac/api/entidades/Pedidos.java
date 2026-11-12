package br.com.senac.api.entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeCliente;

    @OneToMany(mappedBy = "pedido")
    @JsonManagedReference
    private List<PedidosItens> pedidosItens = new ArrayList<>();

    public List<PedidosItens> getPedidosItens() {
        return pedidosItens;
    }

    public void setPedidosItens(List<PedidosItens> pedidosItens) {
        this.pedidosItens = pedidosItens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}
