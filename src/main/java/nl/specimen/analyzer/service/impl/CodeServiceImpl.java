package nl.specimen.analyzer.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import nl.specimen.analyzer.common.exception.BusinessException;
import nl.specimen.analyzer.common.exception.ExceptionCode;
import nl.specimen.analyzer.model.dto.CodeDTO;
import nl.specimen.analyzer.model.entity.Code;
import nl.specimen.analyzer.repository.CodeRepository;
import nl.specimen.analyzer.service.CodeService;
import nl.specimen.analyzer.util.CsvReader;
import nl.specimen.analyzer.util.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CodeServiceImpl implements CodeService {

    private final CodeRepository repository;
    private final CsvReader csvReader;
    private final Mapper mapper;

    @SneakyThrows
    @Override
    public List<CodeDTO> importFromCsv(MultipartFile file) {
        List<CodeDTO> codeDTOs = csvReader.readCodesFromCsvFile(file);

        List<Code> codes = codeDTOs
                .stream()
                .map(mapper::DTOToEntity)
                .collect(Collectors.toList());

        repository.saveAll(codes);

        return codeDTOs;
    }

    @Override
    public List<CodeDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CodeDTO getSingle(String code) {
        Code maybeCode = repository
                .findByCode(code)
                .orElseThrow(() -> new BusinessException(ExceptionCode.CODE_NOT_FOUND));

        return mapper.entityToDTO(maybeCode);
    }

    @Override
    public void removeAll() {
        repository.deleteAll();
    }
}
