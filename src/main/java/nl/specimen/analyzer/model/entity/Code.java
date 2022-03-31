package nl.specimen.analyzer.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "code")
@RequiredArgsConstructor
@AllArgsConstructor
public class Code {
    @Column(name = "source")
    private String source;

    @Column(name = "code_list_code")
    private String codeListCode;

    @Id
    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "display_value")
    private String displayValue;

    @Column(name = "long_description")
    private String longDescription;

    @Column(name = "from_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fromDate;

    @Column(name = "to_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date toDate;

    @Column(name = "sorting_priority")
    private String sortingPriority;
}
