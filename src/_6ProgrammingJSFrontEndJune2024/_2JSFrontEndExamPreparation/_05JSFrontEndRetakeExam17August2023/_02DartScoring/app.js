window.addEventListener("load", solve);

function solve() {
    const playerElement = document.querySelector('#player');
    const scoreElement = document.querySelector('#score');
    const roundElement = document.querySelector('#round');
    const buttonElement = document.querySelector('#add-btn');
    const sureListElement = document.querySelector('#sure-list');
    const scoreboardListElement = document.querySelector('#scoreboard-list');
    const clearButtonElement = document.querySelector('.clear');
    buttonElement.addEventListener('click', (event) => {
        event.preventDefault();
        if (playerElement.value !== '' && scoreElement.value !== '' && roundElement.value !== '') {
            const liElement = document.createElement('li');
            const articleElement = document.createElement('article');
            const p1Element = document.createElement('p');
            p1Element.textContent = `${playerElement.value}`;
            const p2Element = document.createElement('p');
            p2Element.textContent = `Score: ${scoreElement.value}`;
            const p3Element = document.createElement('p');
            p3Element.textContent = `Round: ${roundElement.value}`;
            const editElement = document.createElement('button');
            const okElement = document.createElement('button');
            articleElement.appendChild(p1Element);
            articleElement.appendChild(p2Element);
            articleElement.appendChild(p3Element);
            liElement.setAttribute('class', 'dart-item');
            editElement.setAttribute('class', 'btn edit');
            editElement.textContent = 'edit';
            okElement.setAttribute('class', 'btn ok');
            okElement.textContent = 'ok';
            liElement.appendChild(articleElement);
            liElement.appendChild(editElement);
            liElement.appendChild(okElement);
            sureListElement.appendChild(liElement);
            playerElement.value = '';
            scoreElement.value = '';
            roundElement.value = '';
            buttonElement.disabled = true;
            editElement.addEventListener('click', () => {
                playerElement.value = p1Element.textContent;
                scoreElement.value = p2Element.textContent.replace('Score: ', '');
                roundElement.value = p3Element.textContent.replace('Round: ', '');
                sureListElement.removeChild(liElement);
                buttonElement.disabled = false;
            });
            okElement.addEventListener('click', () => {
                editElement.remove();
                okElement.remove();
                scoreboardListElement.appendChild(liElement);
                buttonElement.disabled = false;
            });
        }
    })
    clearButtonElement.addEventListener('click', () => {
        location.reload();
    });
}
  