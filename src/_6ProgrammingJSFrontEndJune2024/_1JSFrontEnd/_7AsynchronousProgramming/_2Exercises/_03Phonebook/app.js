function attachEvents() {
    document.getElementById('btnLoad').addEventListener('click', loadPhonebook);
    document.getElementById('btnCreate').addEventListener('click', createContact);

    async function loadPhonebook() {
        const phonebookUl = document.getElementById('phonebook');
        phonebookUl.innerHTML = '';
        try {
            const response = await fetch('http://localhost:3030/jsonstore/phonebook');
            const data = await response.json();
            Object.entries(data).forEach(([key, contact]) => {
                const li = document.createElement('li');
                li.textContent = `${contact.person}: ${contact.phone}`;
                const deleteButton = document.createElement('button');
                deleteButton.textContent = 'Delete';
                deleteButton.addEventListener('click', () => deleteContact(key));
                li.appendChild(deleteButton);
                phonebookUl.appendChild(li);
            });
        } catch (error) {
            console.error('Error loading phonebook:', error);
        }
    }

    async function createContact() {
        const personInput = document.getElementById('person');
        const phoneInput = document.getElementById('phone');
        const person = personInput.value;
        const phone = phoneInput.value;

        if (person === '' || phone === '') {
            return alert('Both fields are required!');
        }

        try {
            await fetch('http://localhost:3030/jsonstore/phonebook', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ person, phone }),
            });

            personInput.value = '';
            phoneInput.value = '';
            loadPhonebook();
        } catch (error) {
            console.error('Error creating contact:', error);
        }
    }

    async function deleteContact(key) {
        try {
            await fetch(`http://localhost:3030/jsonstore/phonebook/${key}`, {
                method: 'DELETE',
            });
            loadPhonebook();
        } catch (error) {
            console.error('Error deleting contact:', error);
        }
    }

}

attachEvents();