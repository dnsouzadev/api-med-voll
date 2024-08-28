package com.dnsouzadev.api_med_voll.controller;

import com.dnsouzadev.api_med_voll.medico.CadastroMedico;
import com.dnsouzadev.api_med_voll.medico.DadosListagemMedico;
import com.dnsouzadev.api_med_voll.medico.Medico;
import com.dnsouzadev.api_med_voll.medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid CadastroMedico medico) {
        repository.save(new Medico(medico));
    }

    @GetMapping
    public List<DadosListagemMedico> listar() {
        return repository.findAll().stream()
                .map(DadosListagemMedico::new)
                .toList();
    }

}
