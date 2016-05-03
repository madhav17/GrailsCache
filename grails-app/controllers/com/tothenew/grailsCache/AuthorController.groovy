package com.tothenew.grailsCache

class AuthorController {

    def authorService

    def demo() {

        println "sdfsd"
        println authorService.fetchAuthor()
        println authorService.fetchAuthor()
        println "sdfsd sdsdf"
        println authorService.fetchAuthorByName("Author 1")
        println authorService.fetchAuthorByName("Author 1")
        println "sdfsd sdsdf sdf"
        println authorService.criteriaExample()
        println authorService.criteriaExample()
        println "Without Cache"
        println authorService.fetchAuthorByNameWithOutCache("Author 4")
        println authorService.fetchAuthorByNameWithOutCache("Author 4")

        render "Done"
    }
}
