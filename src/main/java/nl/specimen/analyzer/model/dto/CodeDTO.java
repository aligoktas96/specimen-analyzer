package nl.specimen.analyzer.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeDTO {
    private String source;
    private String codeListCode;
    private String code;
    private String displayValue;
    private String longDescription;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fromDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date toDate;
    private String sortingPriority;
}
