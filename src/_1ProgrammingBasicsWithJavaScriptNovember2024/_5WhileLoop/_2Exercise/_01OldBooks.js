function oldBooks(input) {
    const favoriteBook = input[0];
    let currentBook = input[1];

    let count = 0;
    let found = false;

    let counter = 2;
    while (currentBook !== "No More Books") {
        if (currentBook === favoriteBook) {
            found = true;
            break;
        }
        count++;
        currentBook = input[counter++];
    }

    if (found) {
        console.log(`You checked ${count} books and found it.`);
    } else {
        console.log(`The book you search is not here!`);
        console.log(`You checked ${count} books.`);
    }

}