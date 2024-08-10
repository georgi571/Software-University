window.addEventListener("load", solve);

function solve() {
    const placeElement = document.querySelector('#place');
    const actionElement = document.querySelector('#action');
    const personElement = document.querySelector('#person');
    const buttonElement = document.querySelector('#add-btn');
    const taskListElement = document.querySelector('#task-list')
    const doneListElement = document.querySelector('#done-list')
    buttonElement.addEventListener('click', (event) => {
        event.preventDefault();
        if (placeElement.value !== '' && actionElement.value !== '' && personElement.value !== '') {
            const liElement = document.createElement('li');
            const articleElement = document.createElement('article');
            const p1Element = document.createElement('p');
            p1Element.textContent = `Place:${placeElement.value}`;
            const p2Element = document.createElement('p');
            p2Element.textContent = `Action:${actionElement.value}`;
            const p3Element = document.createElement('p');
            p3Element.textContent = `Person:${personElement.value}`;
            const divElement = document.createElement('div');
            const editElement = document.createElement('button');
            const doneElement = document.createElement('button');
            articleElement.appendChild(p1Element);
            articleElement.appendChild(p2Element);
            articleElement.appendChild(p3Element);
            liElement.setAttribute('class', 'clean-task');
            divElement.setAttribute('class', 'buttons');
            editElement.setAttribute('class', 'edit');
            editElement.textContent = 'Edit';
            doneElement.setAttribute('class', 'done');
            doneElement.textContent = 'Done';
            divElement.appendChild(editElement);
            divElement.appendChild(doneElement);
            liElement.appendChild(articleElement);
            liElement.appendChild(divElement);
            taskListElement.appendChild(liElement);
            placeElement.value = '';
            actionElement.value = '';
            personElement.value = '';
            taskListElement.addEventListener('click', () => {
                placeElement.value = p1Element.textContent.replace('Place:', '');
                actionElement.value = p2Element.textContent.replace('Action:', '');
                personElement.value = p3Element.textContent.replace('Person:', '');
                taskListElement.removeChild(liElement);
            });
            doneElement.addEventListener('click', () => {
                divElement.remove();
                const deleteElement = document.createElement('button');
                deleteElement.setAttribute('class', 'delete');
                liElement.appendChild(deleteElement);
                doneListElement.appendChild(liElement);
                deleteElement.addEventListener('click', () => {
                    doneListElement.removeChild(liElement);
                });
            });
        }
    })
}