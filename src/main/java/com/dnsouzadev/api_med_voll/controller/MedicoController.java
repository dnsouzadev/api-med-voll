package com.dnsouzadev.api_med_voll.controller;

import com.dnsouzadev.api_med_voll.medico.CadastroMedico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @PostMapping
    public void cadastrar(@RequestBody CadastroMedico medico) {
        System.out.println(medico);
    }

}
