window.addEventListener("load", solve);

function solve() {
    const taskTitleElement = document.querySelector('#task-title');
    const taskCategoryElement = document.querySelector('#task-category');
    const taskContentElement = document.querySelector('#task-content');
    const buttonElement = document.querySelector('#publish-btn');
    const reviewListElement = document.querySelector('#review-list');
    const publishedListElement = document.querySelector('#published-list');
    buttonElement.addEventListener('click', (event) => {
        event.preventDefault();
        if (taskTitleElement.value !== '' && taskCategoryElement.value !== '' && taskContentElement.value !== '') {
            const liElement = document.createElement('li');
            const articleElement = document.createElement('article');
            const h4Element = document.createElement('h4');
            h4Element.textContent = `${taskTitleElement.value}`;
            const p1Element = document.createElement('p');
            p1Element.textContent = `Category: ${taskCategoryElement.value}`;
            const p2Element = document.createElement('p');
            p2Element.textContent = `Content: ${taskContentElement.value}`;
            const editElement = document.createElement('button');
            const postElement = document.createElement('button');
            articleElement.appendChild(h4Element);
            articleElement.appendChild(p1Element);
            articleElement.appendChild(p2Element);
            liElement.setAttribute('class', 'rpost');
            editElement.setAttribute('class', 'action-btn edit');
            editElement.textContent = 'Edit';
            postElement.setAttribute('class', 'action-btn post');
            postElement.textContent = 'Post';
            liElement.appendChild(articleElement);
            liElement.appendChild(editElement);
            liElement.appendChild(postElement);
            reviewListElement.appendChild(liElement);
            taskTitleElement.value = '';
            taskCategoryElement.value = '';
            taskContentElement.value = '';
            buttonElement.disabled = true;
            editElement.addEventListener('click', () => {
                taskTitleElement.value = h4Element.textContent;
                taskCategoryElement.value = p1Element.textContent.replace('Category: ', '');
                taskContentElement.value = p2Element.textContent.replace('Content: ', '');
                reviewListElement.removeChild(liElement);
                buttonElement.disabled = false;
            });
            postElement.addEventListener('click', () => {
                editElement.remove();
                postElement.remove();
                publishedListElement.appendChild(liElement);
                buttonElement.disabled = false;
            });
        }
    })
}