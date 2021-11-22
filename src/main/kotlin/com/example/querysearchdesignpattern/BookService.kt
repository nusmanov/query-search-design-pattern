package com.example.querysearchdesignpattern

import org.jetbrains.exposed.sql.Op
import org.jetbrains.exposed.sql.Query
import org.jetbrains.exposed.sql.SqlExpressionBuilder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookService(val repository: BookRepository) {

    fun getBook(id: Int): BookDto = repository.getBook(id)
    fun getBooks(): List<BookDto> = repository.getAll()

    @Transactional
    fun createBook(name: String): Int = repository.create(name)

    @Transactional
    fun simSalaBin(): List<BookDto> {
        return repository.simulateParsedAndConvertedFilters()
    }

}

typealias AndTpp = SqlExpressionBuilder.() -> Op<Boolean>


enum class CategorySupportedFilterEnums(val value: String) {
    OBJECT_TYPE("objectType"),
    COUNT_ALL("countAll"),
    UNDEFINED("undefined");

    companion object {
        fun buildFromValue(value: String): CategorySupportedFilterEnums =
                when (value) {
                    "objectType" -> OBJECT_TYPE
                    "countAll" -> COUNT_ALL
                    else -> UNDEFINED
                }
    }
}