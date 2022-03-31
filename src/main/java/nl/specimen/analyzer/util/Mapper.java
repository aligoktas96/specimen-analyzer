package nl.specimen.analyzer.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.specimen.analyzer.model.dto.CodeDTO;
import nl.specimen.analyzer.model.entity.Code;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public CodeDTO entityToDTO(Code code) {
        return objectMapper.convertValue(code, CodeDTO.class);
    }

    public Code DTOToEntity(CodeDTO codeDTO) {
        return objectMapper.convertValue(codeDTO, Code.class);
    }
}
