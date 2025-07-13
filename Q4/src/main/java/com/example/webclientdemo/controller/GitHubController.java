package com.example.webclientdemo.controller;

import com.example.webclientdemo.service.GitHubClientService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/github")
public class GitHubController {

    private final GitHubClientService gitHubClientService;

    public GitHubController(GitHubClientService gitHubClientService) {
        this.gitHubClientService = gitHubClientService;
    }

    @GetMapping("/user/{username}")
    public Mono<String> getUser(@PathVariable String username) {
        return gitHubClientService.getUserDetails(username);
    }
}
