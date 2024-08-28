package com.dnsouzadev.api_med_voll.controller;

import com.dnsouzadev.api_med_voll.medico.CadastroMedico;
import com.dnsouzadev.api_med_voll.medico.Medico;
import com.dnsouzadev.api_med_voll.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody CadastroMedico medico) {
        repository.save(new Medico(medico));
    }

}
