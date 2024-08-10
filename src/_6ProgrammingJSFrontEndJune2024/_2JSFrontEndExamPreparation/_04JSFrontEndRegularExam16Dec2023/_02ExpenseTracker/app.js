window.addEventListener("load", solve);

function solve() {
    const expenseElement = document.querySelector('#expense');
    const amountElement = document.querySelector('#amount');
    const dateElement = document.querySelector('#date');
    const buttonElement = document.querySelector('#add-btn');
    const previewListElement = document.querySelector('#preview-list');
    const expensesListElement = document.querySelector('#expenses-list');
    const deleteButtonElement = document.querySelector('.delete');
    buttonElement.addEventListener('click', (event) => {
        event.preventDefault();
        if (expenseElement.value !== '' && amountElement.value !== '' && dateElement.value !== '') {
            const liElement = document.createElement('li');
            const articleElement = document.createElement('article');
            const p1Element = document.createElement('p');
            p1Element.textContent = `Type: ${expenseElement.value}`;
            const p2Element = document.createElement('p');
            p2Element.textContent = `Amount: ${amountElement.value}$`;
            const p3Element = document.createElement('p');
            p3Element.textContent = `Date: ${dateElement.value}`;
            const divElement = document.createElement('div');
            const editElement = document.createElement('button');
            const okElement = document.createElement('button');
            articleElement.appendChild(p1Element);
            articleElement.appendChild(p2Element);
            articleElement.appendChild(p3Element);
            liElement.setAttribute('class', 'expense-item');
            divElement.setAttribute('class', 'buttons');
            editElement.setAttribute('class', 'btn edit');
            editElement.textContent = 'edit';
            okElement.setAttribute('class', 'btn ok');
            okElement.textContent = 'ok';
            divElement.appendChild(editElement);
            divElement.appendChild(okElement);
            liElement.appendChild(articleElement);
            liElement.appendChild(divElement);
            previewListElement.appendChild(liElement);
            expenseElement.value = '';
            amountElement.value = '';
            dateElement.value = '';
            buttonElement.disabled = true;
            previewListElement.addEventListener('click', () => {
                expenseElement.value = p1Element.textContent.replace('Type: ', '');
                amountElement.value = p2Element.textContent.replace('Amount: ', '').replace('$', '');
                dateElement.value = p3Element.textContent.replace('Date: ', '');
                previewListElement.removeChild(liElement);
                buttonElement.disabled = false;
            });
            okElement.addEventListener('click', () => {
                divElement.remove();
                expensesListElement.appendChild(liElement);
            });
        }
    })
    deleteButtonElement.addEventListener('click', () => {
        location.reload();
    });
}