function addItem() {
    const listElements = document.getElementById('items');
    const newItemElements = document.getElementById('newItemText');
    const newCreatedElement = document.createElement('li');
    newCreatedElement.textContent = newItemElements.value;
    newItemElements.value = '';
    listElements.appendChild(newCreatedElement);
}