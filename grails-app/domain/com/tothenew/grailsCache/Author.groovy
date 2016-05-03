package com.tothenew.grailsCache

class Author {

    String name
    String email
    Integer age

    static constraints = {
    }

    static mapping = {
        cache true
    }
}
