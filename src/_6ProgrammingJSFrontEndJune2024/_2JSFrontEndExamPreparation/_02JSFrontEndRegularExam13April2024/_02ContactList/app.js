window.addEventListener("load", solve);

function solve() {
    const nameElement = document.querySelector('#name');
    const phoneElement = document.querySelector('#phone');
    const categoryElement = document.querySelector('#category');
    const buttonElement = document.querySelector('#add-btn');
    const checkListElement = document.querySelector('#check-list')
    const contactListElement = document.querySelector('#contact-list')
    buttonElement.addEventListener('click', (event) => {
        event.preventDefault();
        if (nameElement.value !== '' && phoneElement.value !== '' && categoryElement.value !== '') {
            const liElement = document.createElement('li');
            const articleElement = document.createElement('article');
            const p1Element = document.createElement('p');
            p1Element.textContent = `name:${nameElement.value}`;
            const p2Element = document.createElement('p');
            p2Element.textContent = `phone:${phoneElement.value}`;
            const p3Element = document.createElement('p');
            p3Element.textContent = `category:${categoryElement.value}`;
            const divElement = document.createElement('div');
            const editElement = document.createElement('button');
            const saveElement = document.createElement('button');
            articleElement.appendChild(p1Element);
            articleElement.appendChild(p2Element);
            articleElement.appendChild(p3Element);
            divElement.setAttribute('class', 'buttons');
            editElement.setAttribute('class', 'edit-btn');
            saveElement.setAttribute('class', 'save-btn');
            divElement.appendChild(editElement);
            divElement.appendChild(saveElement);
            liElement.appendChild(articleElement);
            liElement.appendChild(divElement);
            checkListElement.appendChild(liElement);
            nameElement.value = '';
            phoneElement.value = '';
            categoryElement.value = '';
            checkListElement.addEventListener('click', () => {
                nameElement.value = p1Element.textContent.replace('name:', '');
                phoneElement.value = p2Element.textContent.replace('phone:', '');
                categoryElement.value = p3Element.textContent.replace('category:', '');
                checkListElement.removeChild(liElement);
            });
            saveElement.addEventListener('click', () => {
                divElement.remove();
                const deleteElement = document.createElement('button');
                deleteElement.setAttribute('class', 'del-btn');
                liElement.appendChild(deleteElement);
                contactListElement.appendChild(liElement);
                deleteElement.addEventListener('click', () => {
                    contactListElement.removeChild(liElement);
                });
            });
        }
    })
}
  