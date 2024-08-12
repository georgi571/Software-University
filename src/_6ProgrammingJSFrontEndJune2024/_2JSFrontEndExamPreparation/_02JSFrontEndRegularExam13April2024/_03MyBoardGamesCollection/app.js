function attachEvents() {
    const BASE_URL = 'http://localhost:3030/jsonstore/games';

    const nameElement = document.querySelector('#g-name');
    const typeElement = document.querySelector('#type');
    const playersElement = document.querySelector('#players');

    const loadGamesButtonElements = document.querySelector('#load-games');
    const addGamesButtonElements = document.querySelector('#add-game');
    const editGamesButtonElements = document.querySelector('#edit-game');
    const divGameListElements = document.querySelector('#games-list')
    const formElements = document.querySelector('#form form')

    loadGamesButtonElements.addEventListener('click', loadGames);
    addGamesButtonElements.addEventListener('click', addGames);
    editGamesButtonElements.addEventListener('click', editGames);

    async function loadGames() {
        divGameListElements.innerHTML = '';
        const response = await fetch(BASE_URL);
        const result = await response.json();
        const games = Object.values(result);
        const gamesElements = games.map(game => createRecordElement(game.name, game.type, game.players, game._id));
        divGameListElements.append(...gamesElements);
    }

    async function addGames() {
        const name = nameElement.value;
        const type = typeElement.value;
        const players = playersElement.value;

        clearInputs();

        await fetch(BASE_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({name, type, players}),
        });

        await loadGames();
    }

    async function editGames() {
        const gameID = formElements.getAttribute('data-game-id')
        const name = nameElement.value;
        const type = typeElement.value;
        const players = playersElement.value;

        clearInputs();

        await fetch(`${BASE_URL}/${gameID}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({name, type, players, _id: gameID}),
        });

        await loadGames();

        editGamesButtonElements.disabled = true;
        addGamesButtonElements.disabled = false;

        formElements.removeAttribute('data-game-id');
    }

    function createRecordElement(name, type, players, gameID) {
        const divBoardGame = document.createElement('div');
        divBoardGame.setAttribute('class', 'board-game');

        const divContentElement = document.createElement('div');
        divContentElement.setAttribute('class', 'content');

        const pNameElement = document.createElement('p');
        pNameElement.textContent = name;
        const pTypeElement = document.createElement('p');
        pTypeElement.textContent = type;
        const pPlayersElement = document.createElement('p');
        pPlayersElement.textContent = players;

        divContentElement.appendChild(pNameElement);
        divContentElement.appendChild(pTypeElement);
        divContentElement.appendChild(pPlayersElement);

        const divButtonsElement = document.createElement('div');
        divButtonsElement.setAttribute('class', 'buttons-container');

        const buttonChangeElement = document.createElement('button');
        buttonChangeElement.setAttribute('class', 'change-btn');
        buttonChangeElement.textContent = 'Change';

        buttonChangeElement.addEventListener('click', () => {
            nameElement.value = name;
            typeElement.value = type;
            playersElement.value = players;
            editGamesButtonElements.disabled = false;
            addGamesButtonElements.disabled = true;
            formElements.setAttribute('data-game-id', gameID);
        })

        const buttonDeleteElement = document.createElement('button');
        buttonDeleteElement.setAttribute('class', 'delete-btn');
        buttonDeleteElement.textContent = 'Delete';

        buttonDeleteElement.addEventListener('click', async () => {
            await fetch(`${BASE_URL}/${gameID}`, {
                method: 'DELETE',
            });

            await loadGames();
        })

        divButtonsElement.appendChild(buttonChangeElement);
        divButtonsElement.appendChild(buttonDeleteElement);

        divBoardGame.appendChild(divContentElement);
        divBoardGame.appendChild(divButtonsElement);

        return divBoardGame;
    }

    function clearInputs() {
        nameElement.value = '';
        typeElement.value = '';
        playersElement.value = '';
    }
}

attachEvents();