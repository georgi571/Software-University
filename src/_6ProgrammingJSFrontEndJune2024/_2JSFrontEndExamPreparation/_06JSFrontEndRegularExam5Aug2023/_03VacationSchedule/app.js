function attachEvents() {
    const BASE_URL = 'http://localhost:3030/jsonstore/tasks';

    const nameElement = document.querySelector('#name');
    const numberOfDaysElement = document.querySelector('#num-days');
    const startFromDateElement = document.querySelector('#from-date');

    const loadVacationsButtonElements = document.querySelector('#load-vacations');
    const addVacationButtonElements = document.querySelector('#add-vacation');
    const editVacationButtonElements = document.querySelector('#edit-vacation');
    const divVacationListElements = document.querySelector('#list')
    const formElements = document.querySelector('#form form')

    loadVacationsButtonElements.addEventListener('click', loadVacation);
    addVacationButtonElements.addEventListener('click', addVacation);
    editVacationButtonElements.addEventListener('click', editVacation);

    async function loadVacation() {
        divVacationListElements.innerHTML = '';
        const response = await fetch(BASE_URL);
        const result = await response.json();
        const vacations = Object.values(result);
        const vacationElements = vacations.map(vacation => createVacationElement(vacation.name, vacation.days, vacation.date, vacation._id));
        divVacationListElements.append(...vacationElements);
    }

    async function addVacation() {
        const name = nameElement.value;
        const numberOfDays = numberOfDaysElement.value;
        const startFromDate = startFromDateElement.value;

        clearInputs();

        await fetch(BASE_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({name: name, days: numberOfDays, date: startFromDate}),
        });

        await loadVacation();
    }

    async function editVacation() {
        const vacationID = formElements.getAttribute('data-vacation-id');
        const name = nameElement.value;
        const numberOfDays = numberOfDaysElement.value;
        const startFromDate = startFromDateElement.value;

        clearInputs();

        await fetch(`${BASE_URL}/${vacationID}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({name: name, days: numberOfDays, date: startFromDate, _id: vacationID}),
        });

        await loadVacation();

        editVacationButtonElements.disabled = true;
        addVacationButtonElements.disabled = false;

        formElements.removeAttribute('data-vacation-id');
    }

    function createVacationElement(name, numberOfDays, startFromDate, weatherID) {
        const divVacationElement = document.createElement('div');
        divVacationElement.setAttribute('class', 'container');

        const h2NameElement = document.createElement('h2');
        h2NameElement.textContent = name;
        const h3NumberOfDaysElement = document.createElement('h3');
        h3NumberOfDaysElement.textContent = numberOfDays;
        const h3StartFromDateElement = document.createElement('h3');
        h3StartFromDateElement.textContent = startFromDate;

        divVacationElement.appendChild(h2NameElement);
        divVacationElement.appendChild(h3StartFromDateElement);
        divVacationElement.appendChild(h3NumberOfDaysElement);

        const buttonChangeElement = document.createElement('button');
        buttonChangeElement.setAttribute('class', 'change-btn');
        buttonChangeElement.textContent = 'Change';

        buttonChangeElement.addEventListener('click', () => {
            nameElement.value = name;
            numberOfDaysElement.value = numberOfDays;
            startFromDateElement.value = startFromDate;
            editVacationButtonElements.disabled = false;
            addVacationButtonElements.disabled = true;
            formElements.setAttribute('data-vacation-id', weatherID);
        })

        const buttonDoneElement = document.createElement('button');
        buttonDoneElement.setAttribute('class', 'done-btn');
        buttonDoneElement.textContent = 'Done';

        buttonDoneElement.addEventListener('click', async () => {
            await fetch(`${BASE_URL}/${weatherID}`, {
                method: 'DELETE',
            });

            await loadVacation();
        })


        divVacationElement.appendChild(buttonChangeElement);
        divVacationElement.appendChild(buttonDoneElement);

        return divVacationElement;
    }

    function clearInputs() {
        nameElement.value = '';
        numberOfDaysElement.value = '';
        startFromDateElement.value = '';
    }
}

attachEvents();