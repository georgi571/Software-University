function attachEvents() {
    const BASE_URL = 'http://localhost:3030/jsonstore/tasks';

    const foodElement = document.querySelector('#food');
    const timeElement = document.querySelector('#time');
    const caloriesElement = document.querySelector('#calories');

    const loadMealsButtonElements = document.querySelector('#load-meals');
    const addMealButtonElements = document.querySelector('#add-meal');
    const editMealButtonElements = document.querySelector('#edit-meal');
    const divMealListElements = document.querySelector('#list')
    const formElements = document.querySelector('#form form')

    loadMealsButtonElements.addEventListener('click', loadMeals);
    addMealButtonElements.addEventListener('click', addMeals);
    editMealButtonElements.addEventListener('click', editMeal);

    async function loadMeals() {
        divMealListElements.innerHTML = '';
        const response = await fetch(BASE_URL);
        const result = await response.json();
        const meals = Object.values(result);
        const mealsElements = meals.map(meal => createGiftElement(meal.food, meal.calories, meal.time, meal._id));
        divMealListElements.append(...mealsElements);
    }

    async function addMeals() {
        const food = foodElement.value;
        const time = timeElement.value;
        const calories = caloriesElement.value;

        clearInputs();

        await fetch(BASE_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({food: food, time: time, calories: calories}),
        });

        await loadMeals();
    }

    async function editMeal() {
        const mealID = formElements.getAttribute('data-meal-id')
        const food = foodElement.value;
        const time = timeElement.value;
        const calories = caloriesElement.value;

        clearInputs();

        await fetch(`${BASE_URL}/${mealID}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({food: food, calories: calories, time: time, _id: mealID}),
        });

        await loadMeals();

        editMealButtonElements.disabled = true;
        addMealButtonElements.disabled = false;

        formElements.removeAttribute('data-meal-id');
    }

    function createGiftElement(food, calories, time, mealID) {
        const divMealElement = document.createElement('div');
        divMealElement.setAttribute('class', 'meal');

        const h2FoodElement = document.createElement('h2');
        h2FoodElement.textContent = food;
        const h3TimeElement = document.createElement('h3');
        h3TimeElement.textContent = time;
        const h3CaloriesElement = document.createElement('h3');
        h3CaloriesElement.textContent = calories;

        divMealElement.appendChild(h2FoodElement);
        divMealElement.appendChild(h3TimeElement);
        divMealElement.appendChild(h3CaloriesElement);

        const divMealButtonsElement = document.createElement('div');
        divMealButtonsElement.setAttribute('class', 'meal-buttons');

        const buttonChangeElement = document.createElement('button');
        buttonChangeElement.setAttribute('class', 'change-meal');
        buttonChangeElement.textContent = 'Change';

        buttonChangeElement.addEventListener('click', () => {
            foodElement.value = food;
            timeElement.value = time;
            caloriesElement.value = calories;
            editMealButtonElements.disabled = false;
            addMealButtonElements.disabled = true;
            formElements.setAttribute('data-meal-id', mealID);
        })

        const buttonDeleteElement = document.createElement('button');
        buttonDeleteElement.setAttribute('class', 'delete-meal');
        buttonDeleteElement.textContent = 'Delete';

        buttonDeleteElement.addEventListener('click', async () => {
            await fetch(`${BASE_URL}/${mealID}`, {
                method: 'DELETE',
            });

            await loadMeals();
        })

        divMealButtonsElement.appendChild(buttonChangeElement);
        divMealButtonsElement.appendChild(buttonDeleteElement);

        divMealElement.appendChild(divMealButtonsElement);

        return divMealElement;
    }

    function clearInputs() {
        foodElement.value = '';
        timeElement.value = '';
        caloriesElement.value = '';
    }
}

attachEvents();