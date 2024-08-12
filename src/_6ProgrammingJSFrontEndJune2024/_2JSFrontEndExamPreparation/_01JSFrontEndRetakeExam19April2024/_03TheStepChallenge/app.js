function attachEvents() {
    const BASE_URL = 'http://localhost:3030/jsonstore/records';

    const nameElement = document.querySelector('#p-name');
    const stepsElement = document.querySelector('#steps');
    const caloriesElement = document.querySelector('#calories');

    const loadRecordsButtonElements = document.querySelector('#load-records');
    const addRecordsButtonElements = document.querySelector('#add-record');
    const editRecordsButtonElements = document.querySelector('#edit-record');
    const listElements = document.querySelector('#list')
    const formElements = document.querySelector('#form form')

    loadRecordsButtonElements.addEventListener('click', loadRecords);
    addRecordsButtonElements.addEventListener('click', addRecords);
    editRecordsButtonElements.addEventListener('click', editRecords);

    async function loadRecords() {
        listElements.innerHTML = '';
        const response = await fetch(BASE_URL);
        const result = await response.json();
        const records = Object.values(result);
        const recordElements = records.map(record => createRecordElement(record.name, record.steps, record.calories, record._id));
        listElements.append(...recordElements);
    }

    async function addRecords() {
        const name = nameElement.value;
        const steps = stepsElement.value;
        const calories = caloriesElement.value;

        clearInputs();

        await fetch(BASE_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({name, steps, calories}),
        });

        await loadRecords();
    }

    async function editRecords() {
        const recordID = formElements.getAttribute('data-record-id')
        const name = nameElement.value;
        const steps = stepsElement.value;
        const calories = caloriesElement.value;

        clearInputs();

        await fetch(`${BASE_URL}/${recordID}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({name, steps, calories, _id: recordID}),
        });

        await loadRecords();

        editRecordsButtonElements.disabled = true;
        addRecordsButtonElements.disabled = false;

        formElements.removeAttribute('data-record-id');
    }

    function createRecordElement(name, steps, calories, recordID) {
        const liElement = document.createElement('li');
        liElement.setAttribute('class', 'record');

        const divInfoElement = document.createElement('div');
        divInfoElement.setAttribute('class', 'info');
        const pNameElement = document.createElement('p');
        pNameElement.textContent = name;
        const pStepsElement = document.createElement('p');
        pStepsElement.textContent = steps;
        const pCaloriesElement = document.createElement('p');
        pCaloriesElement.textContent = calories;
        divInfoElement.appendChild(pNameElement);
        divInfoElement.appendChild(pStepsElement);
        divInfoElement.appendChild(pCaloriesElement);

        const divWrapperElement = document.createElement('div');
        divWrapperElement.setAttribute('class', 'btn-wrapper');
        const buttonChangeElement = document.createElement('button');
        buttonChangeElement.setAttribute('class', 'change-btn');
        buttonChangeElement.textContent = 'Change';

        buttonChangeElement.addEventListener('click', () => {
            nameElement.value = name;
            stepsElement.value = steps;
            caloriesElement.value = calories;
            editRecordsButtonElements.disabled = false;
            addRecordsButtonElements.disabled = true;
            formElements.setAttribute('data-record-id', recordID);
        })
        const buttonDeleteElement = document.createElement('button');
        buttonDeleteElement.setAttribute('class', 'delete-btn');
        buttonDeleteElement.textContent = 'Delete';

        buttonDeleteElement.addEventListener('click', async () => {
            await fetch(`${BASE_URL}/${recordID}`, {
                method: 'DELETE',
            });

            await loadRecords();
        })

        divWrapperElement.appendChild(buttonChangeElement);
        divWrapperElement.appendChild(buttonDeleteElement);

        liElement.appendChild(divInfoElement);
        liElement.appendChild(divWrapperElement);

        return liElement;
    }

    function clearInputs() {
        nameElement.value = '';
        stepsElement.value = '';
        caloriesElement.value = '';
    }
}

attachEvents();