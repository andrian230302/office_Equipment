package ua.lviv.iot.office.equipment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.office.equipment.business.MouseService;
import ua.lviv.iot.office.equipment.model.Mouse;

import java.util.List;


@RequestMapping("/mouses")
@RestController
public class MouseController {

    @Autowired
    private MouseService mouseService;

    @GetMapping
    public ResponseEntity<List<Mouse>> getMouses() {
        List<Mouse> mouseList = mouseService.findAll();
        return ResponseEntity.ok(mouseList);
    }

    @GetMapping(path = "/{producerName}")
    public ResponseEntity<List<Mouse>> getMouses(final @PathVariable("producerName") String producerName) {
        List<Mouse> mouseList = mouseService.searchByProducerName(producerName);
        return ResponseEntity.ok(mouseList);
    }

    @GetMapping(path = {"/id={id}"})
    public ResponseEntity<Mouse> getMouse(final @PathVariable("id") Integer mouseId) {

        Mouse mouse;

        ResponseEntity<Mouse> status = (mouse = mouseService.getMouse(mouseId)) == null

                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(mouse, HttpStatus.OK);
        return status;

    }

    @PostMapping
    public Mouse createMouse(final @RequestBody Mouse mouse) {
        return mouseService.createMouse(mouse);
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<Mouse> deleteMouse(@PathVariable("id") Integer mouseId) {
        HttpStatus status = mouseService.deleteMouse(mouseId) ? HttpStatus.OK : HttpStatus.NOT_FOUND;

        return ResponseEntity.status(status).build();
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<Mouse> updateMouse(final @PathVariable("id") Integer mouseId,
                                             final @RequestBody Mouse mouse) {
        mouse.setId(mouseId);
        Mouse oldMouse = mouseService.updateMouse(mouseId, mouse);

        ResponseEntity<Mouse> status = oldMouse == null
                ? new ResponseEntity<Mouse>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<Mouse>(oldMouse, HttpStatus.OK);
        return status;
    }

}
