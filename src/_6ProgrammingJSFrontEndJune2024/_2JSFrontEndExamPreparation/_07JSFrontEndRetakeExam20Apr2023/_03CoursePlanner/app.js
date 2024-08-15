function attachEvents() {
    const BASE_URL = 'http://localhost:3030/jsonstore/tasks';

    const nameElement = document.querySelector('#course-name');
    const typeElement = document.querySelector('#course-type');
    const descriptionElement = document.querySelector('#description');
    const teacherNameElement = document.querySelector('#teacher-name');

    const loadCourseButtonElements = document.querySelector('#load-course');
    const addCourseButtonElements = document.querySelector('#add-course');
    const editCourseButtonElements = document.querySelector('#edit-course');
    const divCourseListElements = document.querySelector('#list')
    const formElements = document.querySelector('#form form')

    loadCourseButtonElements.addEventListener('click', loadCourses);
    addCourseButtonElements.addEventListener('click', addCourses);
    editCourseButtonElements.addEventListener('click', editCourses);

    async function loadCourses() {
        divCourseListElements.innerHTML = '';
        const response = await fetch(BASE_URL);
        const result = await response.json();
        const courses = Object.values(result);
        const coursesElements = courses.map(course => createCourseElement(course.title, course.type, course.description, course.teacher, course._id));
        divCourseListElements.append(...coursesElements);
    }

    async function addCourses() {
        const name = nameElement.value;
        const type = typeElement.value;
        const description = descriptionElement.value;
        const teacher = teacherNameElement.value;

        clearInputs();

        await fetch(BASE_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({title: name, type: type, description: description, teacher: teacher}),
        });

        await loadCourses();
    }

    async function editCourses() {
        const courseID = formElements.getAttribute('data-course-id');
        const name = nameElement.value;
        const type = typeElement.value;
        const description = descriptionElement.value;
        const teacher = teacherNameElement.value;

        clearInputs();

        await fetch(`${BASE_URL}/${courseID}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({title: name, type: type, description: description, teacher:teacher, _id: courseID}),
        });

        await loadCourses();

        editCourseButtonElements.disabled = true;
        addCourseButtonElements.disabled = false;

        formElements.removeAttribute('data-course-id');
    }

    function createCourseElement(title, type, description, teacher, courseID) {
        const divVacationElement = document.createElement('div');
        divVacationElement.setAttribute('class', 'container');

        const h2TitleNameElement = document.createElement('h2');
        h2TitleNameElement.textContent = title;
        const h3TypeElement = document.createElement('h3');
        h3TypeElement.textContent = type;
        const h4DescriptionElement = document.createElement('h4');
        h4DescriptionElement.textContent = description;
        const h3TeacherElement = document.createElement('h3');
        h3TeacherElement.textContent = teacher;

        divVacationElement.appendChild(h2TitleNameElement);
        divVacationElement.appendChild(h3TeacherElement);
        divVacationElement.appendChild(h3TypeElement);
        divVacationElement.appendChild(h4DescriptionElement);

        const buttonEditElement = document.createElement('button');
        buttonEditElement.setAttribute('class', 'edit-btn');
        buttonEditElement.textContent = 'Edit Course';

        buttonEditElement.addEventListener('click', () => {
            nameElement.value = title;
            typeElement.value = type;
            descriptionElement.value = description;
            teacherNameElement.value = teacher;
            editCourseButtonElements.disabled = false;
            addCourseButtonElements.disabled = true;
            formElements.setAttribute('data-course-id', courseID);
        })

        const finishButtonElement = document.createElement('button');
        finishButtonElement.setAttribute('class', 'finish-btn');
        finishButtonElement.textContent = 'Finish Course';

        finishButtonElement.addEventListener('click', async () => {
            await fetch(`${BASE_URL}/${courseID}`, {
                method: 'DELETE',
            });

            await loadCourses();
        })


        divVacationElement.appendChild(buttonEditElement);
        divVacationElement.appendChild(finishButtonElement);

        return divVacationElement;
    }

    function clearInputs() {
        nameElement.value = '';
        typeElement.value = '';
        descriptionElement.value = '';
        teacherNameElement.value = '';
    }
}

attachEvents();