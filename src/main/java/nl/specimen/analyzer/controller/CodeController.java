package nl.specimen.analyzer.controller;

import lombok.RequiredArgsConstructor;
import nl.specimen.analyzer.common.lifecycle.BaseController;
import nl.specimen.analyzer.common.response.Response;
import nl.specimen.analyzer.service.CodeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("code")
@RequiredArgsConstructor
public class CodeController extends BaseController {

    private final CodeService codeService;

    /**
     * This method persists the data to the in-memory database and returns the DTOs of the persisted data
     *
     * @param file
     * @return List of Objects that are queried from the database
     */
    @PostMapping
    public ResponseEntity<Response> importFromCsv(@RequestParam("file") MultipartFile file) {
        return ok(codeService.importFromCsv(file), HttpStatus.CREATED);
    }

    /**
     * @return List of elements found in the in-memory database
     */
    @GetMapping
    public ResponseEntity<Response> getAll() {
        return ok(codeService.getAll());
    }

    /**
     * @param code The code based on which to lookup the entries
     * @return Single element if it exists
     */
    @GetMapping("/{code}")
    public ResponseEntity<Response> getSingle(@PathVariable String code) {
        return ok(codeService.getSingle(code));
    }

    /**
     * Removes all elements from the in-memory database
     *
     * @return
     */
    @DeleteMapping
    public ResponseEntity<Response> removeAll() {
        codeService.removeAll();

        return ok("Deleted all codes", HttpStatus.NO_CONTENT);
    }
}
