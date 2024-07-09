function addressBook(input) {
    let addressBook = {};
    for (let inputElement of input) {
        const personInfo = inputElement.toString().split(':');
        addressBook[personInfo[0]] = personInfo[1];
    }
    const sortedBook = Object.entries(addressBook).sort((a, b) => a[0].localeCompare(b[0]));
    addressBook = Object.fromEntries(sortedBook);
    for (let personAddress in addressBook) {
        console.log(`${personAddress} -> ${addressBook[personAddress]}`)
    }
}