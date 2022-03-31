package nl.specimen.analyzer.service;

import nl.specimen.analyzer.model.dto.CodeDTO;
import nl.specimen.analyzer.model.entity.Code;
import nl.specimen.analyzer.repository.CodeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CodeServiceTest {

    @MockBean
    private CodeRepository codeRepository;

    @Autowired
    private CodeService codeService;

    private String code;

    private Date date;

    private Code generatedCode;

    @BeforeEach
    void setUp() {
        code = "271636001";
        date = Date.from(Instant.now());
        generatedCode = getCode();

        when(codeRepository.findByCode(anyString())).thenReturn(Optional.of(generatedCode));
        when(codeRepository.findAll()).thenReturn(List.of(generatedCode));

        doNothing().when(codeRepository).deleteAll();
    }

    @Test
    void findByCodeShouldBeCalledWhenTriggeredGetSingle() {
        codeService.getSingle(code);

        verify(codeRepository, times(1)).findByCode(code);
    }

    @Test
    void findAllShouldBeCalledWhenTriggeredGetAll() {
        List<CodeDTO> all = codeService.getAll();

        Assertions.assertEquals(all.size(), 1);

        verify(codeRepository, times(1)).findAll();
    }

    @Test
    void removeAllShouldBeCalledWhenTriggeredDeleteAll() {
        codeService.removeAll();

        verify(codeRepository, times(1)).deleteAll();
    }

    private Code getCode() {
        return new Code("ZIB", "ZIB001", code,
                "Polsslag regelmatig", "The long description is necessary",
                date, date, "1");
    }
}
