function attachEvents() {
    const BASE_URL = 'http://localhost:3030/jsonstore/gifts';

    const giftElement = document.querySelector('#gift');
    const forElement = document.querySelector('#for');
    const priceElement = document.querySelector('#price');

    const loadGiftButtonElements = document.querySelector('#load-presents');
    const addGiftButtonElements = document.querySelector('#add-present');
    const editGiftButtonElements = document.querySelector('#edit-present');
    const divGiftListElements = document.querySelector('#gift-list')
    const formElements = document.querySelector('#form form')

    loadGiftButtonElements.addEventListener('click', loadGifts);
    addGiftButtonElements.addEventListener('click', addGifts);
    editGiftButtonElements.addEventListener('click', editGifts);

    async function loadGifts() {
        divGiftListElements.innerHTML = '';
        const response = await fetch(BASE_URL);
        const result = await response.json();
        const gifts = Object.values(result);
        const giftElements = gifts.map(gift => createGiftElement(gift.gift, gift.for, gift.price, gift._id));
        divGiftListElements.append(...giftElements);
    }

    async function addGifts() {
        const gift = giftElement.value;
        const forEl = forElement.value;
        const price = priceElement.value;

        clearInputs();

        await fetch(BASE_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({gift: gift, for: forEl, price: price}),
        });

        await loadGifts();
    }

    async function editGifts() {
        const giftID = formElements.getAttribute('data-gift-id')
        const gift = giftElement.value;
        const forEl = forElement.value;
        const price = priceElement.value;

        clearInputs();

        await fetch(`${BASE_URL}/${giftID}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({gift: gift, for: forEl, price: price, _id: giftID}),
        });

        await loadGifts();

        editGiftButtonElements.disabled = true;
        addGiftButtonElements.disabled = false;

        formElements.removeAttribute('data-gift-id');
    }

    function createGiftElement(gift, forEl, price, giftID) {
        const divGiftSocks = document.createElement('div');
        divGiftSocks.setAttribute('class', 'gift-sock');

        const divContentElement = document.createElement('div');
        divContentElement.setAttribute('class', 'content');

        const pGiftElement = document.createElement('p');
        pGiftElement.textContent = gift;
        const pForElement = document.createElement('p');
        pForElement.textContent = forEl;
        const pPriceElement = document.createElement('p');
        pPriceElement.textContent = price;

        divContentElement.appendChild(pGiftElement);
        divContentElement.appendChild(pForElement);
        divContentElement.appendChild(pPriceElement);

        const divButtonsElement = document.createElement('div');
        divButtonsElement.setAttribute('class', 'buttons-container');

        const buttonChangeElement = document.createElement('button');
        buttonChangeElement.setAttribute('class', 'change-btn');
        buttonChangeElement.textContent = 'Change';

        buttonChangeElement.addEventListener('click', () => {
            giftElement.value = gift;
            forElement.value = forEl;
            priceElement.value = price;
            editGiftButtonElements.disabled = false;
            addGiftButtonElements.disabled = true;
            formElements.setAttribute('data-gift-id', giftID);
        })

        const buttonDeleteElement = document.createElement('button');
        buttonDeleteElement.setAttribute('class', 'delete-btn');
        buttonDeleteElement.textContent = 'Delete';

        buttonDeleteElement.addEventListener('click', async () => {
            await fetch(`${BASE_URL}/${giftID}`, {
                method: 'DELETE',
            });

            await loadGifts();
        })

        divButtonsElement.appendChild(buttonChangeElement);
        divButtonsElement.appendChild(buttonDeleteElement);

        divGiftSocks.appendChild(divContentElement);
        divGiftSocks.appendChild(divButtonsElement);

        return divGiftSocks;
    }

    function clearInputs() {
        giftElement.value = '';
        forElement.value = '';
        priceElement.value = '';
    }
}

attachEvents();