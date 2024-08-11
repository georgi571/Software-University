window.addEventListener("load", solve);

function solve() {
    const studentElement = document.querySelector('#student');
    const universityElement = document.querySelector('#university');
    const scoreElement = document.querySelector('#score');
    const buttonElement = document.querySelector('#next-btn');
    const previewListElement = document.querySelector('#preview-list');
    const candidatesListElement = document.querySelector('#candidates-list');
    buttonElement.addEventListener('click', (event) => {
        event.preventDefault();
        if (studentElement.value !== '' && universityElement.value !== '' && scoreElement.value !== '') {
            const liElement = document.createElement('li');
            const articleElement = document.createElement('article');
            const h4Element = document.createElement('h4');
            h4Element.textContent = `${studentElement.value}`;
            const p1Element = document.createElement('p');
            p1Element.textContent = `University: ${universityElement.value}`;
            const p2Element = document.createElement('p');
            p2Element.textContent = `Score: ${scoreElement.value}`;
            const editElement = document.createElement('button');
            const applyElement = document.createElement('button');
            articleElement.appendChild(h4Element);
            articleElement.appendChild(p1Element);
            articleElement.appendChild(p2Element);
            liElement.setAttribute('class', 'application');
            editElement.setAttribute('class', 'action-btn edit');
            editElement.textContent = 'edit';
            applyElement.setAttribute('class', 'action-btn apply');
            applyElement.textContent = 'apply';
            liElement.appendChild(articleElement);
            liElement.appendChild(editElement);
            liElement.appendChild(applyElement);
            previewListElement.appendChild(liElement);
            studentElement.value = '';
            universityElement.value = '';
            scoreElement.value = '';
            buttonElement.disabled = true;
            editElement.addEventListener('click', () => {
                studentElement.value = h4Element.textContent;
                universityElement.value = p1Element.textContent.replace('University: ', '');
                scoreElement.value = p2Element.textContent.replace('Score: ', '');
                previewListElement.removeChild(liElement);
                buttonElement.disabled = false;
            });
            applyElement.addEventListener('click', () => {
                editElement.remove();
                applyElement.remove();
                candidatesListElement.appendChild(liElement);
                buttonElement.disabled = false;
            });
        }
    })
}
  