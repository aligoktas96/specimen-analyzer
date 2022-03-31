package nl.specimen.analyzer.service;


import nl.specimen.analyzer.model.dto.CodeDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CodeService {
    List<CodeDTO> importFromCsv(MultipartFile file);

    List<CodeDTO> getAll();

    CodeDTO getSingle(String code);

    void removeAll();
}
