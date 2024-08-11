window.addEventListener("load", solve);

function solve() {
    const firstNameElement = document.querySelector('#first-name');
    const lastNameElement = document.querySelector('#last-name');
    const ageElement = document.querySelector('#age');
    const storyTitleElement = document.querySelector('#story-title');
    const genreElement = document.querySelector('#genre');
    const storyElement = document.querySelector('#story');
    const publishButtonElement = document.querySelector('#form-btn');
    const previewListElement = document.querySelector('#preview-list');
    const divMainElement = document.querySelector('#main');

    publishButtonElement.addEventListener('click', (event) => {
        event.preventDefault();
        if (firstNameElement.value !== '' && lastNameElement.value !== ''
            && ageElement.value !== '' && storyTitleElement.value !== ''
            && genreElement.value !== '' && storyElement.value !== '') {
            const liElement = document.createElement('li');
            liElement.setAttribute('class', 'story-info')
            const articleElement = document.createElement('article');
            const h4Element = document.createElement('h4');
            h4Element.textContent = `Name: ${firstNameElement.value} ${lastNameElement.value}`;
            const pAgeElement = document.createElement('p');
            pAgeElement.textContent = `Age: ${ageElement.value}`;
            const pTitleElement = document.createElement('p');
            pTitleElement.textContent = `Title: ${storyTitleElement.value}`;
            const pGenreElement = document.createElement('p');
            pGenreElement.textContent = `Genre: ${genreElement.value}`;
            const pStoryElement = document.createElement('p');
            pStoryElement.textContent = `${storyElement.value}`;
            const saveButton = document.createElement('button');
            saveButton.setAttribute('class', 'save-btn');
            saveButton.textContent = 'Save Story';
            const editButton = document.createElement('button');
            editButton.setAttribute('class', 'edit-btn');
            editButton.textContent = 'Edit Story';
            const deleteButton = document.createElement('button');
            deleteButton.setAttribute('class', 'delete-btn');
            deleteButton.textContent = 'Delete Story';
            articleElement.appendChild(h4Element);
            articleElement.appendChild(pAgeElement);
            articleElement.appendChild(pTitleElement);
            articleElement.appendChild(pGenreElement);
            articleElement.appendChild(pStoryElement);
            liElement.appendChild(articleElement);
            liElement.appendChild(saveButton);
            liElement.appendChild(editButton);
            liElement.appendChild(deleteButton);
            previewListElement.appendChild(liElement);
            firstNameElement.value = '';
            lastNameElement.value = '';
            ageElement.value = '';
            storyTitleElement.value = '';
            genreElement.value = '';
            storyElement.value = '';
            publishButtonElement.disabled = true;

            saveButton.addEventListener('click', (event) => {
                while (divMainElement.firstChild) {
                    divMainElement.removeChild(divMainElement.firstChild);
                }
                const h1Element = document.createElement('h1');
                h1Element.textContent = `Your scary story is saved!`;
                divMainElement.appendChild(h1Element);
            })

            editButton.addEventListener('click', (event) => {
                firstNameElement.value = h4Element.textContent.replace('Name: ', '').split(' ')[0];
                lastNameElement.value = h4Element.textContent.replace('Name: ', '').split(' ')[1];
                ageElement.value = pAgeElement.textContent.replace('Age: ', '');
                storyTitleElement.value = pTitleElement.textContent.replace('Title: ', '');
                genreElement.value = pGenreElement.textContent.replace('Genre: ', '');
                storyElement.value = pStoryElement.textContent;
                previewListElement.removeChild(liElement);
                publishButtonElement.disabled = false;
            })

            deleteButton.addEventListener('click', (event) => {
                previewListElement.removeChild(liElement);
                publishButtonElement.disabled = false;
            })
        }
    })
}
