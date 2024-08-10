window.addEventListener("load", solve);

function solve() {
    const typeElement = document.querySelector('#type');
    const ageElement = document.querySelector('#age');
    const genderElement = document.querySelector('#gender');
    const buttonElement = document.querySelector('#adopt-btn');
    const checkInfoElement = document.querySelector('#adoption-info')
    const adoptedPetsElement = document.querySelector('#adopted-list')
    buttonElement.addEventListener('click', (event) => {
        event.preventDefault();
        if (typeElement.value !== '' && ageElement.value !== '' && genderElement.value !== '') {
            const liElement = document.createElement('li');
            const articleElement = document.createElement('article');
            const p1Element = document.createElement('p');
            p1Element.textContent = `Pet:${typeElement.value}`;
            const p2Element = document.createElement('p');
            p2Element.textContent = `Gender:${genderElement.value}`;
            const p3Element = document.createElement('p');
            p3Element.textContent = `Age:${ageElement.value}`;
            const divElement = document.createElement('div');
            const editElement = document.createElement('button');
            editElement.textContent = 'Edit';
            const doneElement = document.createElement('button');
            doneElement.textContent = 'Done';
            articleElement.appendChild(p1Element);
            articleElement.appendChild(p2Element);
            articleElement.appendChild(p3Element);
            divElement.setAttribute('class', 'buttons');
            editElement.setAttribute('class', 'edit-btn');
            doneElement.setAttribute('class', 'done-btn');
            divElement.appendChild(editElement);
            divElement.appendChild(doneElement);
            liElement.appendChild(articleElement);
            liElement.appendChild(divElement);
            checkInfoElement.appendChild(liElement);
            typeElement.value = '';
            ageElement.value = '';
            genderElement.value = '';
            editElement.addEventListener('click', () => {
                typeElement.value = p1Element.textContent.replace('Pet:', '');
                genderElement.value = p2Element.textContent.replace('Gender:', '');
                ageElement.value = p3Element.textContent.replace('Age:', '');
                checkInfoElement.removeChild(liElement);
            });
            doneElement.addEventListener('click', () => {
                divElement.remove();
                const clearElement = document.createElement('button');
                clearElement.textContent = 'Clear';
                clearElement.setAttribute('class', 'clear-btn');
                liElement.appendChild(clearElement);
                adoptedPetsElement.appendChild(liElement);
                clearElement.addEventListener('click', () => {
                    adoptedPetsElement.removeChild(liElement);
                });
            });
        }
    })
}
  