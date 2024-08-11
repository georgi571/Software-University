window.addEventListener('load', solve);

function solve() {
    const genreElement = document.querySelector('#genre');
    const nameElement = document.querySelector('#name');
    const authorElement = document.querySelector('#author');
    const dateElement = document.querySelector('#date');
    const addButtonElement = document.querySelector('#add-btn');
    const collectionOfSongsElement = document.querySelector('.all-hits-container');
    const savedSongsElement = document.querySelector('.saved-container');
    const likesElement = document.querySelector('.likes>p');

    addButtonElement.addEventListener('click', (event) => {
        event.preventDefault();
        if (genreElement.value !== '' && nameElement.value !== '' && authorElement.value !== '' && dateElement.value !== '') {
            const divElement = document.createElement('div');
            divElement.setAttribute('class', 'hits-info');
            const imgElement = document.createElement('img');
            imgElement.setAttribute('src', './static/img/img.png');
            const h2GenreElement = document.createElement('h2');
            h2GenreElement.textContent = `Genre: ${genreElement.value}`;
            const h2NameElement = document.createElement('h2');
            h2NameElement.textContent = `Name: ${nameElement.value}`;
            const h2AuthorElement = document.createElement('h2');
            h2AuthorElement.textContent = `Author: ${authorElement.value}`;
            const h3DateElement = document.createElement('h3');
            h3DateElement.textContent = `Date: ${dateElement.value}`;
            const saveButton = document.createElement('button');
            saveButton.setAttribute('class', 'save-btn');
            saveButton.textContent = 'Save song';
            const likeButton = document.createElement('button');
            likeButton.setAttribute('class', 'like-btn');
            likeButton.textContent = 'Like song';
            const deleteButton = document.createElement('button');
            deleteButton.setAttribute('class', 'delete-btn');
            deleteButton.textContent = 'Delete';
            divElement.appendChild(imgElement);
            divElement.appendChild(h2GenreElement);
            divElement.appendChild(h2NameElement);
            divElement.appendChild(h2AuthorElement);
            divElement.appendChild(h3DateElement);
            divElement.appendChild(saveButton);
            divElement.appendChild(likeButton);
            divElement.appendChild(deleteButton);
            collectionOfSongsElement.appendChild(divElement);
            genreElement.value = '';
            nameElement.value = '';
            authorElement.value = '';
            dateElement.value = '';

            saveButton.addEventListener('click', (event) => {
                divElement.removeChild(saveButton);
                divElement.removeChild(likeButton);
                savedSongsElement.appendChild(divElement);
            })

            likeButton.addEventListener('click', (event) => {
                const numberOfLikes = Number(likesElement.textContent.replace('Total Likes: ', '')) + 1;
                likesElement.textContent = `Total Likes: ${numberOfLikes}`;
                likeButton.disabled = true;
            })

            deleteButton.addEventListener('click', (event) => {
                if (collectionOfSongsElement.contains(divElement)) {
                    collectionOfSongsElement.removeChild(divElement);
                } else if (savedSongsElement.contains(divElement)) {
                    savedSongsElement.removeChild(divElement);
                }
            })
        }
    })
}