package com.example.iceeteaserver.domain.admin.service

import com.example.iceeteaserver.domain.admin.presentation.dto.response.GetBuyerListResponse

interface SearchBuyerService {
    fun execute(buyerName: String): List<GetBuyerListResponse>
}