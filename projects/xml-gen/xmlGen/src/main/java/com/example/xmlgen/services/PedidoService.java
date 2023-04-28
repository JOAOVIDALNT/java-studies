package com.example.xmlgen.services;


import com.example.xmlgen.models.Nota;
import com.example.xmlgen.models.file.Item;
import com.example.xmlgen.models.file.Pedido;
import com.example.xmlgen.repositories.NotaRepository;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private NotaRepository notaRepository;
    public String create(Pedido pedido) {
        XStream xstream = new XStream(new DomDriver());

        xstream.alias("pedido", Pedido.class);
        xstream.alias("item", Item.class);
        String xml = xstream.toXML(pedido);

        Nota nota = new Nota();
        nota.setXml(xml);
        notaRepository.save(nota);

        return xml;
    }
}
