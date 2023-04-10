package com.example.iceeteaserver.domain.admin.service

import com.example.iceeteaserver.domain.admin.presentation.dto.response.GetBuyerListResponse

interface GetBuyerListService {
    fun execute() : List<GetBuyerListResponse>
}