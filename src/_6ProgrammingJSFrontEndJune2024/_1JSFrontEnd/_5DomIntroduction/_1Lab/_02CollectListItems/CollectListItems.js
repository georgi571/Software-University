function extractText() {
    const itemsElements = document.querySelectorAll('ul#items li');
    const textAreaElements = document.querySelector('#result');
    for (let itemsElement of itemsElements) {
        textAreaElements.value += itemsElement.textContent + '\n';
    }
}