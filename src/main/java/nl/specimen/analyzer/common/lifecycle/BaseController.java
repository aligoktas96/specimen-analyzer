package nl.specimen.analyzer.common.lifecycle;

import nl.specimen.analyzer.common.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {
    protected <R> ResponseEntity<Response> ok(R data, HttpStatus status) {
        return ResponseEntity.status(status).body(wrap(data));
    }

    protected <R> ResponseEntity<Response> ok(R data) {
        return ResponseEntity.ok(wrap(data));
    }

    private <R> Response wrap(R body) {
        return Response.builder()
                .data(body)
                .build();
    }
}
