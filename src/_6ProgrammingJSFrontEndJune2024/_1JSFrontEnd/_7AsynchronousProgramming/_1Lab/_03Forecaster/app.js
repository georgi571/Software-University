function attachEvents() {
    const baseURL = 'http://localhost:3030/jsonstore/forecaster/';
    const wantedLocation = document.getElementById('location');
    const submitButton = document.getElementById('submit');
    const forecastDiv = document.getElementById('forecast');
    const currentWeatherConditions = document.getElementById('current');
    const upcomingWeatherConditions = document.getElementById('upcoming');
    let currentToRemove = '';
    let upcomingToRemove = '';

    const weatherSymbols = {
        'Sunny': '&#x2600',
        'Partly sunny': '&#x26C5',
        'Overcast': '&#x2601',
        'Rain': '&#x2614',
        'Degrees': '&#176'
    };

    submitButton.addEventListener('click', getWeatherEvent);

    async function getWeatherEvent() {
        forecastDiv.style.display = 'block';
        try {
            const locations = await fetchLocations();
            const location = findLocation(locations, wantedLocation.value);
            if (!location) {
                throw new Error('Location not found');
            }
            const todayData = await fetchWeatherData('today', location.code);
            const upcomingData = await fetchWeatherData('upcoming', location.code);
            displayCurrentWeather(todayData);
            displayUpcomingWeather(upcomingData);
        } catch (error) {
            displayError();
        }
    }

    async function fetchLocations() {
        const response = await fetch(baseURL + 'locations');
        if (!response.ok) {
            throw new Error(`Error: ${response.status} ${response.statusText}`);
        }
        return response.json();
    }

    function findLocation(locations, inputLocation) {
        return locations.find(loc => loc.name === inputLocation);
    }

    async function fetchWeatherData(type, locationCode) {
        const response = await fetch(baseURL + `${type}/${locationCode}`);
        if (!response.ok) {
            throw new Error(`Error: ${response.status} ${response.statusText}`);
        }
        return response.json();
    }

    function displayCurrentWeather(data) {
        const { name, forecast: { low, high, condition } } = data;
        const divElement = createWeatherElement('div', 'forecasts', `
            <span class="condition symbol">${weatherSymbols[condition]}</span>
            <span class="condition">
                <span class="forecast-data">${name}</span>
                <span class="forecast-data">${low}${weatherSymbols['Degrees']}/${high}${weatherSymbols['Degrees']}</span>
                <span class="forecast-data">${condition}</span>
            </span>
        `);
        if (currentToRemove !== '') {
            currentWeatherConditions.removeChild(currentToRemove);
        }
        currentToRemove = divElement;
        currentWeatherConditions.appendChild(divElement);
    }

    function displayUpcomingWeather(data) {
        let divElement = createWeatherElement('div', 'forecast-info', '');
        data.forecast.forEach(dayForecast => {
            const newSpan = createWeatherElement('span', 'upcoming', `
                <span class="symbol">${weatherSymbols[dayForecast.condition]}</span>
                <span class="forecast-data">${dayForecast.low}${weatherSymbols['Degrees']}/${dayForecast.high}${weatherSymbols['Degrees']}</span>
                <span class="forecast-data">${dayForecast.condition}</span>
            `);
            divElement.appendChild(newSpan);
        });
        if (upcomingToRemove !== '') {
            upcomingWeatherConditions.removeChild(upcomingToRemove);
        }
        upcomingToRemove = divElement;
        upcomingWeatherConditions.appendChild(divElement);
    }

    function createWeatherElement(elementType, className, innerHTML) {
        const element = document.createElement(elementType);
        element.className = className;
        element.innerHTML = innerHTML;
        return element;
    }

    function displayError() {
        forecastDiv.style.display = 'block';
        forecastDiv.textContent = 'Error';
    }
}

attachEvents();
