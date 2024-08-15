function attachEvents() {
    const BASE_URL = 'http://localhost:3030/jsonstore/tasks';

    const locationElement = document.querySelector('#location');
    const temperatureElement = document.querySelector('#temperature');
    const dateElement = document.querySelector('#date');

    const loadWeatherButtonElements = document.querySelector('#load-history');
    const addWeatherButtonElements = document.querySelector('#add-weather');
    const editWeatherButtonElements = document.querySelector('#edit-weather');
    const divWeatherListElements = document.querySelector('#list')
    const formElements = document.querySelector('#form form')

    loadWeatherButtonElements.addEventListener('click', loadWeather);
    addWeatherButtonElements.addEventListener('click', addWeather);
    editWeatherButtonElements.addEventListener('click', editWeather);

    async function loadWeather() {
        divWeatherListElements.innerHTML = '';
        const response = await fetch(BASE_URL);
        const result = await response.json();
        const weathers = Object.values(result);
        const weathersElements = weathers.map(weather => createGiftElement(weather.location, weather.temperature, weather.date, weather._id));
        divWeatherListElements.append(...weathersElements);
    }

    async function addWeather() {
        const location = locationElement.value;
        const temperature = temperatureElement.value;
        const date = dateElement.value;

        clearInputs();

        await fetch(BASE_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({location: location, temperature: temperature, date: date}),
        });

        await loadWeather();
    }

    async function editWeather() {
        const weatherID = formElements.getAttribute('data-weather-id');
        const location = locationElement.value;
        const temperature = temperatureElement.value;
        const date = dateElement.value;

        clearInputs();

        await fetch(`${BASE_URL}/${weatherID}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({location: location, temperature: temperature, date: date, _id: weatherID}),
        });

        await loadWeather();

        editWeatherButtonElements.disabled = true;
        addWeatherButtonElements.disabled = false;

        formElements.removeAttribute('data-weather-id');
    }

    function createGiftElement(location, temperature, date, weatherID) {
        const divWeatherElement = document.createElement('div');
        divWeatherElement.setAttribute('class', 'container');

        const h2LocationElement = document.createElement('h2');
        h2LocationElement.textContent = location;
        const h3TemperatureElement = document.createElement('h3');
        h3TemperatureElement.setAttribute('class', 'celsius');
        h3TemperatureElement.textContent = temperature;
        const h3DateElement = document.createElement('h3');
        h3DateElement.textContent = date;

        divWeatherElement.appendChild(h2LocationElement);
        divWeatherElement.appendChild(h3DateElement);
        divWeatherElement.appendChild(h3TemperatureElement);

        const divButtonsElement = document.createElement('div');
        divButtonsElement.setAttribute('class', 'buttons-container');

        const buttonChangeElement = document.createElement('button');
        buttonChangeElement.setAttribute('class', 'change-btn');
        buttonChangeElement.textContent = 'Change';

        buttonChangeElement.addEventListener('click', () => {
            locationElement.value = location;
            temperatureElement.value = temperature;
            dateElement.value = date;
            editWeatherButtonElements.disabled = false;
            addWeatherButtonElements.disabled = true;
            formElements.setAttribute('data-weather-id', weatherID);
        })

        const buttonDeleteElement = document.createElement('button');
        buttonDeleteElement.setAttribute('class', 'delete-btn');
        buttonDeleteElement.textContent = 'Delete';

        buttonDeleteElement.addEventListener('click', async () => {
            await fetch(`${BASE_URL}/${weatherID}`, {
                method: 'DELETE',
            });

            await loadWeather();
        })

        divButtonsElement.appendChild(buttonChangeElement);
        divButtonsElement.appendChild(buttonDeleteElement);

        divWeatherElement.appendChild(divButtonsElement);

        return divWeatherElement;
    }

    function clearInputs() {
        locationElement.value = '';
        temperatureElement.value = '';
        dateElement.value = '';
    }
}

attachEvents();