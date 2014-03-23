import grails.transaction.Transactional
import groovyx.gpars.GParsPool

@Transactional
class BookService {
    def dispatchingService

    def buyBook(String user, String bookTitle, Long qty) {
        def found = Book.findByTitle(bookTitle)

        // Save a new order for the user
        def order = new BookOrder(user:user, book:found, quantity: qty)
        order.save()

        found.stock = found.stock - 1

        // When not found throw exception to rollback
        if (found.stock < 0) {
            throw new Exception("This should rollback!")
        }
        return found
    }

    def processOrders() {
        def orders = BookOrder.list()

        // Parallel update orders
        GParsPool.withPool(10) {
            orders.eachParallel { order ->
                dispatchingService.dispatch(order)
                order.sent = true
                order.save()
            }
        }
    }
}
