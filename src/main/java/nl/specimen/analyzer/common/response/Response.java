package nl.specimen.analyzer.common.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    private Object data;
}
