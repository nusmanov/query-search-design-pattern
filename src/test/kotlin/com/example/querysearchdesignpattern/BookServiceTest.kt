package com.example.querysearchdesignpattern

import org.junit.jupiter.api.Test

internal class BookServiceTest {

    data class FilterTest(val key: CategorySupportedFilterEnums, val value: String)

    @Test
    fun createBook() {

        val testRequest = "/api/v1/Category?offset=0&embed=&countAll=true&limit=50&objectType=Task&emptyState=false".substringAfter("?")


        val parseFilter = testRequest.split("&")

        val queryStrategies = mutableMapOf<CategorySupportedFilterEnums, QueryStrategy>()
        // queryStrategies.put(CategorySupportedFilterEnums.OBJECT_TYPE,  )
        val list = mutableListOf<FilterTest>()
        val all = mutableListOf<Pair<String, String>>()

        parseFilter.forEach {
            val splitted = it.split("=")
            val key = splitted[0]
            val value = splitted[1]

            all.add(Pair(key, value))

            if (CategorySupportedFilterEnums.values().map { x -> x.value }.contains(key))
                list.add(FilterTest(CategorySupportedFilterEnums.buildFromValue(key), value))
        }


        println(all)
        println(list)
        println("OK")
    }
}

data class QueryStrategy(val foo: String)
