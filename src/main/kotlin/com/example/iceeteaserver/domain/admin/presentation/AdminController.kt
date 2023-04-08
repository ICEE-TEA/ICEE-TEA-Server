package com.example.iceeteaserver.domain.admin.presentation

import com.example.iceeteaserver.domain.admin.presentation.dto.response.GetBuyerListResponse
import com.example.iceeteaserver.domain.admin.service.GetBuyerListService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/admin/buyer")
class AdminController(
    private val getBuyerListService: GetBuyerListService
) {

    @GetMapping
    fun getBuyer() : ResponseEntity<List<GetBuyerListResponse>>{
        return getBuyerListService.execute()
            .let { ResponseEntity.ok(it) }
    }

}