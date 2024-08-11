window.addEventListener('load', solve);

function solve() {
    const taskIdElement = document.querySelector('#task-id');
    const titleElement = document.querySelector('#title');
    const descriptionElement = document.querySelector('#description');
    const labelElement = document.querySelector('#label');
    const pointsElement = document.querySelector('#points');
    const assigneeElement = document.querySelector('#assignee');
    const createTaskButtonElement = document.querySelector('#create-task-btn');
    const deleteTaskButtonElement = document.querySelector('#delete-task-btn');
    const taskSectionElement = document.querySelector('#tasks-section');
    const totalPointsElement = document.querySelector('#total-sprint-points');
    let counterId = 1;

    createTaskButtonElement.addEventListener('click', (event) => {
        event.preventDefault();
        if (titleElement.value !== '' && descriptionElement.value !== '' && labelElement.value !== '' && pointsElement.value !== '' && assigneeElement.value !== '') {
            const nextId = counterId++;
            const articleElement = document.createElement('article');
            articleElement.setAttribute('class', 'task-card');
            articleElement.setAttribute('id', `task-${nextId}`);
            const divLabelElement = document.createElement('div');
            let icon = '';
            if (labelElement.value === 'Feature') {
                divLabelElement.setAttribute('class', 'task-card-label feature');
                icon = '&#8865';
            } else if (labelElement.value === 'Low Priority Bug') {
                divLabelElement.setAttribute('class', 'task-card-label low-priority');
                icon = '&#9737';
            } else if (labelElement.value === 'High Priority Bug') {
                divLabelElement.setAttribute('class', 'task-card-label high-priority');
                icon = '&#9888';
            }
            const labelElementValue = labelElement.value;
            divLabelElement.innerHTML = `${labelElement.value} ${icon}`;
            const h3Element = document.createElement('h3');
            h3Element.setAttribute('class', 'task-card-title');
            h3Element.textContent = `${titleElement.value}`;
            const pElement = document.createElement('p');
            pElement.setAttribute('class', 'task-card-description');
            pElement.textContent = `${descriptionElement.value}`;
            const divPointsElement = document.createElement('div');
            divPointsElement.setAttribute('class', 'task-card-points');
            divPointsElement.textContent = `Estimated at ${pointsElement.value} pts`;
            const divAssigneeElement = document.createElement('div');
            divAssigneeElement.setAttribute('class', 'task-card-assignee');
            divAssigneeElement.textContent = `Assigned to: ${assigneeElement.value}`;
            const divActionElement = document.createElement('div');
            divActionElement.setAttribute('class', 'task-card-actions');
            const deleteButton = document.createElement('button');
            deleteButton.textContent = 'Delete';
            divActionElement.appendChild(deleteButton);
            articleElement.appendChild(divLabelElement);
            articleElement.appendChild(h3Element);
            articleElement.appendChild(pElement);
            articleElement.appendChild(divPointsElement);
            articleElement.appendChild(divAssigneeElement);
            articleElement.appendChild(divActionElement);
            const taskPoints = Number(parseInt(pointsElement.value));
            titleElement.value = '';
            descriptionElement.value = '';
            labelElement.value = '';
            pointsElement.value = '';
            assigneeElement.value = '';
            deleteTaskButtonElement.disabled = true;
            taskSectionElement.appendChild(articleElement);
            const points = Number(totalPointsElement.textContent.replace('Total Points ', '').replace('pts', ''));
            console.log(points);
            const newPoints = points + taskPoints;
            console.log(newPoints);
            totalPointsElement.textContent = `Total Points ${newPoints}pts`;
            deleteButton.addEventListener('click', () => {
                taskIdElement.value = articleElement.id;
                titleElement.value = h3Element.textContent;
                descriptionElement.value = pElement.textContent;
                labelElement.value = labelElementValue;
                pointsElement.value = divPointsElement.textContent.replace('Estimated at ', '').replace(' pts', '');
                assigneeElement.value = divAssigneeElement.textContent.replace('Assigned to: ', '');
                createTaskButtonElement.disabled = true;
                deleteTaskButtonElement.disabled = false;
                titleElement.disabled = true;
                descriptionElement.disabled = true;
                labelElement.disabled = true;
                pointsElement.disabled = true;
                assigneeElement.disabled = true;
            });
        }
    })

    deleteTaskButtonElement.addEventListener('click', (event) => {
            const taskId = taskIdElement.value;
            const taskElement = document.querySelector(`#${taskId}`);
            const taskPointsText = taskElement.querySelector('.task-card-points').textContent;
            const taskPoints = Number(taskPointsText.replace('Estimated at ', '').replace(' pts', ''));
            taskSectionElement.removeChild(taskElement);
            const points = Number(totalPointsElement.textContent.replace('Total Points ', '').replace('pts', ''));
            const newPoints = points - taskPoints;
            totalPointsElement.textContent = `Total Points ${newPoints}pts`;
            taskIdElement.value = '';
            createTaskButtonElement.disabled = false;
            deleteTaskButtonElement.disabled = true;
            titleElement.disabled = false;
            descriptionElement.disabled = false;
            labelElement.disabled = false;
            pointsElement.disabled = false;
            assigneeElement.disabled = false;
            titleElement.value = '';
            descriptionElement.value = '';
            labelElement.value = '';
            pointsElement.value = '';
            assigneeElement.value = '';
        }
    )
}