package com.crud.todolist.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.nio.file.Files;
import java.nio.file.Path;

@Controller
public class ChangelogViewController {

    @GetMapping("/changelog-view")
    public String showChangelog(Model model) {
        try {
            Path path = new ClassPathResource("CHANGELOG.md").getFile().toPath();
            String content = Files.readString(path);
            model.addAttribute("changelog", content);
            System.out.println("Caminho do arquivo: " + path.toAbsolutePath());
        } catch (Exception e) {
            model.addAttribute("changelog", "Erro ao carregar o CHANGELOG.md");
        }
        return "changelog";
    }
}

