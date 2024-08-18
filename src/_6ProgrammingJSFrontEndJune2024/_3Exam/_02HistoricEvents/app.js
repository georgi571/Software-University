window.addEventListener("load", solve);

function solve() {
    const nameElement = document.querySelector('#name');
    const timeElement = document.querySelector('#time');
    const descriptionElement = document.querySelector('#description');
    const buttonElement = document.querySelector('#add-btn');
    const previewListElement = document.querySelector('#preview-list')
    const archiveList = document.querySelector('#archive-list')
    buttonElement.addEventListener('click', (event) => {
        event.preventDefault();
        if (nameElement.value !== '' && timeElement.value !== '' && descriptionElement.value !== '') {
            const liElement = document.createElement('li');
            const articleElement = document.createElement('article');

            const p1Element = document.createElement('p');
            p1Element.textContent = `${nameElement.value}`;
            const p2Element = document.createElement('p');
            p2Element.textContent = `${timeElement.value}`;
            const p3Element = document.createElement('p');
            p3Element.textContent = `${descriptionElement.value}`;

            const divElement = document.createElement('div');
            divElement.setAttribute('class', 'buttons')

            const editElement = document.createElement('button');
            editElement.setAttribute('class', 'edit-btn');
            editElement.textContent = 'Edit';

            const nextElement = document.createElement('button');
            nextElement.setAttribute('class', 'next-btn');
            nextElement.textContent = 'Next';

            articleElement.appendChild(p1Element);
            articleElement.appendChild(p2Element);
            articleElement.appendChild(p3Element);

            divElement.appendChild(editElement);
            divElement.appendChild(nextElement);

            liElement.appendChild(articleElement);
            liElement.appendChild(divElement);

            previewListElement.appendChild(liElement);

            nameElement.value = '';
            timeElement.value = '';
            descriptionElement.value = '';
            buttonElement.disabled = true;

            editElement.addEventListener('click', () => {
                nameElement.value = p1Element.textContent;
                timeElement.value = p2Element.textContent;
                descriptionElement.value = p3Element.textContent;
                previewListElement.removeChild(liElement);
                buttonElement.disabled = false;
            });
            nextElement.addEventListener('click', () => {
                divElement.remove();
                const archiveElement = document.createElement('button');
                archiveElement.setAttribute('class', 'archive-btn');
                archiveElement.textContent = 'Archive';

                liElement.appendChild(archiveElement);
                archiveList.appendChild(liElement);

                archiveElement.addEventListener('click', () => {
                    archiveList.removeChild(liElement);
                    buttonElement.disabled = false;
                });
            });
        }
    })
}
