package nl.specimen.analyzer.util;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import nl.specimen.analyzer.model.dto.CodeDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
public class CsvReader {
    public List<CodeDTO> readCodesFromCsvFile(MultipartFile file) throws IOException {
        MappingIterator<CodeDTO> codeDTOIterator = new CsvMapper()
                .readerWithSchemaFor(CodeDTO.class)
                .with(CsvSchema.emptySchema().withHeader())
                .readValues(file.getInputStream());

        return codeDTOIterator.readAll();
    }
}
