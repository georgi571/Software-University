function attachEvents() {
    const BASE_URL = 'http://localhost:3030/jsonstore/matches';

    const teamHostElement = document.querySelector('#host');
    const finalScoreElement = document.querySelector('#score');
    const teamGuestElement = document.querySelector('#guest');

    const loadMatchesButtonElements = document.querySelector('#load-matches');
    const addMatchButtonElements = document.querySelector('#add-match');
    const editMatchButtonElements = document.querySelector('#edit-match');
    const listElements = document.querySelector('#list');
    const formElements = document.querySelector('#form form')

    loadMatchesButtonElements.addEventListener('click', loadMatches);
    addMatchButtonElements.addEventListener('click', addMatches);
    editMatchButtonElements.addEventListener('click', editMatches);

    async function loadMatches() {
        listElements.innerHTML = '';
        const response = await fetch(BASE_URL);
        const result = await response.json();
        const matches = Object.values(result);
        const matchesElements = matches.map(match => createRecordElement(match.host, match.score, match.guest, match._id));
        listElements.append(...matchesElements);
    }

    async function addMatches() {
        const teamHost = teamHostElement.value;
        const finalScore = finalScoreElement.value;
        const teamGuest = teamGuestElement.value;

        clearInputs();

        await fetch(BASE_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({host: teamHost, score: finalScore, guest: teamGuest}),
        });

        await loadMatches();
    }

    async function editMatches() {
        const matchID = formElements.getAttribute('data-match-id')
        const teamHost = teamHostElement.value;
        const finalScore = finalScoreElement.value;
        const teamGuest = teamGuestElement.value;

        clearInputs();

        await fetch(`${BASE_URL}/${matchID}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({host: teamHost, score: finalScore, guest: teamGuest, _id: matchID}),
        });

        await loadMatches();

        editMatchButtonElements.disabled = true;
        addMatchButtonElements.disabled = false;

        formElements.removeAttribute('data-match-id');
    }

    function createRecordElement(host, score, guest, matchID) {
        const liElement = document.createElement('li');
        liElement.setAttribute('class', 'match');

        const divInfoElement = document.createElement('div');
        divInfoElement.setAttribute('class', 'info');
        const pHostName = document.createElement('p');
        pHostName.textContent = host;
        const pFinalScore = document.createElement('p');
        pFinalScore.textContent = score;
        const pGuestName = document.createElement('p');
        pGuestName.textContent = guest;
        divInfoElement.appendChild(pHostName);
        divInfoElement.appendChild(pFinalScore);
        divInfoElement.appendChild(pGuestName);

        const divWrapperElement = document.createElement('div');
        divWrapperElement.setAttribute('class', 'btn-wrapper');
        const buttonChangeElement = document.createElement('button');
        buttonChangeElement.setAttribute('class', 'change-btn');
        buttonChangeElement.textContent = 'Change';

        buttonChangeElement.addEventListener('click', () => {
            teamHostElement.value = host;
            finalScoreElement.value = score;
            teamGuestElement.value = guest;
            editMatchButtonElements.disabled = false;
            addMatchButtonElements.disabled = true;
            formElements.setAttribute('data-match-id', matchID);
        })
        const buttonDeleteElement = document.createElement('button');
        buttonDeleteElement.setAttribute('class', 'delete-btn');
        buttonDeleteElement.textContent = 'Delete';

        buttonDeleteElement.addEventListener('click', async () => {
            await fetch(`${BASE_URL}/${matchID}`, {
                method: 'DELETE',
            });

            await loadMatches();
        })

        divWrapperElement.appendChild(buttonChangeElement);
        divWrapperElement.appendChild(buttonDeleteElement);

        liElement.appendChild(divInfoElement);
        liElement.appendChild(divWrapperElement);

        return liElement;
    }

    function clearInputs() {
        teamHostElement.value = '';
        finalScoreElement.value = '';
        teamGuestElement.value = '';
    }
}

attachEvents();