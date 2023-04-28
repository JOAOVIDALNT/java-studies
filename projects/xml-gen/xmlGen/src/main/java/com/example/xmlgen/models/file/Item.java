package com.example.xmlgen.models.file;

import com.example.xmlgen.models.enums.TipoItem;
import com.example.xmlgen.models.enums.UN;

import java.math.BigDecimal;

public class Item {
    private String codigo;
    private String descricao;
    private UN un;
    private Integer qtde;
    private BigDecimal vlr_unit;
    private TipoItem tipo;
    private String origem;


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public UN getUn() {
        return un;
    }

    public void setUn(UN un) {
        this.un = un;
    }

    public Integer getQtde() {
        return qtde;
    }

    public void setQtde(Integer qtde) {
        this.qtde = qtde;
    }

    public BigDecimal getVlr_unit() {
        return vlr_unit;
    }

    public void setVlr_unit(BigDecimal vlr_unit) {
        this.vlr_unit = vlr_unit;
    }

    public TipoItem getTipo() {
        return tipo;
    }

    public void setTipo(TipoItem tipo) {
        this.tipo = tipo;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
}
