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

    @Cacheable('criteriaEx')
    List<Author> criteriaExample(){

        Author.createCriteria().list(){
            ilike("name", "%Author%")
        }
    }

    Author fetchAuthorByNameWithOutCache(String name) {
        return Author.findByName(name)
    }
}
