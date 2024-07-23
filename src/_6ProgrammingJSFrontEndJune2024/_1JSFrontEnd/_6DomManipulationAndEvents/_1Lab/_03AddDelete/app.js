function addItem() {
    const inputElement = document.querySelector('#newItemText');
    const itemListElement = document.querySelector('#items');
    const newInput = document.createElement('li');
    newInput.textContent = inputElement.value;
    const deleteElement = document.createElement('a');
    deleteElement.textContent = '[Delete]';
    deleteElement.href = '#';
    deleteElement.addEventListener('click', () => {
        newInput.remove();
    })
    newInput.appendChild(deleteElement);
    itemListElement.appendChild(newInput);
    inputElement.value = '';
}