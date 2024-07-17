function bookShelf(input) {
    let shelves = {};
    for (let inputElement of input) {
        if (inputElement.includes(' -> ')) {
            const shelfInfo = inputElement.split(' -> ');
            if (!shelves.hasOwnProperty(shelfInfo[0])) {
                shelves[shelfInfo[0]] = {
                    genre: shelfInfo[1],
                    books: []
                };
            }
        } else {
            const bookAuthor = inputElement.split(', ')[0].split(': ')[1];
            const bookTitle = inputElement.split(', ')[0].split(': ')[0];
            const bookGenre = inputElement.split(', ')[1];
            for (let shelf in shelves) {
                if (shelves[shelf].genre === bookGenre) {
                    shelves[shelf].books.push({bookTitle: bookTitle, bookAuthor: bookAuthor});
                    break;
                }
            }
        }
    }
    Object.entries(shelves)
        .sort((a, b) => b[1].books.length - a[1].books.length)
        .forEach(([shelfId, shelfInfo]) => {
            shelfInfo.books.sort((a, b) => a.bookTitle.localeCompare(b.bookTitle));
            console.log(`${shelfId} ${shelfInfo.genre}: ${shelfInfo.books.length}`);
            shelfInfo.books.forEach(book => {
                console.log(`--> ${book.bookTitle}: ${book.bookAuthor}`);
            });
        });
}