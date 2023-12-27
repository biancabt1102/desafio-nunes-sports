package br.com.nunessports.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_Produtos")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long idProduto;
    @Column(name = "nm_produto")
    private String nomeProduto;
    @Column(name = "ds_produto")
    private String descricaoProduto;
    @Column(name = "vl_produto")
    private double precoProduto;
}
