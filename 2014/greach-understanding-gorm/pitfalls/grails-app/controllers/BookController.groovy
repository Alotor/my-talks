
class BookController {
    def renderBook(String isbn) {
        def book = Book.findByIsbn(isbn)

        // Render as uppercase
        book.title = book.title.toUpperCase()

        [book: book]
    }
}
