import com.tothenew.grailsCache.Author

class BootStrap {

    def init = { servletContext ->

        if (!Author.count()) {
            10.times {
                new Author(name: "Author ${it}", age: it, email: "author${it}@gmail.com").save()
            }
        }

    }
    def destroy = {
    }
}
