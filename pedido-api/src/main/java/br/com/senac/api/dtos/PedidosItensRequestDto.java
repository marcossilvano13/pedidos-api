package br.com.senac.api.dtos;

public class PedidosItensRequestDto {
    private Double quantidade;

    private Long pedido;

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Long getPedido() {
        return pedido;
    }

    public void setPedido(Long pedido) {
        this.pedido = pedido;
    }
}
