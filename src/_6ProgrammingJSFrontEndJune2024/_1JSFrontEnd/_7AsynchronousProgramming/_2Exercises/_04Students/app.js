function attachEvents() {
    const baseURL = 'http://localhost:3030/jsonstore/collections/students';
    const tableBody = document.querySelector('#results tbody');
    const firstNameInput = document.querySelector('input[name="firstName"]');
    const lastNameInput = document.querySelector('input[name="lastName"]');
    const facultyNumberInput = document.querySelector('input[name="facultyNumber"]');
    const gradeInput = document.querySelector('input[name="grade"]');
    const notification = document.querySelector('.notification');

    async function createStudent() {
        const firstName = firstNameInput.value.trim();
        const lastName = lastNameInput.value.trim();
        const facultyNumber = facultyNumberInput.value.trim();
        const grade = gradeInput.value.trim();

        //
        if (!firstName || !lastName || !facultyNumber || !grade) {
            notification.textContent = 'All fields are required.';
            return;
        }

        const student = {
            firstName,
            lastName,
            facultyNumber,
            grade
        };

        try {
            const response = await fetch(baseURL, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(student)
            });

            if (!response.ok) {
                throw new Error(`Failed to create student: ${response.status} ${response.statusText}`);
            }

            clearForm();

            notification.textContent = 'Student created successfully.';
            setTimeout(() => {
                notification.textContent = '';
            }, 3000);

            loadStudents();
        } catch (error) {
            console.error('Error creating student:', error);
            notification.textContent = 'Failed to create student. Please try again.';
        }
    }

    async function loadStudents() {
        try {
            const response = await fetch(baseURL);
            if (!response.ok) {
                throw new Error(`Failed to fetch students: ${response.status} ${response.statusText}`);
            }
            const data = await response.json();

            tableBody.innerHTML = '';

            for (const key in data) {
                if (data.hasOwnProperty(key)) {
                    const student = data[key];
                    const row = document.createElement('tr');
                    row.innerHTML = `
                        <td>${student.firstName}</td>
                        <td>${student.lastName}</td>
                        <td>${student.facultyNumber}</td>
                        <td>${student.grade}</td>
                    `;
                    tableBody.appendChild(row);
                }
            }
        } catch (error) {
            console.error('Error loading students:', error);
            notification.textContent = 'Failed to load students. Please try again.';
        }
    }

    function clearForm() {
        firstNameInput.value = '';
        lastNameInput.value = '';
        facultyNumberInput.value = '';
        gradeInput.value = '';
    }

    const submitButton = document.getElementById('submit');
    submitButton.addEventListener('click', createStudent);

    loadStudents();
}

attachEvents();