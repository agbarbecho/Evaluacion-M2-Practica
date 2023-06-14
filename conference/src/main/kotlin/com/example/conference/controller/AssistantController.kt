package com.example.conference.controller

import com.example.conference.model.Assistant
import com.example.conference.service.AssistantService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/assistant")

class AssistantController {
    @Autowired
    lateinit var assistantService: AssistantService

    @GetMapping
    fun list ():ResponseEntity<*>{
        return ResponseEntity(assistantService.list(), HttpStatus.OK)
    }

    @GetMapping("/ages/{age}")
    fun listTotals (@PathVariable("age") age:Int ):ResponseEntity<*>{
        return ResponseEntity(assistantService.listAssistant(age),HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody @Validated assistant: Assistant):ResponseEntity<Assistant>{
        return ResponseEntity(assistantService.save(assistant),HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody assistant: Assistant):ResponseEntity<Assistant>{
        return ResponseEntity(assistantService.update(assistant), HttpStatus.OK)
    }
}