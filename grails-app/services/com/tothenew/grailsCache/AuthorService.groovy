package com.tothenew.grailsCache

import grails.transaction.Transactional
import org.springframework.cache.annotation.Cacheable


@Transactional
class AuthorService {

    @Cacheable("mess")
    public Author fetchAuthor() {
        return Author.read(1)
    }

    @Cacheable('fetchAuthorByName')
    Author fetchAuthorByName(String name) {
        return Author.findByName(name)
    }
}
