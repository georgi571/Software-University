function attachEvents() {
    const BASE_URL = 'http://localhost:3030/jsonstore/tasks';

    const titleElement = document.querySelector('#title');

    const loadAllButtonElements = document.querySelector('#load-button');
    const addToDoButtonElements = document.querySelector('#add-button');

    const toDoListListElements = document.querySelector('#todo-list')

    loadAllButtonElements.addEventListener('click', loadAllToDo);
    addToDoButtonElements.addEventListener('click', addToDo);

    async function loadAllToDo() {
        event.preventDefault();
        toDoListListElements.innerHTML = '';
        const response = await fetch(BASE_URL);
        const result = await response.json();
        const toDoList = Object.values(result);
        const toDoListElements = toDoList.map(toDo => createVacationElement(toDo.name, toDo._id));
        toDoListListElements.append(...toDoListElements);
    }

    async function addToDo() {
        event.preventDefault();
        const name = titleElement.value;

        clearInputs();

        const response = await fetch(BASE_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({name: name}),
        });

        const newToDo = await response.json();
        const newToDoElement = createVacationElement(newToDo.name, newToDo._id);
        toDoListListElements.appendChild(newToDoElement);

        await loadAllToDo();
    }

    function createVacationElement(name, toDoID) {
        const liElement = document.createElement('li');
        liElement.setAttribute('class', 'container');

        const spanElement = document.createElement('span');
        spanElement.textContent = name;

        liElement.appendChild(spanElement);

        const buttonRemoveElement = document.createElement('button');
        buttonRemoveElement.textContent = 'Remove';

        buttonRemoveElement.addEventListener('click', async () => {
            await fetch(`${BASE_URL}/${toDoID}`, {
                method: 'DELETE',
            });
            liElement.remove();
        })

        const buttonEditElement = document.createElement('button');
        buttonEditElement.textContent = 'Edit';

        buttonEditElement.addEventListener('click', async () => {
            const spanValue = spanElement.textContent;
            liElement.removeChild(spanElement);
            liElement.removeChild(buttonRemoveElement);
            liElement.removeChild(buttonEditElement);
            const inputElement = document.createElement('input');
            inputElement.value = spanValue;
            const buttonSubmitElement = document.createElement('button');
            buttonSubmitElement.textContent = 'Submit';
            buttonSubmitElement.addEventListener('click', async () => {
                const newInput = inputElement.value;
                await fetch(`${BASE_URL}/${toDoID}`, {
                        method: 'PUT',
                        headers: {
                            'Content-Type': 'application/json',
                        },
                        body: JSON.stringify({name: newInput, _id: toDoID}),
                    });

                spanElement.textContent = newInput;
                liElement.innerHTML = ''; // Clear all current children

                liElement.appendChild(spanElement);
                liElement.appendChild(buttonRemoveElement);
                liElement.appendChild(buttonEditElement);


            })
            liElement.appendChild(inputElement);
            liElement.appendChild(buttonRemoveElement);
            liElement.appendChild(buttonSubmitElement);
        })

        liElement.appendChild(buttonRemoveElement);
        liElement.appendChild(buttonEditElement);

        return liElement;
    }

    function clearInputs() {
        titleElement.value = '';
    }
}

attachEvents();
