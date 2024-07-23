function addItem() {
    const textElement = document.querySelector('#newItemText');
    const valueElement = document.querySelector('#newItemValue');
    const selectElement = document.querySelector('#menu');
    const newOptionElement = document.createElement('option');
    newOptionElement.value = valueElement.value;
    newOptionElement.textContent = textElement.value;
    selectElement.appendChild(newOptionElement);
    textElement.value = '';
    valueElement.value = '';
}