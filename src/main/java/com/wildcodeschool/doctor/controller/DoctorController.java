package com.wildcodeschool.doctor.controller;

import com.wildcodeschool.doctor.model.Doctor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class DoctorController {

    @GetMapping("/doctor/{number}")
    @ResponseBody
    public Doctor doctor(@PathVariable int number) {
        if (number <= 12 && number >= 1) {
            throw new ResponseStatusException(HttpStatus.resolve(303));
        } else if (number != 13) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Impossible de récupérer l'incarnation %d", number));
        }
        return new Doctor(13, "Jodie Whittaker");
    }
}
