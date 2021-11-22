package com.example.querysearchdesignpattern

data class QueryFilterDto(val pagination: Pagination, val countAll: Int, val orderBy: OrderBy)

data class OrderBy(val orderBy: List<String>)

data class Pagination(val limit: Int, val offset: Int)
