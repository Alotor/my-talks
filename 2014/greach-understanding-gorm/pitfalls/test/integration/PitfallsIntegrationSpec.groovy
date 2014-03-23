import grails.test.spock.IntegrationSpec
import spock.lang.IgnoreRest

class PitfallsIntegrationSpec extends IntegrationSpec {
    static transactional = false

    def bookService

    void "When did I modified that object?"() {
        setup:
            def controller = new BookController()
            controller.params.isbn = isbn

        and: "Book object"
            def book = new Book(title:title, isbn:isbn, price:price).save()

        when:
            controller.renderBook()

        then:
            Book.findByIsbn(isbn).title == title

        where:
            isbn = "test"
            title = "name"
            price = 200
    }

    void "Rollback where are you?"() {
        setup: "Book object"
            def book = new Book(title:title, isbn:isbn, price:price, stock: 0).save()

        when:
            bookService.buyBook(user, title, qty)

        then:
            thrown(Exception)
            BookOrder.count() == 0

        where:
            isbn = "test"
            title = "name"
            price = 200
            user = "user"
            qty = 10
    }

    @IgnoreRest
    void "Concurrency, It's easy!!"() {
        setup: "Book object"
            def book = new Book(title:title, isbn:isbn, price:price, stock: 0).save()

        and: "Orders"
            users.each { user->
                new BookOrder(user:user,book: book, quantity:10).save()
            }

        when:
            bookService.processOrders()

        then:
            BookOrder.countBySent(true) == users.size()

        where:
            users = ["one", "two", "three"]
            isbn = "test"
            title = "name"
            price = 200
    }
}
