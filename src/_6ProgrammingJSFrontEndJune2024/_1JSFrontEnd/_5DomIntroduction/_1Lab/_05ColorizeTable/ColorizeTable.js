function colorize() {
    const evenRowElements = document.querySelectorAll('table tr:nth-child(2n)');
    for (let evenRowElement of evenRowElements) {
        evenRowElement.style.backgroundColor = 'teal';
    }
}