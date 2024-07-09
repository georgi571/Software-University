function phoneBook(input) {
    const phoneBook = {};
    for (let inputElement of input) {
        const personInformation = inputElement.toString().split(' ');
        phoneBook[personInformation[0]] = personInformation[1];
    }
    for (let phoneBookKey in phoneBook) {
        console.log(`${phoneBookKey} -> ${phoneBook[phoneBookKey]}`)
    }
}