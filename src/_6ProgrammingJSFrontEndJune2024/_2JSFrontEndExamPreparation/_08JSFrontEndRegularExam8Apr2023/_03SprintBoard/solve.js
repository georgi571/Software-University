function attachEvents() {
    const BASE_URL = 'http://localhost:3030/jsonstore/tasks';

    const titleElement = document.querySelector('#title');
    const descriptionElement = document.querySelector('#description');

    const loadBoardButtonElements = document.querySelector('#load-board-btn');
    const addTaskButtonElements = document.querySelector('#create-task-btn');

    const todoListElement = document.querySelector('#todo-section .task-list');
    const inProgressListElement = document.querySelector('#in-progress-section .task-list');
    const codeReviewListElement = document.querySelector('#code-review-section .task-list');
    const doneListElement = document.querySelector('#done-section .task-list');

    loadBoardButtonElements.addEventListener('click', loadTasks);
    addTaskButtonElements.addEventListener('click', addTasks);

    async function loadTasks() {
        todoListElement.innerHTML = '';
        inProgressListElement.innerHTML = '';
        codeReviewListElement.innerHTML = '';
        doneListElement.innerHTML = '';
        const response = await fetch(BASE_URL);
        const result = await response.json();
        const tasks = Object.values(result);
        const taskElements = tasks.map(task => createTaskElement(task.title, task.description, task.status, task._id));
        for (const taskElement of taskElements) {
            const buttonElement = taskElement.querySelector('button');
            const statusText = buttonElement.textContent;

            if (statusText.includes('Move to In Progress')) {
                todoListElement.appendChild(taskElement);
            } else if (statusText.includes('Move to Code Review')) {
                inProgressListElement.appendChild(taskElement);
            } else if (statusText.includes('Move to Done')) {
                codeReviewListElement.appendChild(taskElement);
            } else if (statusText.includes('Close')) {
                doneListElement.appendChild(taskElement);
            }
        }
    }

    async function addTasks() {
        const name = titleElement.value;
        const description = descriptionElement.value;
        const status = 'ToDo';

        clearInputs();

        await fetch(BASE_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({title: name, description: description, status: status}),
        });

        await loadTasks();
    }

    function createTaskElement(title, description, status, taskID) {
        const liTaskElement = document.createElement('li');
        liTaskElement.setAttribute('class', 'task');

        const h3TaskTitleElement = document.createElement('h3');
        h3TaskTitleElement.textContent = title;
        const pDescriptionElement = document.createElement('p');
        pDescriptionElement.textContent = description;

        liTaskElement.appendChild(h3TaskTitleElement);
        liTaskElement.appendChild(pDescriptionElement);

        const buttonElement = document.createElement('button');

        let newStatus = '';
        if (status === 'ToDo') {
            newStatus = 'In Progress';
            buttonElement.textContent = 'Move to In Progress';
        } else if (status === 'In Progress') {
            buttonElement.textContent = 'Move to Code Review';
            newStatus = 'Code Review';
        } else if (status === 'Code Review') {
            buttonElement.textContent = 'Move to Done';
            newStatus = 'Done';
        } else if (status === 'Done') {
            buttonElement.textContent = 'Close';
        }

        buttonElement.addEventListener('click', async () => {
            if (newStatus !== '') {
                await fetch(`${BASE_URL}/${taskID}`, {
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify({title: title, description: description, status: newStatus, _id: taskID}),
                });
            } else {
                await fetch(`${BASE_URL}/${taskID}`, {
                    method: 'DELETE',
                });
            }
            await loadTasks();
        });

        liTaskElement.appendChild(buttonElement);

        return liTaskElement;
    }

    function clearInputs() {
        titleElement.value = '';
        descriptionElement.value = '';
    }
}

attachEvents();