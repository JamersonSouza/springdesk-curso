package tech.jamersondev.springdesk.services;

import com.opencsv.CSVWriter;
import org.springframework.stereotype.Service;
import tech.jamersondev.springdesk.model.Chamado;
import tech.jamersondev.springdesk.repository.ChamadoRepository;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Service
public class ChamadoService {

    private final ChamadoRepository chamadoRepository;

    public ChamadoService(ChamadoRepository chamadoRepository) {
        this.chamadoRepository = chamadoRepository;
    }

    public void exportCsv(Writer writer) throws IOException {
        List<Chamado> tickets = chamadoRepository.findAll();
        try(CSVWriter csvWriter = new CSVWriter(writer, ';'
        , CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END)){

            String[] header = {"ID", "Título", "Data de Abertura", "Status", "Técnico Resposável",
            "Observação"};

            csvWriter.writeNext(header);
            for (Chamado ticket : tickets){
                String[] body = {
                        String.valueOf(ticket.getId()),
                        ticket.getTitulo(),
                        ticket.getDataAbertura().toString(),
                        ticket.getStatus().toString(),
                        ticket.getTecnico().getNome(),
                        ticket.getObservacao(),
                };
                csvWriter.writeNext(body);
            }

        }

    }

}
