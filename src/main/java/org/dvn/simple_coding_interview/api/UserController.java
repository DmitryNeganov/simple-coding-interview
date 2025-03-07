package org.dvn.simple_coding_interview.api;

import lombok.RequiredArgsConstructor;
import org.dvn.simple_coding_interview.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final MainService mainService;

    @GetMapping("/{id}")
    public @ResponseBody String getUserById(@PathVariable("id") Long id) {
        return mainService.getUser(id).toString();
    }
}
