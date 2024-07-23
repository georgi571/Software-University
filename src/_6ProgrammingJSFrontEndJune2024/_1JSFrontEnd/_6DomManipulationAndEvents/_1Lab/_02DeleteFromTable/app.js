function deleteByEmail() {
    const inputElement = document.querySelector('input[name=email]');
    const resultElement = document.querySelector('#result');
    const tableRowElements = document.querySelectorAll('table#customers tbody tr');
    const tableRowElement = Array
        .from(tableRowElements)
        .find(element => element.children[1].textContent === inputElement.value);
    if (tableRowElement) {
        tableRowElement.remove();
        resultElement.textContent = 'Deleted.';
    } else {
        resultElement.textContent = 'Not found.';
    }
    inputElement.value = '';
}