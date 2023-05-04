package com.example.iceeteaserver.domain.admin.presentation

import com.example.iceeteaserver.domain.admin.presentation.dto.response.GetBuyerListResponse
import com.example.iceeteaserver.domain.admin.service.GetBuyerListService
import com.example.iceeteaserver.domain.admin.service.SearchBuyerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/admin/buyer")
class AdminController(
    private val getBuyerListService: GetBuyerListService,
    private val searchBuyerService: SearchBuyerService
) {

    @GetMapping
    fun getBuyer() : ResponseEntity<List<GetBuyerListResponse>> =
        getBuyerListService.execute()
            .let { ResponseEntity.ok(it) }

    @GetMapping("/search")
    fun searchBuyer(@RequestParam name : String) : ResponseEntity<List<GetBuyerListResponse>> =
        searchBuyerService.execute(name)
            .let { ResponseEntity.ok(it) }


}